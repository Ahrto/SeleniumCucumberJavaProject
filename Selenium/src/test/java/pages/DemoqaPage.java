package pages;

public class DemoqaPage extends BasePage{
	
	private String categoryDropdown = "//select[@id='oldSelectMenu']";
	
	public DemoqaPage() {
		super(driver);
	}
	
	public void navigateToDemoqa() {
		navigateTo("https://demoqa.com/select-menu");
	}
	
	public void selectCategory(String category) {
		selectFromDropdownByValue(categoryDropdown, category);
	}
	
}

