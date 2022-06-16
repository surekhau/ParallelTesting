package com.test.TestParallel;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps{
   WebDriver driver;
   LoginPage loginPage = null;
   
   @Given("^I am on login page$")
   public void i_am_on_login_page() {
	   System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	   driver.get("https://polite-tree-0312ffd10.1.azurestaticapps.net/");
   }
   
   @When("^I login with valid user credentials$")
   public void i_login_with_valid_user_credentials(
                                           DataTable dataTable)
   {
      loginPage = new LoginPage(driver);
      Map<String, String> dataMap 
                            = loginPage.getDataAsMap(dataTable);
      loginPage.loginWithValidCredentials(dataMap);
   }
@Then("^I can login successfully$")
   public void i_can_login_successfully() 
   {
      Assert.assertTrue(loginPage.verifySuccessfullLogin(),
                       "Have issue with Login");
      driver.close();
   }
}

