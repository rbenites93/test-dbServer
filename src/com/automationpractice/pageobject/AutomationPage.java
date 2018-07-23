package com.automationpractice.pageobject;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.automationpractice.setup.DriverPage;

public class AutomationPage extends DriverPage {

	DiretoriosGravacaoEvidenciasPage caminhoEvidenciasPgdas = new DiretoriosGravacaoEvidenciasPage();
	Actions act = new Actions(getDriver());

	int numPG = 0;
	private String url;
	private Path diretorioGravacaoEvidencias;
	private String caminhoGravacaoEvidencia = caminhoEvidenciasPgdas.getCaminhoEvid();
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy");

	public AutomationPage(String url) {
		super();
		this.url = url;

		iniciarDiretorioEvidencias();
	}

	public AutomationPage Acessar() {

		LoginPage login = new LoginPage(getDriver());
		login.loginSite(url);

		return this;
	}

	public AutomationPage PesquisaProduto() {

		capturaTela();
		getDriver().findElement(By.id("search_query_top")).sendKeys("Blouse");
		getDriver().findElement(By.name("submit_search")).click();

		return this;
	}

	public AutomationPage AdicionaProdutoCarrinho() {

		WebElement divCenter = getDriver().findElement(By.id("center_column"));
		divCenter.findElement(By.linkText("Add to cart")).click();

		esperar(2000);

		capturaTela();
		WebElement divLayer = getDriver().findElement(By.id("layer_cart"));
		WebElement clearfix = divLayer.findElement(By.className("clearfix"));
		WebElement layerProduct = clearfix
				.findElement(By.cssSelector("[class='layer_cart_product col-xs-12 col-md-6']"));
		layerProduct.findElement(By.className("cross")).click();

		return this;
	}

	public AutomationPage validaProdutoCarrinho() {

		WebElement divHeader = getDriver().findElement(By.id("header"));
		WebElement cart = divHeader.findElement(By.cssSelector("[title='View my shopping cart']"));
		cart.click();

		capturaTela();
		WebElement valida = getDriver().findElement(By.id("product_2_7_0_0"));
		WebElement valida2 = valida.findElement(By.cssSelector("[class='product-name']"));
		WebElement valida3 = valida2.findElement(By.tagName("a"));
		String validaBlusa = valida3.getText();
		boolean validando = validaBlusa.equals("Blouse");

		if (validando == true) {

			System.out.println("Blusa Adicionada corretamente " + validando);
		} else {
			System.out.println("Por favor verifique o carrinho produto adicionado incorretamente");
		}

		return this;
	}

	public AutomationPage checkout() {

		act.sendKeys(Keys.PAGE_DOWN);
		act.perform();
		esperar(1000);
		capturaTela();
		
		WebElement divLayer = getDriver().findElement(By.id("center_column"));
		WebElement divButton = divLayer.findElement(By.linkText("Proceed to checkout"));
		divButton.click();

		return this;

	}

	public AutomationPage createCount(String emailContaNOva) {

		getDriver().findElement(By.id("email_create")).sendKeys(emailContaNOva);
		capturaTela();
		getDriver().findElement(By.id("SubmitCreate")).click();

		return this;
	}

	public AutomationPage cadastro() {

		esperar(2000);
		WebElement masculino = getDriver().findElement(By.id("account-creation_form"));
		WebElement masculino2 = masculino.findElement(By.className("clearfix"));
		WebElement masculino3 = masculino2.findElement(By.cssSelector("[class='radio-inline']"));
		masculino3.click();
		capturaTela();
		getDriver().findElement(By.id("customer_firstname")).sendKeys("Teste");
		capturaTela();
		getDriver().findElement(By.id("customer_lastname")).sendKeys("Dbserver");
		capturaTela();
		getDriver().findElement(By.id("passwd")).sendKeys("dbserver2018");
		capturaTela();
		getDriver().findElement(By.id("days")).sendKeys("5");
		getDriver().findElement(By.id("months")).sendKeys("April ");
		getDriver().findElement(By.id("years")).sendKeys("1993");
		capturaTela();
		getDriver().findElement(By.id("company")).sendKeys("teste03");
		capturaTela();
		getDriver().findElement(By.id("address1")).sendKeys("Street");
		capturaTela();
		getDriver().findElement(By.id("address2")).sendKeys("suite");
		getDriver().findElement(By.id("city")).sendKeys("Sao Paulo");
		capturaTela();
		getDriver().findElement(By.id("id_state")).sendKeys("Texas");
		capturaTela();
		getDriver().findElement(By.id("postcode")).sendKeys("12345");
		capturaTela();
		getDriver().findElement(By.id("id_country")).sendKeys("United States");
		capturaTela();
		getDriver().findElement(By.id("other")).sendKeys("Adicionando INFO");
		capturaTela();
		getDriver().findElement(By.id("phone")).sendKeys("1399999999");
		getDriver().findElement(By.id("phone_mobile")).sendKeys("13999998888");
		capturaTela();
		getDriver().findElement(By.id("submitAccount")).click();

		return this;
	}

