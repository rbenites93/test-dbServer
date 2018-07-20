package com.automationpractice.pageobject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.automationpractice.setup.DriverPage;

public class AutomationPage extends DriverPage {

		DiretoriosGravacaoEvidenciasPage caminhoEvidenciasPgdas = new DiretoriosGravacaoEvidenciasPage();
	

	int numPG = 0;
	private String url;
	private Path diretorioGravacaoEvidencias;
	private String caminhoGravacaoPgdas = caminhoEvidenciasPgdas.getCaminhoPgdasD();
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy");


	public AutomationPage(String url) {
		super();
		this.url = url;
		
//		iniciarDiretorioEvidencias();
		
	}


	private void iniciarDiretorioEvidencias() {

		try {

			Path diretorioEvidencia = Paths.get(caminhoGravacaoPgdas);
				
			String dirHoje = sdf.format(new Date());

			Path diretorioEvidenciaHoje = Paths.get(diretorioEvidencia.toString() + "/" + dirHoje);
			System.out.println(diretorioEvidenciaHoje);
			if (!Files.exists(diretorioEvidenciaHoje)) {
				Files.createDirectory(diretorioEvidenciaHoje);
				
			}

			String urlFormatada = "auditor.giss.com.br";
			
			String municipio = urlFormatada.substring(0, urlFormatada.indexOf("br"));

			Path diretorioUrl = Paths.get(diretorioEvidenciaHoje.toString() + "/" + municipio);
		
			if (!Files.exists(diretorioUrl)) {
				Files.createDirectory(diretorioUrl);
			}

			diretorioGravacaoEvidencias = Paths.get(diretorioUrl.toString());
			
			if (!Files.exists(diretorioGravacaoEvidencias)) {
				
				Files.createDirectory(diretorioGravacaoEvidencias);
			}

		} catch (IOException e) {
			System.out.println("Não foi possível criar os diretorios de evidencias. Fechando robo ");
			System.exit(-1);
		}

	}

	public AutomationPage logar() {
		
		LoginPage login = new LoginPage(getDriver());
		login.loginSite(url);
		return this;
	}
	
	
}
