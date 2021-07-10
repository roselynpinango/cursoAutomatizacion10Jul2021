package Edit.EducacionITSabado;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio3 {
	WebDriver driver;
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	String driverPath = "..\\EducacionITSabado\\Drivers\\chromedriver.exe";
	File screen;
	
	/*
	 * Configurar el navegador y abrirlo
	 * */
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	/*
	 * Cerrar el navegador
	 * */
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
	
	@Test(priority=2,description="Uso del Buscador")
	public void buscarPalabra() {
		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("dress");
		driver.findElement(By.xpath("//header/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")).click();
	}
	
	@Test(priority=1, description="Opcion Contactanos")
	public void irAContactUs() {
		driver.findElement(By.linkText("Contact us")).click();
	}
	
	/*
	 * Llenado del formulario para registrar un usuario
	 * */
	@Test(priority=0, description="Registrar usuario")
	public void registrarUsuario() throws Exception {
		// Captura de pantalla
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EducacionITSabado\\Evidencias\\01_Pagina_Inicial.png"));
		
		// Escribir el correo y hacer clic en el botón
		WebElement txtEmail = driver.findElement(By.id("email_create"));
		txtEmail.sendKeys("correo3007@mailinator.com");
		
		// Captura de pantalla
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EducacionITSabado\\Evidencias\\02_Correo_Ingresado.png"));
		
		driver.findElement(By.id("SubmitCreate")).click();
				
		// Introducir una espera
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='id_gender1']")));
				
		// Completar el formulario
		WebElement radGender = driver.findElement(By.xpath("//input[@id='id_gender1']"));
		radGender.click();
				
		driver.findElement(By.name("customer_firstname")).sendKeys("Gonzalo");
				
		driver.findElement(By.cssSelector("#customer_lastname")).sendKeys("Jimenez");
				
		WebElement txtPassword = driver.findElement(By.id("passwd"));
		txtPassword.sendKeys("12345678");
				
		Select days = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		days.selectByValue("18");
				
		Select months = new Select(driver.findElement(By.id("months")));
		months.selectByValue("6");
				
		Select years = new Select(driver.findElement(By.cssSelector("#years")));
		years.selectByValue("1990");
				
		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		
		driver.findElement(By.xpath("//input[@id='optin']")).click();
			
		driver.findElement(By.name("company")).sendKeys("ABC C.A.");
				
		driver.findElement(By.cssSelector("#address1")).sendKeys("MiCalle 123 4B");
				
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Capital Federal");
				
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("CABA");
				
		Select states = new Select(driver.findElement(By.id("id_state")));
		states.selectByValue("5");
				
		driver.findElement(By.cssSelector("#postcode")).sendKeys("61056");
				
		Select countries = new Select(driver.findElement(By.id("id_country")));
		countries.selectByValue("21");
				
		driver.findElement(By.id("other")).sendKeys("Comentarios Adicionales sobre el registro (PRUEBA)");
				
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("34567654");
				
		driver.findElement(By.name("phone_mobile")).sendKeys("1546576757");
				
		WebElement txtAlias = driver.findElement(By.id("alias"));
		txtAlias.clear();
		txtAlias.sendKeys("Mi Oficina");
		
		// Captura de pantalla
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EducacionITSabado\\Evidencias\\03_Formulario_Lleno.png"));
				
		// Hacer clic en el boton Register
		driver.findElement(By.cssSelector("#submitAccount")).click();
		
		// Captura de pantalla
		screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EducacionITSabado\\Evidencias\\04_Resultado_Obtenido.png"));
		
		// Si luego de hacer clic en Registrar cambio de URL significa que pudo registrar el usuario
		Assert.assertNotEquals(driver.getCurrentUrl(), url);
	}
}
