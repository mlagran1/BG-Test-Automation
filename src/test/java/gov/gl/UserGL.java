package gov.gl;

import gov.gl.pages.GLPage;
import gov.gl.pages.GLHomepage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

public class UserGL {

	GLPage glPage;
	GLHomepage glHomepage;

    @Step
    public void onHomePage() {
    	
    	glPage.clearCookies();
		String url = glPage.setEnvironment();		
		glPage.openAt(url);		
		System.out.println("Directory path is: " + glPage.setEnvironment());
    }

    @Step
	public void open_page(String directoryPath) {
    	
    	glPage.clearCookies();
		String url = glPage.setEnvironment() + directoryPath;
		glPage.openAt(url);
		System.out.println("Directory path is: " + url);	
	}
    

    @Step
    public void clickNavNode(String node) {
    	
    	switch(node) {
    	//sub nav links 
		case "Loan Finder": 
			glPage.clickSubNavButtons(glHomepage.loansMainNavButton, glHomepage.loanFinderSubNavButton);
			break;	
		case "Browse By Category": 
			glPage.clickSubNavButtons(glHomepage.loansMainNavButton, glHomepage.browseByCategorySubNavButton);
			break;	
		case "Other Resources": 
			glPage.clickSubNavButtons(glHomepage.loansMainNavButton, glHomepage.otherResourcesSubNavButton);
			break;	
		case "Overview": 
			glPage.clickSubNavButtons(glHomepage.aboutMainNavButton, glHomepage.overviewSubNavButton);
			break;	
		case "Link To GovLoans.gov": 
			glPage.clickSubNavButtons(glHomepage.aboutMainNavButton, glHomepage.linkToGovloansSubNavButton);
			break;	
		case "FAQs": 
			glPage.clickSubNavButtons(glHomepage.helpMainNavButton, glHomepage.FAQSubNavButton);
			break;	
		case "Contact Us": 
			glPage.clickSubNavButtons(glHomepage.helpMainNavButton, glHomepage.contactUsSubNavButton);
			break;	
		case "Glossary": 
			glPage.clickSubNavButtons(glHomepage.helpMainNavButton, glHomepage.glossarySubNavButton);
			break;	
		case "Privacy & Terms of Use": 
			glPage.clickSubNavButtons(glHomepage.helpMainNavButton, glHomepage.privacyAndTermsSubNavButton);
			break;	
			
		default:
			System.err.println("INVALID BUTTON CLICKED");
			break;
    	}	
    }
             
    
    @Step
	public void shouldSeePage(String expectedPageName) {

		String pageTitle = glPage.pullPageTitle();
		//String subpageTitle = bgPage.pullSubpageTitle(expectedPageName);
		
		System.out.println("page title is: " + pageTitle);
		System.out.println("expected PageName is: " + expectedPageName);
		
		switch(expectedPageName) {
		case "Loan Finder": 
		case "Browse By Category": 
		case "Other Resources":
		case "Overview":	
		case "Link To GovLoans.gov":
		case "FAQs":	
		case "Contact Us":
		case "Glossary":	
		case "Privacy & Terms of Use":
			
		case "Agriculture":	
		case "Business":
		case "Disaster Relief":
		case "Education":
		case "Housing":
		case "Veteran":
			
			Assert.assertEquals(expectedPageName, pageTitle);
			break;
			
		default:
			System.err.println("INVALID PAGE SENT");
			break;
		} 
	}
    

    
    //Footer Test
    @Step
    public void clickFooterLink(String link) {
    	
    	switch(link) {
		case "Espanol": 
			glHomepage.espanolFooterLink.click();
			break;
		case "Loan Finder": 
			glHomepage.loanFinderFooterLink.click();
			break;
		case "Browse By Category": 
			glHomepage.byCategoryFooterLink.click();
			break;
		case "Other Resources": 
			glHomepage.otherResourcesFooterLink.click();
			break;
		case "Overview": 
			glHomepage.overviewFooterLink.click();
			break;
		case "Link To GovLoans.gov": 
			glHomepage.linkToGovLoansFooterLink.click();
			break;
		case "FAQs": 
			glHomepage.FAQFooterLink.click();
			break;
		case "Glossary": 
			glHomepage.glossaryFooterLink.click();
			break;
		case "Contact Us": 
			glHomepage.contactUsFooterLink.click();
			break;
		case "Privacy & Terms of Use": 
			glHomepage.privacyAndTermsFooterLink.click();
			break;
		case "Benefits.gov": 
			glHomepage.BGFooterLink.click();
			break;
		case "USA.gov": 
			glHomepage.USAGovFooterLink.click();
			break;
		case "Whitehouse.gov": 
			glHomepage.whiteHouseFooterLink.click();
			break;
		
		default:
			System.err.println("INVALID LINK CLICKED");
			break;
    	}	
    }
    
