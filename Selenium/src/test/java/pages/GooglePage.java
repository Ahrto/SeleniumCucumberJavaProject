package pages;

public class GooglePage extends BasePage {
	
	private String searchButton = "//input [@value='Buscar con Google']";
	private String searchTextField = "//input [@title='Buscar']";
	private String firstResult = "//body/div[@id='main']/div[@id='cnt']/div[@id='rcnt']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/h3[1]";
	
	public GooglePage () {
		super(driver);
	}
	
	public void navigateToGoogle() {	
		navigateTo("https://google.com");
		clickElement("//*[@id=\"L2AGLb\"]/div");
		
	}
	
	public void clickGoogleSearch() {
		clickElement(searchButton);
		
	}
	
	public void enterSearchCriteria(String criteria) {
		write(searchTextField, criteria);
	}
	
//	Funcion que coge el texto del primer resultado de la búsqueda en Google 
	public String firstResult() {
		return textFromElement(firstResult);
	}
	

}

