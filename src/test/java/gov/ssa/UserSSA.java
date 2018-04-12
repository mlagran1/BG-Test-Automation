package gov.ssa;

import gov.ssa.pages.SSAPage;
import gov.ssa.pages.SSAHomepage;
import gov.ssa.pages.SSABrowseByPage;
import gov.ssa.pages.SSAFAQPage;

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
	SSABrowseByPage ssaBrowseByPage;
	SSAFAQPage ssaFAQPage;

    @Step
    public void onHomePage() {
    	
    	ssaPage.clearCookies();
		String url = ssaPage.setEnvironment();		
		ssaPage.openAt(url);		
		//System.out.println("Directory path is: " + url);
    }

    @Step
	public void open_page(String directoryPath) {
    	
    	ssaPage.clearCookies();
		String url = ssaPage.setEnvironment() + directoryPath;
		ssaPage.openAt(url);
		//System.out.println("Directory path is: " + url);	
	}
       
    @Step
    public void clickNavNode(String node) {
    	
    	switch(node) {
    	//sub nav links 
		case "SSA Best Questionnaire": 
		case "Buscador de Beneficios":
			ssaPage.clickSubNavButtons(ssaHomepage.benefitsMainNavButton, ssaHomepage.questionnaireSubNavButton);
			break;	
		case "Browse By Category": 
		case "Búsqueda por Categoría":
			ssaPage.clickSubNavButtons(ssaHomepage.benefitsMainNavButton, ssaHomepage.browseByCategorySubNavButton);
			break;	
		case "Other Resources": 
		case "Otros recursos":
			ssaPage.clickSubNavButtons(ssaHomepage.benefitsMainNavButton, ssaHomepage.otherResourcesSubNavButton);
			break;	
		case "FAQs": 
		case "Preguntas más frecuentes":
			ssaPage.clickSubNavButtons(ssaHomepage.helpMainNavButton, ssaHomepage.FAQSubNavButton);
			break;	
		case "Contact Us": 
		case "Contáctenos":
			ssaPage.clickSubNavButtons(ssaHomepage.helpMainNavButton, ssaHomepage.contactUsSubNavButton);
			break;	
		case "Privacy & Terms of Use": 
		case "Privacidad y Términos de Uso":
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
   		
   		switch(expectedPageName) {
   		case "SSA Best Questionnaire": 
   			Assert.assertEquals("Benefit Finder", pageTitle);
   			break;
   		case "Browse By Category": 
   		case "Other Resources":
   		case "FAQs":	
   		case "Contact Us":
   		case "Privacy & Terms of Use":
   			
   		case "Buscador de Beneficios": 
   		case "Búsqueda por Categoría":
   		case "Otros recursos":	
   		case "Preguntas más frecuentes":
   		case "Contáctenos":
   		case "Privacidad y Términos de Uso":
   			
		case "Family":	
		case "Disability Assistance":	
		case "Insurance":	
		case "Medicare":	
		case "Retirement":	
		case "Spouse & Widow(er)":	
		case "Supplemental Security Income":	
		case "Veterans":
			
		case "Asistencia por discapacidad":	
		case "Cónyuge y viudo o viuda":	
		case "Jubilación":	
		case "Seguridad de Ingreso Suplementario":	
		case "Familia":	
		case "Seguros":	
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
    	
    	ssaPage.scrollToBottom();
    
    	switch(link) {
		case "The White House": 
			ssaHomepage.whiteHouseFooterLink.click();
			break;
		case "USA.gov":
		case "USA.gov ES":
			ssaHomepage.USAGovFooterLink.click();
			break;
		case "Benefits.gov": 
		case "Benefits.gov ES":
			ssaHomepage.BGFooterLink.click();
			break;
		case "Disaster Assistance":
		case "Disaster Assistance ES":
			ssaHomepage.DAFooterLink.click();
			break;
		case "GovLoans": 
		case "GovLoans ES":
			ssaHomepage.GLFooterLink.click();
			break;
		case "Privacy & Terms of Use": 
		case "Privacidad y Términos de Uso":
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
			Assert.assertEquals(selectedUrl, ssaPage.processWindows());		
			break;
		case "USA.gov": 
			selectedUrl = "https://www.usa.gov/";
			Assert.assertEquals(selectedUrl, ssaPage.processWindows());		
			break;
		case "USA.gov ES": 
			selectedUrl = "https://gobierno.usa.gov//";
			Assert.assertEquals(selectedUrl, ssaPage.processWindows());		
			break;
		case "Benefits.gov": 
			selectedUrl = "https://www.benefits.gov/";
			Assert.assertEquals(selectedUrl, ssaPage.processWindows());		
			break;
		case "Benefits.gov ES":
			selectedUrl = "https://www.benefits.gov/es";
			Assert.assertEquals(selectedUrl, ssaPage.processWindows());		
			break;
		case "Disaster Assistance": 
			selectedUrl = "https://www.disasterassistance.gov/";
			Assert.assertEquals(selectedUrl, ssaPage.processWindows());		
			break;
		case "Disaster Assistance ES": 
			selectedUrl = "https://www.disasterassistance.gov/es";
			Assert.assertEquals(selectedUrl, ssaPage.processWindows());		
			break;
		case "GovLoans": 
			selectedUrl = "https://www.govloans.gov/";
			Assert.assertEquals(selectedUrl, ssaPage.processWindows());		
			break;
		case "GovLoans ES": 
			selectedUrl = "https://es.govloans.gov/";
			Assert.assertEquals(selectedUrl, ssaPage.processWindows());		
			break;
		case "Privacy & Terms of Use": 
			Assert.assertEquals(expectedPageURL, ssaPage.pullPageTitle());
   			break;
		case "Privacidad y Términos de Uso":
			Assert.assertEquals(expectedPageURL, ssaPage.pullPageTitle());
   			break;
		
		default:
			System.err.println("INVALID PAGE SENT");
			break;
  		}		
  	}	

    @Step
    public void clickHomepageLink(String node) {
    	
    	switch(node) {
		case "Start Questionnaire": 
		case "Empieza Cuestionario": 
			ssaHomepage.startQuestionnaireButton.click();
			break;	
		case "Benefits.gov": 
		case "Benefits.gov ES": 
			ssaHomepage.BGHomepageLink.click();
			break;	
		case "Help With Medicare": 
		case "Medicare ES": 
			ssaPage.scrollToBottom();
			ssaHomepage.helpWithMedicareLink.click();
			break;	
		case "BG Logo": 
		case "BG Logo ES": 
			ssaHomepage.BGHomepageLogoLink.click();
			break;	
		case "SSA.gov": 
		case "SSA.gov ES": 
			ssaHomepage.SSAGovLink.click();
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
		case "Start Questionnaire": 
			Assert.assertEquals("Benefit Finder", ssaPage.pullPageTitle());
			break;	
		case "Empieza Cuestionario":
			Assert.assertEquals("Buscador de Beneficios", ssaPage.pullPageTitle());
			break;	
		case "Benefits.gov": 
		case "BG Logo": 
			selectedUrl = "https://www.benefits.gov/";
			Assert.assertEquals(selectedUrl, ssaPage.processWindows());
			break;
		case "Benefits.gov ES": 
		case "BG Logo ES": 
			selectedUrl = "https://www.benefits.gov/es";
			Assert.assertEquals(selectedUrl, ssaPage.processWindows());
			break;
		case "Help With Medicare": 
			selectedUrl = "https://www.ssa.gov/benefits/medicare/prescriptionhelp/";
			Assert.assertEquals(selectedUrl, ssaPage.processWindows());
			break;
		case "Medicare ES": 
			selectedUrl = "https://www.ssa.gov/espanol/beneficios/medicare/medicamentos/";
			Assert.assertEquals(selectedUrl, ssaPage.processWindows());
			break;
		case "SSA.gov": 
			selectedUrl = "https://www.ssa.gov/";
			Assert.assertEquals(selectedUrl, ssaPage.processWindows());
			break;
		case "SSA.gov ES": 
			selectedUrl = "https://www.ssa.gov/espanol/";
			Assert.assertEquals(selectedUrl, ssaPage.processWindows());
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
			ssaHomepage.homeLogoButton.click();
			break;	
		case "Home Nav": 
		case "Home Nav ES":
			ssaHomepage.homeMainNavButton.click();
			break;
  		default:
			System.err.println("INVALID BUTTON CLICKED");
			break;	
  		}	
  	}	
    
    @Step
	public void verifyHomepage() {
    	Assert.assertEquals("Welcome to the Benefit Eligibility Screening Tool (BEST)", ssaPage.pullHomepageTitle());
  	}
    
    @Step
	public void verifyHomepageES() {
    	Assert.assertEquals("Bienvenido a El Programa Para Determinar Elegibilidad a Beneficios (BEST)", ssaPage.pullHomepageTitle());
    	
  	}	

    @Step
	public void clickToggleLanguage() {
    	ssaHomepage.languageToggleButton.click();
  	}	
    
    //browse by category tests
    @Step
    public void clickBrowseByCategorySSA(String categoryItem) {
    	ssaBrowseByPage.clickCategoryTitle(categoryItem);
    }
    
    @Step
    public void clickBenefitDetailNode() {
    	ssaBrowseByPage.clickBenefitTitle();
   	}
    
    @Step
   	public void verifyBenefitTitle() {
    	Assert.assertEquals(ssaBrowseByPage.getBenefitTitle(), ssaPage.pullBenefitTitle());
   	}
    
    //FAQ
    @Step
    public void clickFAQ(String questionNum) {
    	ssaFAQPage.clickFAQNode(questionNum);
    }
    
    @Step
   	public void verifyFAQTitle() {
    	Assert.assertEquals(ssaFAQPage.getFAQquestion(), ssaPage.pullPageTitle());
   	}
    
    
}