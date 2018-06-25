package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.FacePages;

public class FaceTest {

	static WebDriver driver;
	static FacePages facePages;

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		driver = new ChromeDriver ();
		driver.get("https://www.walmart.com.br");
		driver.manage().window().maximize();
		facePages = new FacePages(driver);
	}

	@After
	public void tearDown() throws Exception {
		
		driver.close();
			
	}
	
	@Test
	public void test() throws Exception{		
		facePages.pesquisar();
		facePages.carrinho();
		facePages.validarCarrinho();
		facePages.finalizarCompra();
		facePages.realizaLogin();
		
	}

}