package pages;

public class GridTestPage extends BasePage{
	
	private String cell = "/html/body/div/div";
	private String mainTable = "//*[@id=\"root\"]/div/table";
	
	public GridTestPage() {
		super(driver);
	}
	
	public void navigateToGrid() {
		navigateTo("https://1v2njkypo4.csb.app/");
	}

	public String getValueFromGrid(int row, int column) {
		return extractValue(cell, row, column);
	}
	
	public boolean cellStatus() {
		return elementIsDisplayed(mainTable);
	}
}

