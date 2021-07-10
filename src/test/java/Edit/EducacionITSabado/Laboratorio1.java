package Edit.EducacionITSabado;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Laboratorio1 {
	/*
	 * Método para abrir la página de Selenium.dev bajo Chrome
	 * */	
	@Test
	public void abrirPaginaEnChrome() {
		// 1. Indicar dónde está nuestro driver
		System.setProperty("webdriver.chrome.driver", "..\\EducacionITSabado\\Drivers\\chromedriver.exe");
		
		// 2. Crear el objeto según el navegador
		WebDriver driver = new ChromeDriver();
		
		// 3. Abrir la página Selenium.dev
		driver.get("https://www.selenium.dev/");
		
		// 4. Maximizar la página
		driver.manage().window().maximize();
		
		// 5. Imprimir en la consola el título de la página
		System.out.println(driver.getTitle());
		
		// 6. Cerrar la ventana
		driver.close();
	}
	
	/*
	 * Método para abrir la página de Selenium.dev bajo Firefox
	 * */	
	@Test
	public void abrirPaginaEnFirefox() {
		// 1. Indicar dónde está nuestro driver
		System.setProperty("webdriver.gecko.driver", "..\\EducacionITSabado\\Drivers\\geckodriver.exe");
		
		// 2. Crear el objeto según el navegador
		WebDriver driver = new FirefoxDriver();
		
		// 3. Abrir la página Selenium.dev
		driver.get("https://www.selenium.dev/");
		
		// 4. Maximizar la página
		driver.manage().window().maximize();
		
		// 5. Imprimir en la consola el título de la página
		System.out.println(driver.getTitle());
		
		// 6. Cerrar la ventana
		driver.close();
	}
	
	/*
	 * Método para abrir la página de Selenium.dev bajo Chrome y hacer una búsqueda
	 * */	
	@Test
	public void buscarPalabraEnChrome() {
		// 1. Indicar dónde está nuestro driver
		System.setProperty("webdriver.chrome.driver", "..\\EducacionITSabado\\Drivers\\chromedriver.exe");
		
		// 2. Crear el objeto según el navegador
		WebDriver driver = new ChromeDriver();
		
		// 3. Abrir la página Selenium.dev
		driver.get("https://www.selenium.dev/");
		
		// 4. Maximizar la página
		driver.manage().window().maximize();
		
		// 5. Hacer una búsqueda de una palabra y presionar la tecla ENTER
		WebElement txtSearch = driver.findElement(By.id("gsc-i-id1"));
		txtSearch.sendKeys("java");
		txtSearch.sendKeys(Keys.ENTER);
		
		// 6. Cerrar la ventana
		//driver.close();
	}
}
