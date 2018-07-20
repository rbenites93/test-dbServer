package com.automationpractice.executation;

import com.automationpractice.pageobject.AutomationPage;

public class AutomationPracticeExecutation {
	
		
		public void eviaCompraProduto() {

//			String url = "http://www.automationpractice.com/";
			String url = "http://www.google.com/";
			
		
			AutomationPage envia = new AutomationPage(url);

			
			envia.logar();
			
			
			
//			envia.logar();
//			envia.loginGiss(loginGiss, senhaGiss);
//			envia.clicaPgdasD();
//			envia.enviaArquivoPgdasD();
//			envia.clicaProcessar();			
//			envia.fecharInstancia();

		}
		
		
}

