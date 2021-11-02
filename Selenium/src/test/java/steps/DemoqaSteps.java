package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.DemoqaPage;

public class DemoqaSteps {
	
	DemoqaPage demoqaPage = new DemoqaPage();
	
	@Given("^navegar hasta demoqa.com$")
	public void navigateToDemoqa() {
		demoqaPage.navigateToDemoqa();
	}
	
	@And("^seleccionar un valor del dropbox$")
	public void selectState() {
		demoqaPage.selectCategory("9");
	}

}

