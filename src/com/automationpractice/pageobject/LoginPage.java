package com.automationpractice.pageobject;

import org.openqa.selenium.WebDriver;

public class LoginPage {
		
		private WebDriver driver;

		public LoginPage(WebDriver driver) {
			this.driver = driver;
		}

		private LoginPage openHomePage(String url) {
			driver.get(url);
			driver.manage().window().maximize();
			System.out.println("Site Acessado com sucesso");
			
			return this;
		}

		public LoginPage loginSite(String url) {

			openHomePage(url);
			
			return this;
		}

}
