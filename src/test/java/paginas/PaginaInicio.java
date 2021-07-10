package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement lnkSignIn;
	
	@FindBy(xpath="//header/div[2]/div[1]/div[1]/nav[1]/div[2]/a[1]")
	WebElement lnkContactUs;
	
	@FindBy(xpath="//input[@id='search_query_top']")
	WebElement txtBuscador;
	
	@FindBy(xpath="//header/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")
	WebElement btnBuscar;
	
	public PaginaInicio(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clicOnSignIn() {
		lnkSignIn.click();
	}
	
	public void clicOnContactUs() {
		lnkContactUs.click();
	}
	
	public void completarBusqueda(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void clicOnBuscar() {
		btnBuscar.click();
	}
}
