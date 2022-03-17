package crm.pom.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OrganizationPage extends WebDriverUtility {
	
	//Step1: declaration
	@FindBy(xpath = "//img[@alt ='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
	//step2: initialization
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step3: Utilization
	public WebElement getCreateOrgLookUpImg(){
		return createOrgLookUpImg;
	}
	
	//Business Library
	public void clickOnCreateOrgImg()
	{
		createOrgLookUpImg.click();
	}
}