    @Step
	public void verifyFooterURL(String expectedPageURL) {
  		String selectedUrl = "";
  		
  		switch(expectedPageURL) { 	
  		
		case "Loan Finder": 
		case "Browse By Category": 
		case "Other Resources": 
		case "Overview": 
		case "Link To GovLoans.gov": 
		case "FAQs": 
		case "Glossary": 
		case "Contact Us": 
		case "Privacy & Terms of Use": 
			Assert.assertEquals(expectedPageURL, glPage.pullPageTitle());
			break;
			
		case "Espanol": 
  			Assert.assertEquals("https://es.govloans.gov/", glPage.getWindowUrl());
			break;
		case "Benefits.gov": 
			selectedUrl = "https://www.benefits.gov/";
			Assert.assertEquals(selectedUrl, glPage.processWindows());
			break;
		case "USA.gov": 
			selectedUrl = "https://www.usa.gov/";
			Assert.assertEquals(selectedUrl, glPage.processWindows());
			break;
		case "Whitehouse.gov": 
			selectedUrl = "https://www.whitehouse.gov/";
			Assert.assertEquals(selectedUrl, glPage.processWindows());
			break;
		
  		default:
			System.err.println("INVALID PAGE SENT");
			break;	
  		}	
  	}	
    
    
    @Step
    public void clickCategoriesHomepage(String node) {
    	
    	switch(node) {
		case "Agriculture": 
			glHomepage.agricultureHomepageLink.click();
			break;	
		case "Business": 
			glHomepage.businessHomepageLink.click();
			break;	
		case "Disaster Relief": 
			glHomepage.disasterReliefHomepageLink.click();
			break;	
		case "Education": 
			glHomepage.educationHomepageLink.click();
			break;	
		case "Housing": 
			glHomepage.housingHomepageLink.click();
			break;	
		case "Veteran": 
			glHomepage.veteranHomepageLink.click();
			break;		
		default:
			System.err.println("INVALID BUTTON CLICKED");
			break;
    	}	
    }
    
    @Step
    public void clickHomepageLink(String node) {
    	
    	switch(node) {
		case "Get Started": 
			glHomepage.getStartedButton.click();
			break;	
		case "Loans vs Grants": 
			glHomepage.loansVsGrantsLink.click();
			break;	
		case "Benefits.gov": 
			glHomepage.BGHomepageLink.click();
			break;	
		default:
			System.err.println("INVALID BUTTON CLICKED");
			break;
    	}	
    }
    
    @Step
	public void verifyHomepageLink(String expectedPageURL) {
  		String selectedUrl = "";
  		
  		switch(expectedPageURL) { 	
		case "Get Started": 
			Assert.assertEquals("Loan Finder", glPage.pullPageTitle());
			break;	
		case "Loans vs Grants": 
  			Assert.assertEquals("https://www.govloans.gov/help/faqs#Government", glPage.getWindowUrl());
			break;
		case "Benefits.gov": 
			selectedUrl = "https://www.benefits.gov/";
			Assert.assertEquals(selectedUrl, glPage.processWindows());
			break;
  		default:
			System.err.println("INVALID PAGE SENT");
			break;	
  		}	
  	}	
    
    
    @Step
	public void clickHomeButton(String node) {
  		
  		switch(node) { 	
		case "Home Logo": 
			glHomepage.homeLogoButton.click();
			break;	
		case "Home Nav": 
			glHomepage.homeMainNavButton.click();
			break;
  		default:
			System.err.println("INVALID BUTTON CLICKED");
			break;	
  		}	
  	}	
    
    
    @Step
	public void verifyHomepage() {
    	Assert.assertEquals("https://www.govloans.gov/", glPage.getWindowUrl());
  	}	
    
    
//    @Step
//	public void clickToggleLanguage() {
//    	glHomepage.languageToggleButton.click();
//  	}	
    
    @Step
	public void verifyToggleLanguage(String language) {
  		
  		switch(language) { 	
		case "EN": 
			Assert.assertEquals("https://www.govloans.gov/", glPage.getWindowUrl());
			break;	
		case "ES": 
			Assert.assertEquals("https://es.govloans.gov/", glPage.getWindowUrl());
			break;
  		default:
			System.err.println("INVALID LANGUAGE");
			break;	
  		}	
  	}
    

}