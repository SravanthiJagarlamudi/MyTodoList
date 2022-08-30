package com.inetBanking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {

	private WebDriver driver;
	
	public LoginPage(WebDriver rdriver){
		this.driver= rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	
	@FindBy(name ="uid")
	private WebElement txtUsername;
	
	@FindBy(name ="password")
	private WebElement txtPassword;
	
	@FindBy(name ="btnLogin")
	private WebElement btnLogin;
	
	//Below are the action methods//
	public void setUsername(String uname) {
		txtUsername.sendKeys(uname);
	}
	
	public void setpassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clicksubmit() {
		btnLogin.click();
	}
	
}
