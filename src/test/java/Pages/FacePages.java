package Pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import arquivo.LerAqruivo;

public class FacePages {
	static WebDriver driver;

	public FacePages(WebDriver driver) {
		FacePages.driver = driver;

	}

	public void realizaLogin() throws Exception {
		LerAqruivo l = new LerAqruivo();
		l.ler();
		Thread.sleep(3000);
		
		driver.switchTo().frame(0);	
		
		WebElement username = driver.findElement(By.id("signinField"));
		username.sendKeys(l.getlogin());

		WebElement senha = driver.findElement(By.id("password"));
		senha.sendKeys(l.getsenha());

		WebElement Btnloga = driver.findElement(By.id("signinButtonSend"));
		Btnloga.click();
		
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
				
		driver.findElement(By.xpath("/html/body/div[1]/main/div/section/div/button")).click();;		

		Thread.sleep(3000);
		String nome = driver.findElement(By.xpath("//*[@id=\'main\']/div/main/div/div/div[1]/dl/div/dd/div[2]/div[1]/div/div[1]/a")).getText();
		assertTrue(nome.contains("UN32J4000"));

	}

	public void pesquisar() throws Exception {
		WebElement username = driver.findElement(By.id("suggestion-search"));
		
		username.sendKeys("tv");
		Thread.sleep(3000);
		
		username.sendKeys(Keys.ENTER);
		Thread.sleep(4000);		
		
		String nome = driver.findElement(By.xpath("//*[@id=\'main\']/h1")).getText();
		assertTrue(nome.contains("tv"));
		
	}
	
	public void carrinho() throws Exception{
		Thread.sleep(3000);
		WebElement tv = driver
				.findElement(By.cssSelector("a[href*='//www.walmart.com.br/tv-led-hd-32-samsung-un32j4000-slim-funcao-futebol-1-usb-2-hdmi/3077619/pr']"));
		tv.click();
		
		Thread.sleep(3000);
		WebElement carrinho = driver
				.findElement(By.xpath("//*[@id=\"buybox\"]/div/div[2]/div/div/div[2]/div/button"));
		carrinho.click();		
	}
	
	public void validarCarrinho() throws Exception{				
		Thread.sleep(3000);
		WebElement validar = driver
				
				.findElement(By.cssSelector("a[href*='https://www2.walmart.com.br/checkout/content/carrinho/']"));
		validar.click();
		
		String nome = driver.findElement(By.xpath("//*[@id='main']/div/main/div/div/div[1]/dl/div/dd/div/div[1]/div/div[1]/a")).getText();
		assertTrue(nome.contains("UN32J4000"));
	}
	
	public void finalizarCompra() throws Exception{				
		Thread.sleep(3000);			
		driver.findElement(By.xpath("//*[@id=\'btn-finalize-cart\']")).click();		
	}
	

}