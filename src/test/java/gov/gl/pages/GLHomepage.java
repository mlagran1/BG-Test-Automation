package gov.gl.pages;

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

//@DefaultUrl("https://www.govloans.gov")
public class GLHomepage extends PageObject {
    
	// *************************************************************************
	// FindBy / private variables section
	
	//Main Nav
	@FindBy(xpath = "//*[@id='navbar']/div/div/div[2]/nav/ul/li[2]/a")
	public WebElementFacade loansMainNavButton;
	
	@FindBy(xpath = "//*[@id='navbar']/div/div/div[2]/nav/ul/li[3]/a")
	public WebElementFacade aboutMainNavButton;
	
	@FindBy(xpath = "//*[@id='navbar']/div/div/div[2]/nav/ul/li[4]/a")
	public WebElementFacade helpMainNavButton;
	
	//Sub Nav
	@FindBy(xpath = "//*[@id='navbar']/div/div/div[2]/nav/ul/li[2]/ul/li[1]/a")
	public WebElementFacade loanFinderSubNavButton;
	                 
	@FindBy(xpath = "//*[@id='navbar']/div/div/div[2]/nav/ul/li[2]/ul/li[2]/a")
	public WebElementFacade browseByCategorySubNavButton;
	
	@FindBy(xpath = "//*[@id='navbar']/div/div/div[2]/nav/ul/li[2]/ul/li[3]/a")
	public WebElementFacade otherResourcesSubNavButton;
	
	@FindBy(xpath = "//*[@id='navbar']/div/div/div[2]/nav/ul/li[3]/ul/li[1]/a")
	public WebElementFacade overviewSubNavButton;
	
	@FindBy(xpath = "//*[@id='navbar']/div/div/div[2]/nav/ul/li[3]/ul/li[2]/a")
	public WebElementFacade linkToGovloansSubNavButton;
	
	@FindBy(xpath = "//*[@id='navbar']/div/div/div[2]/nav/ul/li[4]/ul/li[1]/a")
	public WebElementFacade FAQSubNavButton;
	
	@FindBy(xpath = "//*[@id='navbar']/div/div/div[2]/nav/ul/li[4]/ul/li[2]/a")
	public WebElementFacade contactUsSubNavButton;
	
	@FindBy(xpath = "//*[@id='navbar']/div/div/div[2]/nav/ul/li[4]/ul/li[3]/a")
	public WebElementFacade glossarySubNavButton;
	
	@FindBy(xpath = "//*[@id='navbar']/div/div/div[2]/nav/ul/li[4]/ul/li[4]/a")
	public WebElementFacade privacyAndTermsSubNavButton;

	//Footer Links
	@FindBy(xpath = "//*[@id='block-block-2']/div/div/div[1]/div[1]/ul/li/ul/li/a")
	public WebElementFacade espanolFooterLink;
	
	@FindBy(xpath = "//*[@id='block-block-2']/div/div/div[1]/div[2]/ul/li/ul/li[1]/a")
	public WebElementFacade loanFinderFooterLink;
	
	@FindBy(xpath = "//*[@id='block-block-2']/div/div/div[1]/div[2]/ul/li/ul/li[2]/a")
	public WebElementFacade byCategoryFooterLink;
	
	@FindBy(xpath = "//*[@id='block-block-2']/div/div/div[1]/div[2]/ul/li/ul/li[3]/a")
	public WebElementFacade otherResourcesFooterLink;
	
	@FindBy(xpath = "//*[@id='block-block-2']/div/div/div[1]/div[3]/ul/li/ul/li[1]/a")
	public WebElementFacade overviewFooterLink;
	
	@FindBy(xpath = "//*[@id='block-block-2']/div/div/div[1]/div[3]/ul/li/ul/li[2]/a")
	public WebElementFacade linkToGovLoansFooterLink;
	
	@FindBy(xpath = "//*[@id='block-block-2']/div/div/div[1]/div[4]/ul/li/ul/li[1]/a")
	public WebElementFacade FAQFooterLink;
	
	@FindBy(xpath = "//*[@id='block-block-2']/div/div/div[1]/div[4]/ul/li/ul/li[2]/a")
	public WebElementFacade glossaryFooterLink;
	
	@FindBy(xpath = "//*[@id='block-block-2']/div/div/div[1]/div[4]/ul/li/ul/li[3]/a")
	public WebElementFacade contactUsFooterLink;
	
	@FindBy(xpath = "//*[@id='block-block-2']/div/div/div[3]/div/a")
	public WebElementFacade privacyAndTermsFooterLink;
	
	@FindBy(xpath = "//*[@id='U.S. Department of Labor || U.S. Department of Labor']")
	public WebElementFacade BGFooterLink;
	
	@FindBy(xpath = "(//*[@id='Other || Other'])[1]")
	public WebElementFacade USAGovFooterLink;
	
	@FindBy(xpath = "(//*[@id='Other || Other'])[2]")
	public WebElementFacade whiteHouseFooterLink;
	
	//Loan Category Homepage Links
	@FindBy(xpath = "//*[@id='node-582']/div/div/div/div/div[2]/div[3]/div[2]/table/tbody/tr[1]/td[1]/a")
	public WebElementFacade agricultureHomepageLink;
	
	@FindBy(xpath = "//*[@id='node-582']/div/div/div/div/div[2]/div[3]/div[2]/table/tbody/tr[2]/td[1]/a")
	public WebElementFacade businessHomepageLink;
	
	@FindBy(xpath = "//*[@id='node-582']/div/div/div/div/div[2]/div[3]/div[2]/table/tbody/tr[3]/td[1]/a")
	public WebElementFacade disasterReliefHomepageLink;
	
	@FindBy(xpath = "//*[@id='node-582']/div/div/div/div/div[2]/div[3]/div[2]/table/tbody/tr[1]/td[2]/a")
	public WebElementFacade educationHomepageLink;
	
	@FindBy(xpath = "//*[@id='node-582']/div/div/div/div/div[2]/div[3]/div[2]/table/tbody/tr[2]/td[2]/a")
	public WebElementFacade housingHomepageLink;
	
	@FindBy(xpath = "//*[@id='node-582']/div/div/div/div/div[2]/div[3]/div[2]/table/tbody/tr[3]/td[2]/a")
	public WebElementFacade veteranHomepageLink;
	
	//other homepage links
	@FindBy(xpath = "//*[@id='navbar']/div/div/div[2]/nav/ul/li[1]/a")
	public WebElementFacade homeMainNavButton;
	
	@FindBy(xpath = "//*[@id='navbar']/div/div/a[2]/img")
	public WebElementFacade homeLogoButton;
	
	@FindBy(xpath = "//*[@id='block-locale-language']/div[1]/ul/li[1]/a")
	public WebElementFacade languageToggleButtonEN;
	
	@FindBy(xpath = "//*[@id='block-locale-language']/div[1]/ul/li[2]/a")
	public WebElementFacade languageToggleButtonES;
	
	@FindBy(xpath = "//*[@id='node-582']/div/div/div/div/div[1]/div[2]/div[2]/a")
	public WebElementFacade getStartedButton;

	@FindBy(xpath = "//*[@id='node-582']/div/div/div/div/div[2]/div[1]/div[2]/ul/li[4]/a")
	public WebElementFacade loansVsGrantsLink;
	
	@FindBy(xpath = "//*[@id='node-582']/div/div/div/div/div[2]/div[2]/div[2]/a/img")
	public WebElementFacade BGHomepageLink;
	

	
	// *************************************************************************
	// Functions

}