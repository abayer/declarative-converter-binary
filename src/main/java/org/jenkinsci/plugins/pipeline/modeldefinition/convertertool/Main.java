/*
 * The MIT License
 *
 * Copyright (c) 2020, CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.jenkinsci.plugins.pipeline.modeldefinition.convertertool;

import com.cloudbees.groovy.cps.NonCPS;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import groovy.lang.GroovyClassLoader;
import org.codehaus.groovy.control.CompilationFailedException;
import org.codehaus.groovy.control.CompilationUnit;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.control.customizers.ImportCustomizer;
import org.jenkinsci.plugins.pipeline.modeldefinition.DescriptorLookupCache;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTPipelineDef;
import org.jenkinsci.plugins.pipeline.modeldefinition.parser.ModelParser;
import org.jenkinsci.plugins.pipeline.modeldefinition.validator.ErrorCollector;
import org.jenkinsci.plugins.pipeline.modeldefinition.validator.ModelValidator;
import org.jenkinsci.plugins.pipeline.modeldefinition.validator.SourceUnitErrorCollector;
import org.jenkinsci.plugins.scriptsecurity.sandbox.groovy.GroovySandbox;
import org.jenkinsci.plugins.workflow.cps.GroovyShellDecorator;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.CodeSource;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.List;

import static groovy.lang.GroovyShell.DEFAULT_CODE_BASE;
import static org.codehaus.groovy.control.Phases.CONVERSION;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> argList = Arrays.asList(args);

        String script = Files.readString(Path.of(argList.get(0)));
        try {
            ModelASTPipelineDef def = scriptToPipelineDef(script);
            System.out.println(def.toJSON().toString(2));
        } catch (Exception e) {
            System.err.println("Hit an exception: " + e);
        }
    }

    private static CompilerConfiguration makeCompilerConfiguration() {
        CompilerConfiguration cc = GroovySandbox.createBaseCompilerConfiguration();

        ImportCustomizer ic = new ImportCustomizer();
        ic.addStarImports(NonCPS.class.getPackage().getName());
        ic.addStarImports("hudson.model","jenkins.model");
        cc.addCompilationCustomizers(ic);

        return cc;
    }

    @SuppressFBWarnings(value = "UPM_UNCALLED_PRIVATE_METHOD")
    private static ModelASTPipelineDef compilationUnitToPipelineDef(CompilationUnit cu) {
        final ModelASTPipelineDef[] model = new ModelASTPipelineDef[1];

        cu.addPhaseOperation(new CompilationUnit.SourceUnitOperation() {
            @Override
            public void call(SourceUnit source) throws CompilationFailedException {
                if (model[0] == null) {
                    ErrorCollector errorCollector = new SourceUnitErrorCollector(source);
                    ModelValidator validator = new DummyValidator();
                    try {
                        model[0] = new ModelParser(source, null, errorCollector, validator, new DescriptorLookupCache()).parse(true);
                    } catch (Exception e) {
                        System.err.println("Exception: " + e.getMessage());
                        throw e;
                    }
                }
            }
        }, CONVERSION);

        cu.compile(CONVERSION);

        return model[0];
    }

    private static ModelASTPipelineDef scriptToPipelineDef(String script) throws MalformedURLException {
        CompilationUnit cu = new CompilationUnit(
                makeCompilerConfiguration(),
                new CodeSource(new URL("file", "", DEFAULT_CODE_BASE), (Certificate[]) null),
                new GroovyClassLoader(ClassUtils.getDefaultClassLoader()));
        cu.addSource("WorkflowScript", script);

        return compilationUnitToPipelineDef(cu);
    }
}
