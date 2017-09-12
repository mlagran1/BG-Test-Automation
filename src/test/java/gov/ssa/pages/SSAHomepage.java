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

//@DefaultUrl("https://www.govloans.gov")
public class SSAHomepage extends PageObject {
    
	// *************************************************************************
	// FindBy / private variables section
	
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
	@FindBy(xpath = "//*[@id='node-15']/div/div/div/div/div/div[1]/ul/li[1]/a")
	public WebElementFacade whiteHouseFooterLink;
						
	@FindBy(xpath = "//*[@id='node-15']/div/div/div/div/div/div[1]/ul/li[2]/a")
	public WebElementFacade USAGovFooterLink;
	
	@FindBy(xpath = "//*[@id='node-15']/div/div/div/div/div/div[2]/ul/li[1]/a")
	public WebElementFacade BGFooterLink;
	
	@FindBy(xpath = "//*[@id='node-15']/div/div/div/div/div/div[2]/ul/li[2]/a")
	public WebElementFacade DAFooterLink;
	
	@FindBy(xpath = "//*[@id='node-15']/div/div/div/div/div/div[2]/ul/li[3]/a")
	public WebElementFacade GLFooterLink;
	
	@FindBy(xpath = "//*[@id='node-15']/div/div/div/div/div/div[3]/h5/a")
	public WebElementFacade privacyAndTermsFooterLink;
	
	
	
	// *************************************************************************
	// Functions

}