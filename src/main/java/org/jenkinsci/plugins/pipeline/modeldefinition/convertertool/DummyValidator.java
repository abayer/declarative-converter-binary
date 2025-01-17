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

import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTAgent;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTAxis;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTAxisContainer;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTBranch;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTBuildCondition;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTBuildConditionsContainer;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTBuildParameter;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTBuildParameters;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTEnvironment;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTExclude;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTExcludeAxis;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTExcludes;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTInternalFunctionCall;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTLibraries;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTMatrix;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTMethodCall;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTOption;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTOptions;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTParallel;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTPipelineDef;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTPostBuild;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTPostStage;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTStage;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTStageBase;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTStageInput;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTStages;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTStep;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTTools;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTTrigger;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTTriggers;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTValue;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTWhen;
import org.jenkinsci.plugins.pipeline.modeldefinition.ast.ModelASTWhenCondition;
import org.jenkinsci.plugins.pipeline.modeldefinition.validator.ModelValidator;

public class DummyValidator implements ModelValidator {
    @Override
    public boolean validateElement(ModelASTAgent modelASTAgent) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTBranch modelASTBranch) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTBuildConditionsContainer modelASTBuildConditionsContainer) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTPostBuild modelASTPostBuild) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTPostStage modelASTPostStage) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTBuildCondition modelASTBuildCondition) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTEnvironment modelASTEnvironment) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTTools modelASTTools) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTStep modelASTStep) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTWhen modelASTWhen) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTMethodCall modelASTMethodCall) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTOptions modelASTOptions) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTTriggers modelASTTriggers) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTBuildParameters modelASTBuildParameters) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTOption modelASTOption) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTTrigger modelASTTrigger) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTBuildParameter modelASTBuildParameter) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTPipelineDef modelASTPipelineDef) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTStageBase modelASTStageBase) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTStage modelASTStage, boolean b) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTStages modelASTStages) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTParallel modelASTParallel) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTMatrix modelASTMatrix) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTAxisContainer modelASTAxisContainer) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTAxis modelASTAxis) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTExcludes modelASTExcludes) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTExclude modelASTExclude) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTExcludeAxis modelASTExcludeAxis) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTLibraries modelASTLibraries) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTWhenCondition modelASTWhenCondition) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTInternalFunctionCall modelASTInternalFunctionCall) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTStageInput modelASTStageInput) {
        return true;
    }

    @Override
    public boolean validateElement(ModelASTValue modelASTValue) {
        return true;
    }
}
