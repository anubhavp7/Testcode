package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ecomtest {
private WebDriver driver;
private Map<String, Object> vars;
JavascriptExecutor js;


@Before
public void setUp() { 
//changing the environment variable to point to my local directory
 System.setProperty("webdriver.chrome.driver", "E:\\java\\chromedriver.exe");
 driver = new ChromeDriver();
 js = (JavascriptExecutor) driver;
 vars = new HashMap<String, Object>();
}

@After
public void tearDown() {
 driver.quit();
}

@Test
public void ecomtest() {
 try {	 	
	 driver.get("https://www.bestbuy.com.mx/");
	 driver.manage().window().setSize(new Dimension(1366, 634));
	 driver.findElement(By.id("profileMenuWrap1")).click();
	 driver.findElement(By.linkText("Crear tu cuenta en Best Buy")).click();
	 driver.findElement(By.id("firstName")).click();
	 driver.findElement(By.id("firstName")).sendKeys("Anu");
	 driver.findElement(By.id("surname")).sendKeys("Pat");
	 driver.findElement(By.id("email")).sendKeys("aprofile67@gmail.com");
	 driver.findElement(By.id("password")).sendKeys("A1@123456789");
	 driver.findElement(By.id("confirmPassword")).sendKeys("A1@123456789");
	 driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div/div/div/div[6]/button")).click();
	 
	 
	 WebDriverWait wait = new WebDriverWait(driver,12);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".c-alert-content span")));
	 
	 vars.put("accountalreadyexist", driver.findElement(By.cssSelector(".c-alert-content span")).getText());
	 assertThat(driver.findElement(By.cssSelector(".c-alert-content span")).getText(), is("Lo sentimos, hubo un problema al crear tu cuenta. Tal vez ya cuentas con una, intenta restableciendo tu contraseña o revisando tu información e intenta ingresar de nuevo."));
	 driver.findElement(By.id("signin")).click();
	 driver.findElement(By.id("email")).click();
	 driver.findElement(By.id("email")).sendKeys("aprofile67@gmail.com");
	 driver.findElement(By.id("password")).click();
	 driver.findElement(By.id("password")).sendKeys("A1@123456789");
	 driver.findElement(By.cssSelector(".signin-button")).click();
	 
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("button-acceptar-alertcustomer-message")));
	 
	 driver.findElement(By.id("button-acceptar-alertcustomer-message")).click();
	 
	 driver.findElement(By.id("gh-search-input")).click();
	 {
	   WebElement element = driver.findElement(By.id("gh-search-input"));
	   Actions builder = new Actions(driver);
	   builder.doubleClick(element).perform();
	 }
	 driver.findElement(By.id("gh-search-input")).click();
	 driver.findElement(By.id("gh-search-input")).sendKeys("projecto");
	 driver.findElement(By.id("gh-search-input")).sendKeys(Keys.ENTER);
	 driver.findElement(By.id("sort-by-select")).click();
	 {
	   WebElement element = driver.findElement(By.id("sort-by-select"));
	   Actions builder = new Actions(driver);
	   builder.doubleClick(element).perform();
	 }
	 
	 driver.findElement(By.id("sort-by-select")).click();
	 {
	   WebElement dropdown = driver.findElement(By.id("sort-by-select"));
	   dropdown.findElement(By.xpath("//option[. = 'Precio de Bajo a Alto']")).click();
	 }
	 
	 driver.findElement(By.id("sort-by-select")).click();

	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#product-line-item-1000221603 h4")));
	 

	 
	 vars.put("ordername", driver.findElement(By.cssSelector("#product-line-item-1000221603 h4")).getText());
	 
	 driver.findElement(By.cssSelector("#product-line-item-1000221603 .btn")).click();
	 driver.findElement(By.cssSelector(".atc-warranty-tile-no-thanks > span")).click();
	 driver.findElement(By.cssSelector(".btn-md")).click();
	 driver.findElement(By.cssSelector(".head")).click();
	 driver.findElement(By.linkText("Cerrar >")).click();
	 driver.findElement(By.cssSelector(".cart > a")).click();
	 {
	   WebElement element = driver.findElement(By.id("magic-cart-spinner"));
	   Actions builder = new Actions(driver);
	   builder.doubleClick(element).perform();
	 }
	 assertThat(driver.findElement(By.cssSelector(".product-row:nth-child(2) .product-name > a")).getText(), is("MVMT - Audifono In Ear Plano Con Mic Gris"));
	 assertThat(driver.findElement(By.linkText("REDlemon - Adaptador/convertidor para HDMI - Thunderbolt a HDMI - Blanco")).getText(), is("REDlemon - Adaptador/convertidor para HDMI - Thunderbolt a HDMI - Blanco"));
	 driver.findElement(By.linkText("Cerrar >")).click();
	 
	 driver.findElement(By.id("profileMenuWrap1")).click();
	
	 driver.findElement(By.linkText("Salir")).click();
	 {
	   WebElement element = driver.findElement(By.linkText("Salir"));
	   Actions builder = new Actions(driver);
	   builder.doubleClick(element).perform();
	 }
   }
   catch (Exception e) {
     System.out.println("Something went wrong.");
   }
  }
}


