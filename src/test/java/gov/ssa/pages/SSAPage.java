package gov.ssa.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;

/**
 * Class is for all of the SSABest.Benefits.gov WebElements and methods to interact with them
 */

public class SSAPage extends PageObject {
    
	private String env = System.getProperty("environment");
	
	public SSAPage(WebDriver driver) {
		super(driver);
		//driver.manage().window().maximize();
		this.setImplicitTimeout(10, TimeUnit.SECONDS);
	}
	
	public void clearCookies() {
		this.getDriver().manage().deleteAllCookies();
	}
	
	public String setEnvironment() {
		if(env.isEmpty()){
			env ="www";
		}
		String defaultUrl = "https://" + env + ".ssabest.benefits.gov";
		return defaultUrl;
	}
	
	public String getCurrUrl() {
		String currentUrl = getDriver().getCurrentUrl();
		return currentUrl;
	}
 
    // ***********************************************************************************
	// Functions
	
    public String pullPageTitle() {
    	
    	//System.out.println("Waiting for page title to load");
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content-header']/h1")));

    	WebElement pageTitle = getDriver().findElement(By.xpath("//*[@id='content-header']/h1"));
		return pageTitle.getText();
	}
    
    public String pullBenefitTitle() {

    	WebElement benefitTitle = getDriver().findElement(By.xpath("//*[@class='span8 benefit-detail-title']/h2"));
		return benefitTitle.getText();
	}
    
    public String pullHomepageTitle() {

    	WebElement homepageTitle = getDriver().findElement(By.xpath("//*[@class='region region-left-subcontent']/div/h2"));
		return homepageTitle.getText();
	}
    
    public void clickSubNavButtons(WebElementFacade nav, WebElementFacade subNav) {
        Actions action = new Actions(getDriver());
        action.moveToElement(nav).pause(1000).moveToElement(subNav).click().build().perform();
    }
	
    public String getWindowUrl(){
		String windowUrl = getDriver().getCurrentUrl();

	    return windowUrl;
	}
    
	public String processWindows() {
		
		// Store the current window handle
		String winHandleBefore = getDriver().getWindowHandle();

		// Perform the click operation that opens new window

		// Switch to new window opened
		List<String> browserTabs = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(browserTabs.get(1));
		
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("page loading");
			} catch (InterruptedException e) {
			}
			// To check page ready state.
			if (!getDriver().getCurrentUrl().equals("about:blank")) {
				System.out.println("done");
				break;	
			}
		}
		
		// Perform the actions on new window
		Serenity.takeScreenshot();
		String windowUrl = getDriver().getCurrentUrl();

		// Close the new window, if that window no more required
		getDriver().close();

		// Switch back to original browser (first window)
		getDriver().switchTo().window(winHandleBefore);

		// Continue with original browser (first window)
		return windowUrl;
	}

	public void pause(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Step
    public void scrollToBottom() {
    	((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");   
    }

}