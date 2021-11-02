package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "src/test/resources/features",
		glue = "steps",
//		Podemos seleccionar que test queremos realizar mediante la etiqueta @test (o las que correspondan). Si son mas de una se ponen entre "" y con OR
		tags = "@Demoqa",
		plugin = {"pretty"}
//		monochrome = true
		)

public class runner {
	
//	Esta anotación hace que esta funcion se ejecute cuando terminen las pruebas
	@AfterClass
	public static void cleanDriver() {

		BasePage.closeBrowser();
		
		
	}
	
	
}
