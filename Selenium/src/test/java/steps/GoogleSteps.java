package steps;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.GooglePage;


public class GoogleSteps {
	
	GooglePage google = new GooglePage();
	
	@Given("^navego a Google$")
	public void navigateToGoogle() {
		google.navigateToGoogle();
	}
	
	@When("^busco algo$")
	public void enterSearchCriteria() {
		google.enterSearchCriteria("España");
	}
	
	@And("^hago click en buscar$")
	public void clickSearchButton() {
		google.clickGoogleSearch();
	}
	
	@Then("^obtengo resultados$")
	public void validateResults() {
		Assert.assertEquals("España - Wikipedia, la enciclopedia libre", google.firstResult());
	}
	
}
