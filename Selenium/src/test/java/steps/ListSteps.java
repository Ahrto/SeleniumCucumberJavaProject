package steps;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ListPage;

public class ListSteps {
	
	ListPage listPage = new ListPage();
	
	@Given("^navegar hasta la pagina de la lista$")
	public void navigateToList() {
		listPage.navigateToList();
		listPage.dismissAlert();
	}
	
	
//	(.+) sirve para introducir una variable para realizar pruebas con multiples valores mediante las tablas de EXAMPLES (definidas en el feature Scenario Outline)
	@When("^busco (.+) en la lista$")
	public void searchTheList(String state) throws InterruptedException {
		listPage.enterSearchCriteria(state);
	}
	
//	(.+) sirve para introducir una variable para realizar pruebas con multiples valores mediante las tablas de EXAMPLES (definidas en el feature Scenario Outline)
	@Then("^puedo encontrar (.+) en la lista$")
	public void searchIsInList(String city) {
		List<String> lista = listPage.getAllSearchResults();
		boolean textIsThere = lista.contains(city);
		
		if (textIsThere) {
			System.out.println("La ciudad [" + city + "] esta en la lista. PASSED.");
		}else {
			throw new Error("La ciudad [" + city + "]  no esta en la lista: FAILED!");
		}
	}

}
