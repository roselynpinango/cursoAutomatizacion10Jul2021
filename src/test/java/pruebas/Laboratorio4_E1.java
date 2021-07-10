package pruebas;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio4_E1 {
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
	@Test(priority=0,dataProvider="Datos para probar el login")
	public void login(String correo, String contrasenia) {
		// Clic en el link Sign In		
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.clicOnSignIn();
		
		// Completo las credenciales y hago clic en el botón
		PaginaLogin login = new PaginaLogin(driver);
		login.llenarCredenciales(correo, contrasenia);
		login.clicOnEntrar();
	}
	
	@DataProvider(name="Datos para probar el login")
	public Object[][] getData() {
		Object[][] datos = new Object[3][2];
		
		datos[0][0] = "correo001@mailinator.com";
		datos[0][1] = "1q2w3e4r5t6y";
		
		datos[1][0] = "correo002@mailinator.com";
		datos[1][1] = "5yrts54tdrt5ddt5rdt";
		
		datos[2][0] = "correo003@mailinator.com";
		datos[2][1] = "rty4esefsda";
		
		return datos;
	}
}
