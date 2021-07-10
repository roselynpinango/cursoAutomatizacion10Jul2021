package pruebas;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class LoginTest {
	WebDriver driver;
	String url = "http://automationpractice.com";
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
	
	/*
	 * Login 
	 * */
	@Test(priority=0)
	public void login() {
		// Clic en el link Sign In		
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.clicOnSignIn();
		
		// Completo las credenciales y hago clic en el botón
		PaginaLogin login = new PaginaLogin(driver);
		login.llenarCredenciales("correo6001@mailinator.com", "12345678");
		login.clicOnEntrar();		
	}
	
	@Test(priority=1)
	public void buscarPalabra() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.completarBusqueda("skirt");
		inicio.clicOnBuscar();
	}
	
	@Test(priority=2)
	public void irAContactUs() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.clicOnContactUs();
	}
}
