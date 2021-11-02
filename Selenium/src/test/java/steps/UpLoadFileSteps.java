package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.UpLoadFilePage;

public class UpLoadFileSteps {
	
	UpLoadFilePage upLoadFilePage = new UpLoadFilePage();
	
	@Given("^navego hasta la Web de pruebas$")
	public void navigateToWebTest() {
		upLoadFilePage.navigateToWeb();
	}
	
	@And("^hago click en el boton para subir un archivo$")
	public void clickBtnUpload() {
		upLoadFilePage.clickUpLoadFile();
	}

}
