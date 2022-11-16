package org.pom;

import org.helper.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class PojoClass extends BaseClass {
	

	
	public PojoClass() {
	PageFactory.initElements(d, this);	
	}
	
	@FindBy(id="email")
	private WebElement user;
	
	@FindBys({
		
		@FindBy(id="pass"),
		@FindBy(name="pass")
	}) 
	private WebElement p;
	
	@FindAll({
		
		@FindBy(name="login"),
		@FindBy(id="Button")
	})
	
	private WebElement login;

	public WebElement getUser() {
		return user;
	}

	public WebElement getP() {
		return p;
	}

	public WebElement getLogin() {
		return login;
	}
	
	
	
	
	

}
