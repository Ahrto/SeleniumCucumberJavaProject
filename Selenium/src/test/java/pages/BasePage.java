package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait; 


public class BasePage {
	
	protected static WebDriver driver;
	private static WebDriverWait wait;
	private static Actions action;
	
	
	static {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromeDriver/chromedriver.exe");
		ChromeOptions chromeOption = new ChromeOptions();
		driver = new ChromeDriver(chromeOption);
//		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 10);
	}
	
	
	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
//		Espera implicita, afectara a todos los procesos
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
//	Navegar a:
	public static void navigateTo(String url) {
		driver.get(url);
	}
	
//	Funcion que cierra el navegador
	public static void closeBrowser() {
		driver.quit();
	}
	
//	Buscar WebElement por localizador xPath
	private WebElement find(String locator) {
//		Conlleva una espera explicita, cada vez que se llama a la funcion se ejecuta la espera, espera 10 seg o hasta que aparezca el elemento
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
//	Click en el elemento que pasamos por parametro (locator)
	public void clickElement(String locator) {
		find(locator).click();
	}
	
//	Introduce texto en el elemento seleccionado
	public void write(String locator, String textToWrite) {
		find(locator).clear();
		find(locator).sendKeys(textToWrite);
	}
	
//	Selecciona una opcion de un dropbox por VALOR
	public void selectFromDropdownByValue(String locator, String valueToSelect) {
		Select dropDown = new Select (find(locator));
		
		dropDown.selectByValue(valueToSelect);
	}
	
//	Selecciona una opcion de un dropbox por INDEX
	public void selectFromDropdownByIndex(String locator, int valueToSelect) {
		Select dropDown = new Select (find(locator));
		dropDown.selectByIndex(valueToSelect);
	}
	
//	Selecciona una opcion de un dropbox por TEXTO VISIBLE
	public void selectFromDropdownByText(String locator, String valueToSelect) {
		Select dropDown = new Select (find(locator));
		dropDown.selectByVisibleText(valueToSelect);
	}
	
//	Hace un Hover en el elemento 
	public void hoverElement(String locator) {
		action.moveToElement(find(locator));
	}
	
//	Doble click sobre el elemento 
	public void doubleClick(String locator) {
		action.doubleClick(find(locator));
	}
	
//	Click derecho en el elemento
	public void rigthClick(String locator) {
		action.contextClick(find(locator));
	}
	
//	Funcion para seleccionar contenido de una tabla (GRID)
	public String extractValue(String locator, int row, int column) {
		String cellIneed = locator +"/table/tbody/tr[" + row + "]/td[" + column + "]";
		
		return find(cellIneed).getText();
	}
	
//	Funcion para introducir un valor en una tabla mediate SET
	public void setValueOnTable(String locator, int row, int column, String stringToSend) {
		
		String cellToFill = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";
		
		find(cellToFill).sendKeys(stringToSend);
	}
	
//	iFrames y POPUps
//	Cambiar de Frame
	public void switchToiFrame(int iFrameIndex) {
		driver.switchTo().frame(iFrameIndex);
	}
	
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}
	
//	Alerts
//	Rechazar
	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
//			e.printStackTrace();
			System.out.println("No hay un alert presente!");
		}
		
	}
	
//	Aceptar
	public void aceptAlert() {
		driver.switchTo().alert().accept();
		
	}
	
	
//	ASSERTIONS
//	Funcion que devuelve texto para poder hacer una Assert en la clase Page
	public String textFromElement(String locator) {
		return(find(locator)).getText();
		
	}
	
//	Funcion que comrprueba si un elemento esta siendo mostrado
	public boolean elementIsDisplayed(String locator) {
		return find(locator).isDisplayed();
	}
	
//	Funcion que comprueba si un elemento no esta siendo mostrado
	public boolean elementIsEnabled(String locator) {
		return find(locator).isEnabled();
	}
	
//	Funcion que comprueba si un elemento esta siendo seleccionado
	public boolean elementIsSelected(String locator) {
		return find(locator).isEnabled();
	}
	
//	Funcion para extraer una lista de elementos
	public List<WebElement> bringMeAllElements(String locator){	
		/**
		 * Retorna un objeto de tipo List que contiene los WebElements de la clase pasada por parametro
		 */
		return driver.findElements(By.className(locator));
	}
		
}












