package gov.ssa;

import gov.ssa.pages.SSAPage;
import gov.ssa.pages.SSAHomepage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

public class UserSSA {

	SSAPage ssaPage;
	SSAHomepage ssaHomepage;

    @Step
    public void onHomePage() {
    	
    	ssaPage.clearCookies();
		String url = ssaPage.setEnvironment();		
		ssaPage.openAt(url);		
		System.out.println("Directory path is: " + ssaPage.setEnvironment());
    }

    @Step
	public void open_page(String directoryPath) {
    	
    	ssaPage.clearCookies();
		String url = ssaPage.setEnvironment() + directoryPath;
		ssaPage.openAt(url);
		System.out.println("Directory path is: " + url);	
	}
    

    @Step
    public void clickNavNode(String node) {
    	
    	switch(node) {
    	//sub nav links 
		case "SSA Best Questionnaire": 
			ssaPage.clickSubNavButtons(ssaHomepage.benefitsMainNavButton, ssaHomepage.questionnaireSubNavButton);
			break;	
		case "Browse By Category": 
			ssaPage.clickSubNavButtons(ssaHomepage.benefitsMainNavButton, ssaHomepage.browseByCategorySubNavButton);
			break;	
		case "Other Resources": 
			ssaPage.clickSubNavButtons(ssaHomepage.benefitsMainNavButton, ssaHomepage.otherResourcesSubNavButton);
			break;	
		case "FAQs": 
			ssaPage.clickSubNavButtons(ssaHomepage.helpMainNavButton, ssaHomepage.FAQSubNavButton);
			break;	
		case "Contact Us": 
			ssaPage.clickSubNavButtons(ssaHomepage.helpMainNavButton, ssaHomepage.contactUsSubNavButton);
			break;	
		case "Privacy & Terms of Use": 
			ssaPage.clickSubNavButtons(ssaHomepage.helpMainNavButton, ssaHomepage.privacyAndTermsSubNavButton);
			break;	
			
		default:
			System.err.println("INVALID BUTTON CLICKED");
			break;
    	}	
    }
            
    
    @Step
   	public void shouldSeePage(String expectedPageName) {

   		String pageTitle = ssaPage.pullPageTitle();
   		//String subpageTitle = bgPage.pullSubpageTitle(expectedPageName);
   		
   		System.out.println("page title is: " + pageTitle);
   		System.out.println("expected PageName is: " + expectedPageName);
   		
   		switch(expectedPageName) {
   		case "SSA Best Questionnaire": 
   			Assert.assertEquals("Benefit Finder", pageTitle);
   			break;
   		case "Browse By Category": 
   		case "Other Resources":
   		case "FAQs":	
   		case "Contact Us":
   		case "Privacy & Terms of Use":
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
		case "The White House": 
			ssaHomepage.whiteHouseFooterLink.click();
			break;
		case "USA.gov": 
			ssaHomepage.USAGovFooterLink.click();
			break;
		case "Benefits.gov": 
			ssaHomepage.BGFooterLink.click();
			break;
		case "Disaster Assistance": 
			ssaHomepage.DAFooterLink.click();
			break;
		case "GovLoans": 
			ssaHomepage.GLFooterLink.click();
			break;
		case "Privacy & Terms of Use": 
			ssaHomepage.privacyAndTermsFooterLink.click();
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
  					
		case "The White House": 
			selectedUrl = "https://www.whitehouse.gov/";
			break;
		case "USA.gov": 
			selectedUrl = "https://www.usa.gov/";
			break;
		case "Benefits.gov": 
			selectedUrl = "https://www.benefits.gov/";
			break;
		case "Disaster Assistance": 
			selectedUrl = "https://www.disasterassistance.gov/";
			break;
		case "GovLoans": 
			selectedUrl = "https://www.govloans.gov/";
			break;
		case "Privacy & Terms of Use": 
			selectedUrl = "https://ssabest.benefits.gov/help/privacy-and-terms-of-use";
			break;
		
		default:
			System.err.println("INVALID PAGE SENT");
			break;
  		}
  		Assert.assertEquals(selectedUrl, ssaPage.processWindows());		
  	}	


}