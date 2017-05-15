package com.bah.nos.model.pages;


import java.util.Iterator;
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

import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.benefits.gov")
public class BGPage extends PageObject {
    
	private String env = System.getProperty("environment");
	public String defaultUrl = "https://" + env + ".benefits.gov";
	
	
	public BGPage(WebDriver driver) {
		super(driver);
		driver.manage().window().maximize();
		this.setImplicitTimeout(10, TimeUnit.SECONDS);
		
	}
	
	public void clearCookies() {
		this.getDriver().manage().deleteAllCookies();
	}
	
	//********************************************************************************
	
   // @FindBy(class = "result-header")
    //private WebElementFacade sectionTitle;				
	
	private static final String SUBHEADER_XPATH = "//div[@class='field-items']/div[text()='%s']";
					 
	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/a")
    private WebElementFacade newsroomNode;
	
	//@FindBy(xpath = "//*[@class='page__title title']")
	//private WebElementFacade pageTitle;
	
    @FindBy(xpath = "//*[@class='field-item even']")
    private WebElementFacade subpageTitle;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[3]/a")
    private WebElementFacade involvedNode;
    				 
    @FindBy(xpath = "//*[@id='nav']/ul/li[4]/a")
    private WebElementFacade aboutUsNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[5]/a")
    private WebElementFacade helpNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[1]/a")
    private WebElementFacade browseNode;
    
    //Browse for Benefits links
    @FindBy(xpath = "//*[@id='category-icon']/a/p")
    private WebElementFacade categoryLink;
    
    @FindBy(xpath = "//*[@id='state-icon']/a/p")
    private WebElementFacade stateLink;
    
    @FindBy(xpath = "//*[@id='agency-icon']/a/p")
    private WebElementFacade agencyLink;
    
    
    //footer links
    @FindBy(xpath = "  //*[@id='twitter-icon']")
    private WebElementFacade twitterLink;
    
    @FindBy(xpath = "  //*[@id='fb-icon']")
    private WebElementFacade facebookLink;
    
    @FindBy(xpath = "  //*[@id='youtube-icon']")
    private WebElementFacade youtubeLink;
    
    
    

    @FindBy(xpath = "//*[@id='nav']/ul/li[1]/ul/li[1]/a")
    private WebElementFacade browseByCategoryNode;

    @FindBy(xpath = "//*[@id='nav']/ul/li[1]/ul/li[2]/a")
    private WebElementFacade browseByStateNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[1]/ul/li[3]/a")
    private WebElementFacade browseByAgencyNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[1]/ul/li[4]/a")
    private WebElementFacade otherResourcesNode;
    
    
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[1]/a")
    private WebElementFacade newsAndUpdatesNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[2]/a")
    private WebElementFacade compassENewsletterNode;
  
    
    //get involved Nodes
    @FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[1]/a")
    private WebElementFacade becomeAnAdvocateNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[2]/a")
    private WebElementFacade becomeAnAffiliateNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[3]/a")
    private WebElementFacade linkToUsNode;
    

    //About Us Nodes
    @FindBy(xpath = "//*[@id='nav']/ul/li[4]/ul/li[1]/a")
    private WebElementFacade ourMissionNode;

    @FindBy(xpath = "//*[@id='nav']/ul/li[4]/ul/li[2]/a")
    private WebElementFacade ourHistoryNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[4]/ul/li[3]/a")
    private WebElementFacade ourPartnersNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[4]/ul/li[4]/a")
    private WebElementFacade becomeAPartnerNode;
    				 
    @FindBy(xpath = "//*[@id='nav']/ul/li[4]/ul/li[5]/a")
    private WebElementFacade ourPlatformNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[4]/ul/li[6]/a")
    private WebElementFacade recognitionNode;
    
    //Help Nav Nodes
    @FindBy(xpath = "//*[@id='nav']/ul/li[5]/ul/li[1]/a")
    private WebElementFacade faqsNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[5]/ul/li[2]/a")
    private WebElementFacade contactUsNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[5]/ul/li[3]/a")
    private WebElementFacade privacyAndTermsOfUseNode;
    
    public void clickTwitter(String link) {
    	twitterLink.click();
    }
    public void clickFacebook(String link) {
    	facebookLink.click();
    }
    public void clickYoutube(String link) {
    	youtubeLink.click();
    }
    
    /*
     *  public void clickWhiteHouse(String link) {
    	helpNode.click();
    }
    public void clickUSAgov(String link) {
    	browseNode.click();
    }
    public void clickSSABest(String link) {
    	browseNode.click();
    }
    public void clickGovLoans(String link) {
    	browseNode.click();
    }
    public void clickDisasterAssistance(String link) {
    	browseNode.click();
    }
    public void clickNativeOneStop(String link) {
    	browseNode.click();
    }
     */
    
  

    public void clickBrowseByCategory(String node) {
        Actions action = new Actions(getDriver());
        action.moveToElement(browseNode).pause(1000).moveToElement(browseByCategoryNode).click().build().perform();
    }
    
    public void clickBrowseByState(String node) {
        Actions action = new Actions(getDriver());
        action.moveToElement(browseNode).pause(1000).moveToElement(browseByStateNode).click().build().perform();
    }
    
