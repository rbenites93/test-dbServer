package com.automationpractice.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverPage {

		private WebDriver driver;
		private String caminhoDriver = "Lib/chromedriver.exe";
		
		 
		public DriverPage() {
			
			System.setProperty("webdriver.chrome.driver", caminhoDriver);
			driver = new ChromeDriver();
			
		}
		
		public WebDriver getDriver(){
			return driver;
		}		

}
