package gov.ssa.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
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

public class SSAHomepage extends PageObject {
    
	// *************************************************************************
	
	//Main Nav
	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/a")
	public WebElementFacade benefitsMainNavButton;
	
	@FindBy(xpath = "//*[@id='nav']/ul/li[3]/a")
	public WebElementFacade helpMainNavButton;
	
	//Sub Nav
	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[1]/a")
	public WebElementFacade questionnaireSubNavButton;
	
	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[2]/a")
	public WebElementFacade browseByCategorySubNavButton;
	                 
	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[3]/a")
	public WebElementFacade otherResourcesSubNavButton;

	@FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[1]/a")
	public WebElementFacade FAQSubNavButton;
	
	@FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[2]/a")
	public WebElementFacade contactUsSubNavButton;
	
	@FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[3]/a")
	public WebElementFacade privacyAndTermsSubNavButton;
	
	//Footer Links
	@FindBy(xpath = "//*[@class='partners']/ul/li[1]/a")
	public WebElementFacade whiteHouseFooterLink;
						
	@FindBy(xpath = "//*[@class='partners']/ul/li[2]/a")
	public WebElementFacade USAGovFooterLink;
	
	@FindBy(xpath = "//*[@class='resources']/ul/li[1]/a")
	public WebElementFacade BGFooterLink;
	
	@FindBy(xpath = "//*[@class='resources']/ul/li[2]/a")
	public WebElementFacade DAFooterLink;
	
	@FindBy(xpath = "//*[@class='resources']/ul/li[3]/a")
	public WebElementFacade GLFooterLink;
	
	@FindBy(xpath = "//*[@class='privacy']/h5/a")
	public WebElementFacade privacyAndTermsFooterLink;

	// other homepage links
	@FindBy(xpath = "//*[@id='nav']/ul/li[1]/a")
	public WebElementFacade homeMainNavButton;

	@FindBy(xpath = "//*[@id='logo']/img")
	public WebElementFacade homeLogoButton;

	@FindBy(xpath = "//*[@class='language-link']")
	public WebElementFacade languageToggleButton;
	
	@FindBy(xpath = "//*[@id='nav']/ul/li[4]/a")
	public WebElementFacade SSAGovLink;
	
	@FindBy(xpath = "//*[@id='get-started']")
	public WebElementFacade startQuestionnaireButton;

	@FindBy(xpath = "(//*[@class='content']/div/div/div/p/a)[1]")
	public WebElementFacade helpWithMedicareLink;

	@FindBy(xpath = "(//*[@class='content']/div/div/div/p/a)[2]")
	public WebElementFacade BGHomepageLink;
	
	@FindBy(xpath = "(//*[@class='content']/div/div/div/p/a)[3]")
	public WebElementFacade BGHomepageLogoLink;
	
	

}