    public void clickBrowseByAgency(String node) {
        Actions action = new Actions(getDriver());
        action.moveToElement(browseNode).pause(1000).moveToElement(browseByAgencyNode).click().build().perform();
    }
    
    public void clickOtherResources(String node) {
        Actions action = new Actions(getDriver());
        action.moveToElement(browseNode).pause(1000).moveToElement(otherResourcesNode).click().build().perform();
    }
    
    
    
    public void clickNewsAndUpdates(String node) {
        Actions action = new Actions(getDriver());
        action.moveToElement(newsroomNode).pause(1000).moveToElement(newsAndUpdatesNode).click().build().perform();
    }
    public void clickCompassENewsletter(String node) {
        Actions action = new Actions(getDriver());
        action.moveToElement(newsroomNode).pause(1000).moveToElement(compassENewsletterNode).click().build().perform();
    }
    
    //involved sub navigation
    public void clickBecomeAnAdvocate(String node) {
        Actions action = new Actions(getDriver());
        action.moveToElement(involvedNode).pause(1000).moveToElement(becomeAnAdvocateNode).click().build().perform();
    }
    
    public void clickBecomeAnAffiliate(String node) {
        Actions action = new Actions(getDriver());
        action.moveToElement(involvedNode).pause(1000).moveToElement(becomeAnAffiliateNode).click().build().perform();
    }
    
    public void clickLinkToUs(String node) {
        Actions action = new Actions(getDriver());
        action.moveToElement(involvedNode).pause(1000).moveToElement(linkToUsNode).click().build().perform();
    }
    
  //About Us sub navigation
    public void clickOurMission(String node) {
        Actions action = new Actions(getDriver());
        action.moveToElement(aboutUsNode).pause(1000).moveToElement(ourMissionNode).click().build().perform();
    }
    
    public void clickOurHistory(String node) {
        Actions action = new Actions(getDriver());
        action.moveToElement(aboutUsNode).pause(1000).moveToElement(ourHistoryNode).click().build().perform();
    }
    
    public void clickOurPartners(String node) {
        Actions action = new Actions(getDriver());
        action.moveToElement(aboutUsNode).pause(1000).moveToElement(ourPartnersNode).click().build().perform();
    }
    
    public void clickBecomeAPartner(String node) {
        Actions action = new Actions(getDriver());
        action.moveToElement(aboutUsNode).pause(1000).moveToElement(becomeAPartnerNode).click().build().perform();
    }
    
    public void clickOurPlatform(String node) {
        Actions action = new Actions(getDriver());
        action.moveToElement(aboutUsNode).pause(1000).moveToElement(ourPlatformNode).click().build().perform();
    }
    
    public void clickRecognition(String node) {
        Actions action = new Actions(getDriver());
        action.moveToElement(aboutUsNode).pause(1000).moveToElement(recognitionNode).click().build().perform();
    }
    
    
    //Help sub navigation
    public void clickFAQs(String node) {
        Actions action = new Actions(getDriver());
        action.moveToElement(helpNode).pause(1000).moveToElement(faqsNode).click().build().perform();
    }
    
    public void clickContactUs(String node) {
        Actions action = new Actions(getDriver());
        action.moveToElement(helpNode).pause(1000).moveToElement(contactUsNode).click().build().perform();
    }
    
    public void clickPrivacyAndTermsOfUse(String node) {
        Actions action = new Actions(getDriver());
        action.moveToElement(helpNode).pause(1000).moveToElement(privacyAndTermsOfUseNode).click().build().perform();
    }
  
   
    
  
	
    // ***********************************************************************************
    // Functions
    
    public void clickNews(String node) {
    	newsroomNode.click();
    	Serenity.takeScreenshot();
    }
    public void clickInvolved(String node) {
    	involvedNode.click();
    	Serenity.takeScreenshot();
    }
    public void clickAboutUs(String node) {
    	aboutUsNode.click();
    	Serenity.takeScreenshot();
    }
    public void clickHelp(String node) {
    	helpNode.click();
    	Serenity.takeScreenshot();
    }
    public void clickBrowse(String node) {
    	browseNode.click();
    }
    
    public String pullPageTitle() {
    	//System.out.println("hiiiii");
    	//JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        //WebElement titleElement = getDriver().findElement(By.xpath("//*[@class='page__title title']"));
        //String pageTitle = (String) jse.executeScript("return arguments[0].text", titleElement);
        //System.out.println("#####pageTitle is " + pageTitle);
        //return pageTitle;
    	
    	WebElement pageTitle = getDriver().findElement(By.xpath("//*[@id='page-title']"));
		return pageTitle.getText();
		
	}
        
    public String pullSubpageTitle(String subpageName) {
    	
    	String subpage_xpath = String.format(SUBHEADER_XPATH, subpageName);
    	WebElement subpageTitle = getDriver().findElement(By.xpath(subpage_xpath));
    	return subpageTitle.getText();
    }
    
    
    //click browse by links
    public void clickCategoryLink(String link) {
    	categoryLink.click();
    	pause(1000);
    }
    public void clickStateLink(String link) {
    	stateLink.click();
    	pause(1000);
    }
    public void clickAgencyLink(String link) {
    	agencyLink.click();
    	pause(1000);
    }

    
    
    
    
    public void pause(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    
   
    
}