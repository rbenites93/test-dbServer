package com.automationpractice.executation;

import java.util.Random;

import com.automationpractice.pageobject.AutomationPage;

public class AutomationPracticeExecutation {
	
	String url = "http://www.automationpractice.com/";
	Random rand = new Random();
	AutomationPage site = new AutomationPage(url);
	String emailContaNOva = "testeDbserver"+rand.nextInt(9999)+"@teste.com.br";
		
		public void enviaCompraProduto() {
		
			site.Acessar();
			site.PesquisaProduto();
			site.AdicionaProdutoCarrinho();
			site.validaProdutoCarrinho();
			site.checkout();
			site.createCount(emailContaNOva);
			site.cadastro();
			site.validaEnderecoUsuario();
			site.validaTermo();
			site.validaValor();
			site.formaPagamento();
			site.confirmaCompra();
			site.validaCompraSucesso();
			site.fecharInstancia();
			

		}
		
		
}

