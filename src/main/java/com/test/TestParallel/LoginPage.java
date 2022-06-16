package com.test.TestParallel;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.cucumber.datatable.DataTable;


public class LoginPage
{
	WebDriver driver;
	   private String userRole;
	   public LoginPage(WebDriver driver) {
	      this.driver = driver;
	      PageFactory.initElements(this.driver, this);
	   }
	   @FindBy(name="uname")
	   private WebElement inputUserName;
	   @FindBy(name="psw")
	   private WebElement inputPassword;
	   @FindBy(xpath="//button[text()='Login']")
	   private WebElement btnLogin;
	   @FindBy(xpath="//div[@class='d-flex' and contains(.,'Congratulations!') and contains(.,'Login Successfully!')]")
	   private WebElement txtSuccessMessage;
	   
	   public Map<String, String> getDataAsMap(DataTable dataTable) {
	      Map<String, String> dataMap = dataTable.asMap(String.class, 
	      String.class);
	      return dataMap;
	   }
	public void enterLoginCredentialsAndClickOnLogin(String userName,      String password) {
	   inputUserName.sendKeys(userName);
	   inputPassword.sendKeys(password);
	   btnLogin.click();
	   }
	public void loginWithValidCredentials(Map<String, String> dataMap) {
	   String userName = null;
	   String password = null;
	   userRole = dataMap.get("userRole");
	   if(userRole.equalsIgnoreCase("OUTLET")) {
	      userName = "branch";
	      password = "test123";
	   }else if(userRole.equalsIgnoreCase("SUPPLIER")) {
	      userName = "supplier";
	      password = "test123";
	   }
	   enterLoginCredentialsAndClickOnLogin(userName, password);
	   }
	public boolean verifySuccessfullLogin() {
	      boolean isLoginSuccessful = false;
	      try {
	         if(txtSuccessMessage.isDisplayed()) {
	            System.out.println("Successfully Login in to Application");
	            isLoginSuccessful = true;
	         }
	      }catch(Exception e){
	          System.out.println("Issue with Login into application");
	          isLoginSuccessful = false;
	      }
	   return isLoginSuccessful;
	   }
}
