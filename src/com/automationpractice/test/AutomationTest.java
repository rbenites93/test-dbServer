package com.automationpractice.test;

import org.testng.annotations.Test;

import com.automationpractice.executation.AutomationPracticeExecutation;

public class AutomationTest {
	
	
		AutomationPracticeExecutation envia = new AutomationPracticeExecutation();
		
		@Test
		public void ValidaCompra() {
			 
			envia.eviaCompraProduto();
			
		}
		

}





//package br.com.eicon.robo.qualidade.test;
//
//import static com.aventstack.extentreports.markuputils.ExtentColor.GREEN;
//import static com.aventstack.extentreports.markuputils.ExtentColor.RED;
//import static com.aventstack.extentreports.markuputils.ExtentColor.YELLOW;
//import static com.aventstack.extentreports.markuputils.MarkupHelper.createLabel;
//
//import org.testng.Assert;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//
//import br.com.eicon.robo.qualidade.pageobject.TomadorDaConstrucaoCivilProdesaPage;
//import br.com.eicon.robo.qualidade.paginasbases.DiretoriosGravacaoEvidenciasPage;
//import br.com.eicon.robo.qualidade.relatorios.ExtentManagerTest;
//
//public class ProdesaTest{
//	
//	ExtentReports extent;
//	ExtentTest test;
//	private TomadorDaConstrucaoCivilProdesaPage tomadorConstrucao;
//	DiretoriosGravacaoEvidenciasPage caminhoProdesa = new DiretoriosGravacaoEvidenciasPage();
//	
//
//	String descricao1 = "CASO DE TESTE 01 - PRESTADOR AUTO CADASTRADO COM O SERVICO DE AEROPORTO (BENEFICIO) CONFIGURADA, USANDO UM TOMADOR DE DENTRO QUE TEM O SERVICO CADASTRADO.  ATIVIDADE APRESENTADA OK";
//	String descricao2 = "CASO DE TESTE 02 - PRESTADOR AUTO CADASTRADO SEM O SERVICO DE AEROPORTO (BENEFICIO) CONFIGURADA, USANDO UM TOMADOR DE DENTRO QUE NAO TEM O SERVICO CADASTRADO.  ATIVIDADE NAO APRESENTADA OK";
//	String descricao3 = "CASO DE TESTE 03 - PRESTADOR DE DENTRO DO MUNICIPIO COM O SERVICO DE AEROPORTO(BENEFICIO) CONFIGURADA, USANDO UM TOMADOR DE DENTRO QUE NAO TEM O SERVICO CADASTRADO.  ATIVIDADE NAO APRESENTADA OK";
//	String descricao4 = "CASO DE TESTE 04 - PRESTADOR DE DENTRO DO MUNICIPIO SEM O SERVICO DE AEROPORTO(BENEFICIO) CONFIGURADA, USANDO UM TOMADOR DE DENTRO QUE NAO TEM O SERVICO CADASTRADO.  ATIVIDADE NAO APRESENTADA OK";
//	String descricao5 = "CASO DE TESTE 05 - PRESTADOR DE FORA DO PAIS, USANDO TOMADOR DE DENTRO QUE NAO TEM O SERVICO CADASTRADO.  ATIVIDADE NAO APRESENTADA OK";
//	
//	private static int numPG = 0;
//	private String caminhoProdesaRelatorioImagens = caminhoProdesa.getCaminhoProdesaRelImagens();
//	
//	@BeforeMethod 	
//	public void login() {
//		extent = ExtentManagerTest.GetExtent();
//		tomadorConstrucao = new TomadorDaConstrucaoCivilProdesaPage();
//		tomadorConstrucao.logar();
//	}	
//	
//	@Test 
//	public void CasoDeTeste01(){
//		test = extent.createTest("caso 01",descricao1 );
//		//RESULTADO = VERDADEIRO
//		tomadorConstrucao.validarTomadorConstrucaoProdesa("05", "2017", "B", "18886130000139");
//		boolean teste = tomadorConstrucao.validaAtividades();
//		tomadorConstrucao.validaServicoProdesa();
//		Assert.assertTrue(teste);
//	}
//	
//	@Test
//	public void CasoDeTeste02(){
//		test = extent.createTest("caso 02",descricao2);
//		//RESULTADO = FALSO
//		tomadorConstrucao.validarTomadorConstrucaoProdesa("05", "2017", "A", "17776130000113");
//		boolean teste = tomadorConstrucao.validaAtividades();
//		Assert.assertFalse(teste);
//	}
//
//	@Test
//	public void CasoDeTeste03() {
//		test = extent.createTest("caso 03",descricao3);
//		//RESULTADO = FALSO
//		tomadorConstrucao.validarTomadorConstrucaoProdesa("05", "2017", "C", "89955896000176");
//		boolean teste = tomadorConstrucao.validaAtividades();
//		Assert.assertFalse(teste);
//	}
//	@Test
//	public void CasoDeTeste04(){
//		test = extent.createTest("caso 04",descricao4);
//		//RESULTADO = FALSO
//		tomadorConstrucao.validarTomadorConstrucaoProdesa("05", "2017", "D", "27702111000104");
//		boolean teste = tomadorConstrucao.validaAtividades();
//		Assert.assertFalse(teste);
//		
//	}
//	@Test
//	public void CasoDeTeste05(){
//		test = extent.createTest("caso 05",descricao5);
//		//RESULTADO = FALSO
//		tomadorConstrucao.validarTomadorConstrucaoProdesaForaPais("05", "2017", "A", "fora do pais");
//		boolean teste = tomadorConstrucao.validaAtividades();
//		Assert.assertFalse(teste);
//	
//	}
//	@AfterMethod
//	public void afterMethod(ITestResult result) throws Exception {
//
//		String erro = "NOK ";
//		
//		tomadorConstrucao.capturaTela(numPG);
//		
//		numPG = numPG +1;
//		
//		String caminho = caminhoProdesaRelatorioImagens + numPG +".jpg";
//
//		if (result.getStatus() == ITestResult.FAILURE) {
//			test.log(Status.FAIL, createLabel("Teste Falhou!", RED));
//			test.log(Status.FAIL, createLabel(erro + test.addScreenCaptureFromPath(caminho), RED));
//			
//		}if (result.getStatus() == ITestResult.SKIP) {
//			
//			test.log(Status.SKIP, createLabel("Este teste foi ignorado " + test.addScreenCaptureFromPath(caminho), YELLOW));
//		} if 
//			(result.getStatus() == ITestResult.SUCCESS){
//			test.log(Status.PASS, createLabel("TESTE CONCLUIDO COM SUCESSO" + test.addScreenCaptureFromPath(caminho), GREEN));
//		}
//		extent.flush();
//		tomadorConstrucao.getDriver().quit();
//	}
//}
//
//

	


