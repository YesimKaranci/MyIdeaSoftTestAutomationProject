package com.ideasoft.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features/Test.feature"
        , glue = "com.ideasoft.tests"
,tags = "@regression")
public class CucumberRunner {

}

