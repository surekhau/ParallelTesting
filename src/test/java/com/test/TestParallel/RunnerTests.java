package com.test.TestParallel;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		tags = "@test", 
		features = "src/test/resource/features", 
		glue = "com/test/TestParallel")

public class RunnerTests extends AbstractTestNGCucumberTests {
   @Override
   @DataProvider(parallel = true)
   public Object[][] scenarios() {
	   return super.scenarios();
   }
}