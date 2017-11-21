package gov.gl;

import gov.gl.pages.GLPage;
import gov.gl.pages.GLHomepage;
import gov.gl.pages.GLBrowseByPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;


public class UserGL {

	GLPage glPage;
	GLHomepage glHomepage;
	GLBrowseByPage glBrowseByPage;

//    @Step
//    public void onHomePage() {
//    	
//    	glPage.clearCookies();
//		String url = glPage.setEnvironment();		
//		glPage.openAt(url);		
//		System.out.println("Directory path is: " + glPage.setEnvironment());
//    }

    @Step
	public void open_page(String language, String directoryPath) {
    	
    	glPage.clearCookies();		
    	
		String url = "https://" + (language.equals("es") ? "es." : "") + glPage.getEnvironment() + "govloans.gov" + directoryPath;
		
		glPage.openAt(url);
		System.out.println("Directory path is: " + url);	
	}
    
 
    
    
    @Step
    public void clickNavNode(String node) {
    	
    	switch(node) {
    	//sub nav links 
		case "Loan Finder": 
		case "Buscador de Préstamos": 
			glPage.clickSubNavButtons(glHomepage.loansMainNavButton, glHomepage.loanFinderSubNavButton);
			break;	
		case "Browse By Category": 
		case "Búsqueda por Categoría": 
			glPage.clickSubNavButtons(glHomepage.loansMainNavButton, glHomepage.browseByCategorySubNavButton);
			break;	
		case "Other Resources": 
		case "Otros Recursos": 
			glPage.clickSubNavButtons(glHomepage.loansMainNavButton, glHomepage.otherResourcesSubNavButton);
			break;	
		case "Overview": 
		case "Visión General": 
			glPage.clickSubNavButtons(glHomepage.aboutMainNavButton, glHomepage.overviewSubNavButton);
			break;	
		case "Link To GovLoans.gov": 
		case "Vínculo a GovLoans.gov": 
			glPage.clickSubNavButtons(glHomepage.aboutMainNavButton, glHomepage.linkToGovloansSubNavButton);
			break;	
		case "FAQs": 
		case "Preguntas más frecuentes": 
			glPage.clickSubNavButtons(glHomepage.helpMainNavButton, glHomepage.FAQSubNavButton);
			break;	
		case "Contact Us": 
		case "Contáctenos": 
			glPage.clickSubNavButtons(glHomepage.helpMainNavButton, glHomepage.contactUsSubNavButton);
			break;	
		case "Glossary": 
		case "Glosario": 
			glPage.clickSubNavButtons(glHomepage.helpMainNavButton, glHomepage.glossarySubNavButton);
			break;	
		case "Privacy & Terms of Use": 
		case "Privacidad y Términos de Uso": 
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
			
		case "Buscador de Préstamos": 
		case "Búsqueda por Categoría": 
		case "Otros Recursos": 
		case "Visión General": 
		case "Vínculo a GovLoans.gov": 
		case "Preguntas más frecuentes": 
		case "Contáctenos": 
		case "Glosario": 
		case "Privacidad y Términos de Uso": 
			
		case "Agriculture":	
		case "Business":
		case "Disaster Relief":
		case "Education":
		case "Housing":
		case "Veteran":
		case "General":
			
		case "Agrícolas":	
		case "Empresariales":
		case "Alivio de Desastre":
		case "Educación":
		case "Vivienda":
		case "Veteranos":
			
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
    	
 	
    	glPage.scrollToBottom();
    	
    	switch(link) {
		case "Espanol": 
		case "English": 
			glHomepage.homeLangFooterLink.click();
			break;
		case "Loan Finder": 
		case "Buscador de Préstamos": 
			glHomepage.loanFinderFooterLink.click();
			break;
		case "Browse By Category": 
		case "Búsqueda por Categoría": 
			glHomepage.byCategoryFooterLink.click();
			break;
		case "Other Resources": 
		case "Otros Recursos": 
			glHomepage.otherResourcesFooterLink.click();
			break;
		case "Overview": 
		case "Visión General": 
			glHomepage.overviewFooterLink.click();
			break;
		case "Link To GovLoans.gov": 
		case "Vínculo a GovLoans.gov": 
			glHomepage.linkToGovLoansFooterLink.click();
			break;
		case "FAQs": 
		case "Preguntas más frecuentes": 
			glHomepage.FAQFooterLink.click();
			break;
		case "Glossary": 
		case "Glosario": 
			glHomepage.glossaryFooterLink.click();
			break;
		case "Contact Us": 
		case "Contáctenos": 
			glHomepage.contactUsFooterLink.click();
			break;
		case "Privacy & Terms of Use":
		case "Privacidad y Términos de Uso": 
			glHomepage.privacyAndTermsFooterLink.click();
			break;
		case "Benefits.gov": 
		case "Benefits.gov ES": 
			glHomepage.BGFooterLink.click();
			break;
		case "USA.gov": 
		case "USA.gov ES":
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
			
		case "Buscador de Préstamos": 
		case "Búsqueda por Categoría": 
		case "Otros Recursos": 
		case "Visión General": 
		case "Vínculo a GovLoans.gov": 
		case "Preguntas más frecuentes": 
		case "Glosario": 
		case "Contáctenos": 
		case "Privacidad y Términos de Uso": 	
			Assert.assertEquals(expectedPageURL, glPage.pullPageTitle());
			break;
			
		case "Espanol": 
  			Assert.assertEquals("https://es.govloans.gov/", glPage.getWindowUrl());
			break;
		case "English": 
  			Assert.assertEquals("https://www.govloans.gov/", glPage.getWindowUrl());
			break;
		case "Benefits.gov": 
			selectedUrl = "https://www.benefits.gov/";
			Assert.assertEquals(selectedUrl, glPage.processWindows());
			break;
		case "Benefits.gov ES": 
			selectedUrl = "https://www.benefits.gov/es";
			Assert.assertEquals(selectedUrl, glPage.processWindows());
			break;
		case "USA.gov": 
			selectedUrl = "https://www.usa.gov/";
			Assert.assertEquals(selectedUrl, glPage.processWindows());
			break;
		case "USA.gov ES": 
			selectedUrl = "https://gobierno.usa.gov/";
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
		case "Agrícolas": 
			glHomepage.agricultureHomepageLink.click();
			break;	
		case "Business": 
		case "Empresariales": 
			glHomepage.businessHomepageLink.click();
			break;	
		case "Disaster Relief": 
		case "Alivio de Desastre": 
			glHomepage.disasterReliefHomepageLink.click();
			break;	
		case "Education": 
		case "Educación": 
			glHomepage.educationHomepageLink.click();
			break;	
		case "Housing": 
		case "Vivienda": 
			glHomepage.housingHomepageLink.click();
			break;	
		case "Veteran": 
		case "Veteranos": 
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
		case "Empezar": 
			glHomepage.getStartedButton.click();
			break;	
		case "Loans vs Grants": 
		case "Préstamos vs Subvenciones": 
			glHomepage.loansVsGrantsLink.click();
			break;	
		case "Benefits.gov": 
		case "Benefits.gov ES": 
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
		case "Empezar": 
			Assert.assertEquals("Buscador de Préstamos", glPage.pullPageTitle());
			break;	
		case "Loans vs Grants": 
  			Assert.assertEquals("https://govloans.gov/help/faqs#Government", glPage.getWindowUrl());
			break;
		case "Préstamos vs Subvenciones": 
  			Assert.assertEquals("https://es.govloans.gov/help/faqs#Government", glPage.getWindowUrl());
			break;
		case "Benefits.gov": 
			selectedUrl = "https://www.benefits.gov/";
			Assert.assertEquals(selectedUrl, glPage.processWindows());
			break;
		case "Benefits.gov ES": 
			selectedUrl = "https://www.benefits.gov/es";
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
		case "Home Logo ES": 
			glHomepage.homeLogoButton.click();
			break;	
		case "Home Nav": 
		case "Home Nav ES": 
			glHomepage.homeMainNavButton.click();
			break;
  		default:
			System.err.println("INVALID BUTTON CLICKED");
			break;	
  		}	
  	}	
    
    
    @Step
	public void verifyHomepage() {
    	//Assert.assertEquals("https://govloans.gov/", glPage.getWindowUrl());
    	Assert.assertTrue(glPage.getWindowUrl().equals("https://govloans.gov/") || glPage.getWindowUrl().equals("https://www.govloans.gov/"));
  	}	
    
    @Step
	public void verifyHomepageES() {
    	Assert.assertEquals("https://es.govloans.gov/", glPage.getWindowUrl());
  	}	
    
    
    @Step
	public void clickToggleLanguage() {
    	glHomepage.languageToggleButton.click();
  	}	
    
    
    //browse by category tests
    @Step
    public void clickBrowseByCategoryGL(String categoryItem) {
    	glBrowseByPage.clickCategoryTitle(categoryItem);
    }
    
    @Step
    public void clickLoanDetailNode() {
    	glBrowseByPage.clickLoanTitle();
   	}
    
    @Step
   	public void verifyLoanTitle() {
    	System.out.println("getLoanTitle : " + glBrowseByPage.getLoanTitle());
    	System.out.println("pullLoanTitle : " + glPage.pullLoanTitle());
    	Assert.assertEquals(glBrowseByPage.getLoanTitle(), glPage.pullLoanTitle());
   	}
    

}