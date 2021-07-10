package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement txtContrasenia;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement btnEnter;
	
	public PaginaLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void llenarCredenciales(String email, String contrasenia) {
		txtEmail.sendKeys(email);
		txtContrasenia.sendKeys(contrasenia);
	}
	
	public void clicOnEntrar() {
		btnEnter.click();
	}
}
