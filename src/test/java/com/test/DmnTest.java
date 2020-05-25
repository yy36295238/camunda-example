package com.test;

import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnDecisionResult;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.test.DmnEngineRule;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.junit.Rule;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author yangyu
 * @create 2020/5/25 上午10:31
 */
public class DmnTest {

    @Rule
    public DmnEngineRule dmnEngineRule = new DmnEngineRule();

    @Test
    public void test() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("/Users/yangyu/Desktop/diagram_1.dmn");
        DmnEngine dmnEngine = dmnEngineRule.getDmnEngine();
        // load DMN file
        //create and add variables
        VariableMap variables = Variables.createVariables();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("age", 1);
        paramMap.put("gender", "F");
        variables.putValue("data", paramMap);


        DmnDecision decision = dmnEngine.parseDecision("Decision_1rf581x", inputStream);
        DmnDecisionResult result = dmnEngine.evaluateDecision(decision, variables);
        System.out.println(result.getResultList());

        // assert the result
        // ...
    }

}
