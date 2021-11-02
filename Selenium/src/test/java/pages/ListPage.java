package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class ListPage extends BasePage{
	
	private String searchField = "//body/form[1]/input[1]";
	private String searchResults = "name";
	
	public ListPage() {
		super(driver);
	}
	
	public void navigateToList() {
		navigateTo("https://andreidbr.github.io/JS30/06AjaxTypeAhead/index.html");
	}
	
	public void enterSearchCriteria(String state) throws InterruptedException {
		try {
			Thread.sleep(600);
			write(searchField, state);
		} catch (TimeoutException e) {
			System.out.println("El WebElement del campo de busqueda no se encuentra");
			e.printStackTrace();
		}
		
	}
	
//	Funcion para recorrer listas y almacenar sus Strings
	public List<String> getAllSearchResults(){
//		Creamos una lista con todos los WebElements que nos trae la funcion "bringMeAllElements(searchResults)"
		List<WebElement> list = bringMeAllElements(searchResults);
//		Creamos una lista en la que vamos a alamacenar los String de la lista anterior
		List<String> stringFromList = new ArrayList<String>();
//		Recorremos la lista de WebElements y vamos extrayendo los String y almacenandolos en la lista "stringFromList"
		for (WebElement e : list) {
			stringFromList.add(e.getText());
		}
		return stringFromList;
		
	}

}
