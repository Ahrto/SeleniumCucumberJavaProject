package pages;

public class UpLoadFilePage extends BasePage{
	
	private String upLoadBtn = "//input[@id='uploadFile']";
	
	public UpLoadFilePage() {
		super(driver);
	}
	
	public void navigateToWeb() {
		navigateTo("https://demoqa.com/upload-download");
	}
	
	public void clickUpLoadFile() {
		clickElement(upLoadBtn);
	}
	
	

}
