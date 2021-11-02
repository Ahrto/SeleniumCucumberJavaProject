package steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.GridTestPage;

public class GridTestSteps {
	
	GridTestPage gridTestPage = new GridTestPage();
	
	@Given("^navegar hasta la tabla$")
	public void navigateToGrid() throws InterruptedException {
//		Espera sleep NO RECOMENDABLE
//		Thread.sleep(3000);
		gridTestPage.navigateToGrid();
		System.out.println("Funcion navegar hasta la tabla");
	}
	
	@Then("^extraer el valor que quiero$")
	public void extractValue() {
		String value = gridTestPage.getValueFromGrid(4, 3);
		
//		Comporbar que el valor es el esperado
		Assert.assertEquals("r: 3, c: 2", value);
		System.out.println("Funcion extraer el valor que quiero");
	}
	
	
	@Then("^comprobar que la tabla es visible$")
	public void theTableIsThere() {
		
//		Comprobar que la tabla es visible, en caso contrario lanzará el mensaje definido
		Assert.assertTrue("El elemento no está siendo mostrado.", gridTestPage.cellStatus());	
		System.out.println("Funcion comprobar que la tabla es visible");
	}

}