	public AutomationPage validaEnderecoUsuario() {

		WebElement endereco = getDriver().findElement(By.id("address_delivery"));
		WebElement rua = endereco
				.findElement(By.cssSelector("[class='address_city address_state_name address_postcode']"));
		String enderecoEntrega = rua.getText();
		Boolean validaEndereco = enderecoEntrega.equals("Sao Paulo, Texas 12345");

		if (validaEndereco) {
			System.out.println("Validando endereço " + validaEndereco);
		} else {
			System.out.println("Endereço Incorreto, por favor verifique!");
		}
		
		act.sendKeys(Keys.PAGE_DOWN);
		act.perform();
		esperar(1000);
		capturaTela();

		WebElement divLayer = getDriver().findElement(By.id("center_column"));
		WebElement divForm = divLayer.findElement(By.cssSelector("[method='post']"));
		WebElement divP = divForm.findElement(By.cssSelector("[class='cart_navigation clearfix']"));
		WebElement divButton = divP.findElement(By.cssSelector("[name='processAddress']"));
		divButton.click();

		return this;

	}

	public AutomationPage validaTermo() {

		getDriver().findElement(By.id("uniform-cgv")).click();
		act.sendKeys(Keys.PAGE_DOWN);
		act.perform();
		capturaTela();
		WebElement divLayer = getDriver().findElement(By.id("center_column"));
		WebElement divForm = divLayer.findElement(By.id("form"));
		WebElement divP = divForm.findElement(By.cssSelector("[class='cart_navigation clearfix']"));
		WebElement divButton = divP.findElement(By.cssSelector("[name='processCarrier']"));
		divButton.click();

		return this;
	}

	public AutomationPage validaValor() {

		WebElement valorTotal = getDriver().findElement(By.id("total_price"));
		String validaValor = valorTotal.getText();
		boolean validando = validaValor.equals("$29.00");

		if (validando == true) {

			System.out.println("Valor Calculado corretamente " + validando);
		} else {
			System.out.println("Por favor verifique os valores algo está incorreto");
		}
		
		act.sendKeys(Keys.PAGE_DOWN);
		act.perform();
		esperar(1000);
		capturaTela();

		return this;
	}

	public AutomationPage formaPagamento() {

		WebElement payment = getDriver().findElement(By.id("HOOK_PAYMENT"));
		WebElement row = payment.findElement(By.className("row"));
		WebElement divCol = row.findElement(By.cssSelector("[class='col-xs-12 col-md-6']"));
		WebElement paymentBank = divCol.findElement(By.cssSelector("[class='bankwire']"));
		act.sendKeys(Keys.PAGE_DOWN);
		act.perform();
		esperar(1000);
		capturaTela();
		paymentBank.click();

		return this;
	}

	public AutomationPage confirmaCompra() {

		WebElement navigation = getDriver().findElement(By.id("cart_navigation"));
		WebElement confirm = navigation.findElement(By.cssSelector("[class='button btn btn-default button-medium']"));

		act.sendKeys(Keys.PAGE_DOWN);
		act.perform();
		esperar(1000);
		capturaTela();

		confirm.click();
		return this;
	}

	public AutomationPage validaCompraSucesso() {

		WebElement divCenter = getDriver().findElement(By.id("center_column"));
		WebElement pegaConfirmacao = divCenter.findElement(By.cssSelector("[class='cheque-indent']"));
		String confirmaCompra = pegaConfirmacao.getText();
		Boolean msgSucesso = confirmaCompra.equals("Your order on My Store is complete.");
		if (msgSucesso) {
			System.out.println("Confirmando msg de sucesso " + msgSucesso);
		} else {
			System.out.println("Erro msg final, por favor verifique se a compra foi efetuada corretamente");
		}
		
		act.sendKeys(Keys.PAGE_DOWN);
		act.perform();
		esperar(1000);
		capturaTela();
		
		return this;
	}

	public AutomationPage fecharInstancia() {

		esperar(1000);
		System.out.println("Processo finalizado fechando navegador");
		getDriver().quit();

		return this;
	}

	public void esperar(int seg) {

		try {
			Thread.sleep(seg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void capturaTela() {

		numPG = numPG + 1;

		try {

			Robot robot = new Robot();
			BufferedImage bi = robot.createScreenCapture(new Rectangle(0, 0, 1600, 900));
			ImageIO.write(bi, "jpg", new File(diretorioGravacaoEvidencias.toString() + "/" + numPG + ".jpg"));

		} catch (AWTException | IOException e) {

		}

	}

	private void iniciarDiretorioEvidencias() {

		try {

			Path diretorioEvidencia = Paths.get(caminhoGravacaoEvidencia);

			String dirHoje = sdf.format(new Date());

			Path diretorioEvidenciaHoje = Paths.get(diretorioEvidencia.toString() + "/" + dirHoje);
			System.out.println(diretorioEvidenciaHoje);
			if (!Files.exists(diretorioEvidenciaHoje)) {
				Files.createDirectory(diretorioEvidenciaHoje);

			}

			Path diretorio = Paths.get(diretorioEvidenciaHoje.toString());

			if (!Files.exists(diretorio)) {
				Files.createDirectory(diretorio);
			}

			diretorioGravacaoEvidencias = Paths.get(diretorio.toString());

			if (!Files.exists(diretorioGravacaoEvidencias)) {

				Files.createDirectory(diretorioGravacaoEvidencias);
			}

		} catch (IOException e) {
			System.out.println("Não foi possível criar os diretorios de evidencias. Fechando robo ");
			System.exit(-1);
		}

	}

}
