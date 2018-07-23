package com.automationpractice.test;

import org.testng.annotations.Test;
import com.automationpractice.executation.AutomationPracticeExecutation;

public class AutomationTest {	
	
	AutomationPracticeExecutation automation = new AutomationPracticeExecutation();
		
		@Test
		public void ValidaCompra() {
			 
			automation.enviaCompraProduto();
			
		}
		
	}