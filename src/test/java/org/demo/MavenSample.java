package org.demo;

import java.io.IOException;

import org.helper.BaseClass;
import org.openqa.selenium.WebElement;
import org.pom.PojoClass;


public class MavenSample extends BaseClass {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		ChromeBrowser();
		urlLaunch("https://www.facebook.com/");
		PojoClass po=new PojoClass();
		WebElement user = po.getUser();
		passValues(user,readFromExcel("details", "login", 1, 0));
		
		
		
		
		
		
		
		
		
	}
				
	}

