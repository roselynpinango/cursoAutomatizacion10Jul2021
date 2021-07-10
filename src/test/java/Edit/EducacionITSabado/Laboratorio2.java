package Edit.EducacionITSabado;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio2 {
	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";	
	
	/*
	 * Metodo para crear una cuenta en AutomationPractice
	 * */
	@Test
	public void registrarUsuario() {
		// Establecer el navegador que vamos a utilizar y abrirlo en la página correspondiente
		System.setProperty("webdriver.chrome.driver", "..\\EducacionITSabado\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		// Escribir el correo y hacer clic en el botón
		WebElement txtEmail = driver.findElement(By.id("email_create"));
		txtEmail.sendKeys("correo3002@mailinator.com");
		
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
		
		// Hacer clic en el boton Register
		driver.findElement(By.cssSelector("#submitAccount")).click();
		
		driver.close();
	}
}
