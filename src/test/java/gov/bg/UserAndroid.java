package gov.bg;

import gov.bg.pages.BGPageAndroid;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

/**
 * Class bridges DailyRegression.java with BGPage.java 
 */

public class UserAndroid {

    BGPageAndroid bgPage;

    @Step
	public void open_page(String directoryPath) {
    	bgPage.clearCookies();
		String url = bgPage.setEnvironment() + directoryPath;
		bgPage.openAt(url);
	}
    
    @Step
    public void clickNavNode(String node) {
    	
    	switch(node) {
    	// Main nav
    		case "Browse": 
		case "Búsqueda":
			bgPage.clickBrowse();
			break;
		case "Newsroom": 
		case "Sala de Prensa": 
			bgPage.clickNews();
			break;
		case "Get Involved":
		case "Involúcrese":
			bgPage.clickInvolved();
			break;
		case "Help":
		case "Ayuda":
			bgPage.clickHelp();
			break;
		case "About Us":
		case "Sobre Nosotros":
			bgPage.clickAboutUs();
			break;
		// Sub nav
		// Browse	
		case "Browse by Category":
		case "Búsqueda por categoría":
			System.out.println("IM BEING CALLED");
			bgPage.clickBrowseByCategory();
			break;	
		case "Browse by State":
		case "Búsqueda por estado":
			bgPage.clickBrowseByState();
			break;	
		case "Browse by Agency":
		case "Búsqueda por agencia federal":
			bgPage.clickBrowseByAgency();
			break;		
		case "Other Resources":
		case "Otros recursos":
			bgPage.clickOtherResources();
			break;		
		// Newsroom	
		case "News & Updates":
		case "Noticias & Actualizaciones":
			bgPage.clickNewsAndUpdates();
			break;	
		case "Compass eNewsletter":
		case "Compass el boletín electrónico (en inglés)":
			bgPage.clickCompass();
			break;		
		// Get Involved
		case "Become an Advocate":
		case "Conviértase en un Representante":
			bgPage.clickBecomeAnAdvocate();
			break;	
		case "Become an Affiliate":
		case "Conviértase en un Afiliado":
			bgPage.clickBecomeAnAffiliate();
			break;	
		case "Link to Us":
		case "Enlace su sitio al nuestro":
			bgPage.clickLinkToUs();
			break;	
		// About Us
		case "Our Mission":
		case "Nuestra Misión":
			bgPage.clickOurMission();
			break;	
		case "Our History":
		case "Nuestra Historia":
			bgPage.clickOurHistory();
			break;	
		case "Our Partners":
		case "Nuestros Socios":
			bgPage.clickOurPartners();
			break;	
		case "Become a Partner":
		case "Conviértase en un socio":
			bgPage.clickBecomeAPartner();
			break;	
		case "Our Platform":
		case "Nuestra Plataforma":
			bgPage.clickOurPlatform();
			break;	
		case "Recognition":
		case "Reconocimiento":
			bgPage.clickRecognition();
			break;
		// Help
		case "Frequently Asked Questions (FAQS)":
		case "Preguntas comunes":
			bgPage.clickFAQs();
			break;
		case "Contact Us":
		case "Contáctenos":
			bgPage.clickContactUs();
			break;
		case "Privacy and Terms of Use":
		case "Privacidad y Términos de Uso":
			bgPage.clickPrivacyAndTermsOfUse();
			break;		
			
		default:
			System.err.println("INVALID BUTTON CLICKED");
			break;
    	}	
    }
   
    @Step
    public void clickFooterLink(String link) {
    	
    	switch(link) {
		case "Twitter": 
			bgPage.clickTwitter();
			break;
		case "Facebook":
			bgPage.clickFacebook();
			break;
		case "Youtube":
			bgPage.clickYoutube();
			break;
		case "White House":
			bgPage.clickWhiteHouse();
			break;
		case "USA.gov":
			bgPage.clickUSAGov();
			break;	
		case "SSABest":
		case "SSABest ES":
			bgPage.clickSSABest();
			break;	
		case "GovLoans":
		case "GovLoans ES":
			bgPage.clickGovLoans();
			break;	
		case "Disaster Assistance":
		case "Disaster Assistance ES":
			bgPage.clickDisasterAssistance();
			break;		

		default:
			System.err.println("INVALID LINK CLICKED");
			break;
    	}	
    }
    
    @Step
	public void verifyFooterURL(String expectedPageURL) {
  		
  		switch(expectedPageURL) {
  		case "Twitter": 
  			Assert.assertEquals("https://mobile.twitter.com/benefitsGOV", bgPage.processWindows());	
  			break;
  		case "Facebook":
  			Assert.assertTrue(bgPage.processWindows().contains("facebook.com/benefitsGOV"));
  			break;
  		case "Youtube":
  			Assert.assertEquals("https://m.youtube.com/user/BenefitsGOV", bgPage.processWindows());	
  			break;
  		case "White House":
  			Assert.assertEquals("https://www.whitehouse.gov/", bgPage.processWindows());	
  			break;
  		case "USA.gov":
  			Assert.assertEquals("https://www.usa.gov/", bgPage.processWindows());	
  			break;
  		case "SSABest":
  			Assert.assertEquals("https://ssabest.benefits.gov/", bgPage.processWindows());	
  			break;
  		case "SSABest ES":	
  			Assert.assertEquals("https://ssabest.benefits.gov/es", bgPage.processWindows());	
  			break;
  		case "GovLoans":
  			Assert.assertEquals("https://www.govloans.gov/", bgPage.processWindows());	
  			break;
  		case "GovLoans ES":
  			Assert.assertEquals("https://es.govloans.gov/", bgPage.processWindows());	
  			break;
  		case "Disaster Assistance":
  			Assert.assertEquals("https://www.disasterassistance.gov/", bgPage.processWindows());	
  			break;
  		case "Disaster Assistance ES":
  			Assert.assertEquals("https://www.disasterassistance.gov/es", bgPage.processWindows());	
  			break;
	
  		default:
			System.err.println("INVALID PAGE SENT");
			break;	
  		}
  	}	
    
    @Step
	public void clickBrowseByNode(String node) {
    	
    	switch(node){
    	case "Browse by Category":
    	case "Búsqueda por categoría":	
    		bgPage.clickCategoryNode();
    		break;
    	case "Browse by State":
    	case "Búsqueda por estado":	
    		bgPage.clickStateNode();
    		break;
    	case "Browse by Agency":
    	case "Búsqueda por agencia":	
    		bgPage.clickAgencyNode();
    		break;
    	case "Benefit Finder":
    	case "Buscador de Beneficios":	
    		bgPage.clickStartBenefitFinder();
    		break;	
    		
    	default:
			System.err.println("INVALID BUTTON CLICKED");
			break;	
    	}
	}
    
    // Verify homepage
    @Step
   	public void verifyHomepageTitle(String language) {
       	
    	if(language.equals("EN")){
    		Assert.assertEquals(bgPage.pullPageTitle(bgPage.getHomepageTitleXpath()), "Looking for Benefits?");
    	}
    	else if(language.equals("ES")){
    		Assert.assertEquals(bgPage.pullPageTitle(bgPage.getHomepageTitleXpath()), "¿Busca Beneficios?");
    	}
   	}
    
    // Personalization
    @Step
    public void clickPznButtons(String node) {
    		bgPage.clickenterStateOrTerritoryTextbox(node);
    		bgPage.clickStateDropdownButton();
    }
    
    @Step
	public void verifyStateName(String expectedStateName) {
    	String currentStateName = bgPage.pullStateName();
    	Assert.assertEquals(currentStateName, expectedStateName);
	}
     
    @Step
	public void clickChangeLocation() {
		bgPage.clickChangeLocationButton();
	}
    
    @Step
	public void verifyTextfieldVisible() {
    	Assert.assertEquals(true, bgPage.enterStateOrTerritoryTextbox.isDisplayed());
	}
    
    @Step
	public void verifyBenefitTitles() {
    	for(int i = 0; i < 5; i++){	
    		bgPage.pznBenefitTabs().get(i).click();
    		boolean visible = bgPage.pznBenefitCategory().get(i).isDisplayed();
    		Serenity.takeScreenshot();
   
    		Assert.assertEquals(visible, true);
		}
	}
    
    // FAQ
    @Step
   	public void clickExpandFAQ() {
    	bgPage.clickExpandFAQButtons();
   	}
    
    @Step
   	public void clickMinimizeFAQ() {
    	bgPage.clickMinimizeFAQButtons();
   	}

    @Step
   	public void verifyFAQAnswersArePresent() {
    	Boolean answersVisible = bgPage.checkFAQAnswersShow();
    	Assert.assertTrue(answersVisible);
   	}
    
    @Step
   	public void verifyFAQAnswersAreHidden() {
    	Boolean answersVisible = bgPage.checkFAQAnswersHidden();
    	Assert.assertTrue(answersVisible);
   	}
    
    // Language toggle
    @Step
   	public void clickToggleLanguageButtonNode() {
    	bgPage.clickToggleLanguageButton();
   	}
    
    // Browse by category
    @Step
    public void clickBrowseByCategoryNode() {
    	bgPage.clickCategoryTitle();
   	}
    
    @Step
   	public void verifyCategoryTitle() {
    	Assert.assertEquals(bgPage.pullCategoryTitle(), bgPage.pullPageTitle(bgPage.getPageTitleXpath()));
   	}
    
    @Step
    public void clickBrowseByBenefitNode() {
    	bgPage.clickBenefitTitle();
   	}
    
    @Step
   	public void verifyBenefitTitle() {
    	Assert.assertEquals(bgPage.pullBenefitTitle(), bgPage.pullPageTitle(bgPage.getPageTitleXpath()));
   	}
    
    // Other Resources 
	@Step
	public void verifyGroupHeadingsEN(String filterType) {

		switch (filterType) {
		case "-ANY-":
			List<String> expectedHeadingsEN = new ArrayList<>(Arrays.asList("Federal", "State", "Other"));
			for (int i = 0; i < expectedHeadingsEN.size(); i++) {
				Assert.assertEquals(expectedHeadingsEN.get(i), bgPage.checkGroupHeadingNodes().get(i));
			}
			break;

		case "Federal":
		case "State":
		case "Other":
			Assert.assertEquals(filterType, bgPage.checkGroupHeadingNodes().get(0));
			break;

		case "Deleware":
		case "Nevada":
			Assert.assertEquals("State", bgPage.getHeadingNode().getText());
			break;
		}
	}
    	 	
	@Step
	public void verifyGroupHeadingsES(String filterType) {

		switch (filterType) {
		case "-TODAS-":
			List<String> expectedHeadingsES = new ArrayList<>(Arrays.asList("Federal", "Estado", "Otro"));
			for (int i = 0; i < expectedHeadingsES.size(); i++) {
				Assert.assertEquals(expectedHeadingsES.get(i), bgPage.checkGroupHeadingNodes().get(i));
			}
			break;

		case "Federal":
		case "Estado":
		case "Otro":
			Assert.assertEquals(filterType, bgPage.checkGroupHeadingNodes().get(0));
			break;

		case "Deleware":
		case "Nevada":
			Assert.assertEquals("Estado", bgPage.getHeadingNode().getText());
			break;
		}
	}
     
    @Step
   	public void clickFilterByType(String filterType) {
    	bgPage.selectFilterByType(filterType);
   	}
    
    @Step
   	public void clickFilterByState(String filterType) {
    	bgPage.selectFilterByState(filterType);
   	}
    
    // news and updates, Compass 
    @Step 
   	public void verifyNewsArticles() {
    	Assert.assertEquals(5, bgPage.checkNewsArticles());
   	}
    
    @Step 
	public void clickNewsArticle(String articleNum) {
    	bgPage.clickNewsArticleNodes(articleNum);
   	}
    
    @Step 
   	public void verifyNewsArticleTitle(String articleNum) {	
    	Assert.assertEquals(bgPage.pullNewsAndUpdatesArticleTitle(articleNum), bgPage.pullPageTitle(bgPage.getPageTitleXpath()));
   	}
	
    @Step 
   	public void verifyCompassArticleTitle(String articleNum) {	
    	Assert.assertEquals(bgPage.pullCompassArticleTitle(articleNum), bgPage.pullCurrentCompassTitle(articleNum));
   	}
    
    @Step 
   	public void verifyCompassArticles() {
    	Assert.assertEquals(6, bgPage.checkCompassArticles());
    }
    
    @Step 
	public void clickCompassArticle(String articleNum) { 	
    	bgPage.clickCompassArticleNodes(articleNum);
   	}
    
    @Step 
   	public void clickNewsNavButton(String buttonType) {
          	
    	switch(buttonType) {
		case "next": 
			bgPage.clickNewsNavNextNode();
			break;
		case "prev":
			bgPage.clickNewsNavPrevNode();
			break;
		case "first":
			bgPage.clickNewsNavFirstNode();
			break;
		case "last":
			bgPage.clickNewsNavLastNode();
			break;
    	}	
    }
    
    @Step 
   	public void verifyNewsAndUpdatesNavButtons(String buttonType) {	
    	
    	switch(buttonType) {
		case "next": 
			Assert.assertTrue(bgPage.getWindowUrl().contains("newsroom/news-and-updates?page=1"));
			break;
		case "prev":
			Assert.assertTrue(bgPage.getWindowUrl().contains("newsroom/news-and-updates"));
			break;
		case "first":
			Assert.assertTrue(bgPage.getWindowUrl().contains("newsroom/news-and-updates"));
			break;
		case "last":
			int lastPageNum = Integer.parseInt(bgPage.getNewsAndUpdatesLastPageNumber()) - 1;
			
			Assert.assertTrue(bgPage.getWindowUrl().contains("newsroom/news-and-updates?page=" + lastPageNum));
			break;
    	}	
   	}
    
    public void verifyNewsAndUpdatesNavButtonsES(String buttonType) {	
    	if(buttonType.equals("last")){
    		int lastPageNum = Integer.parseInt(bgPage.getNewsAndUpdatesLastPageNumber()) - 1;
			
			Assert.assertTrue(bgPage.getWindowUrl().contains("newsroom/news-and-updates?page=" + lastPageNum));
    	}
    }
    
    
    @Step 
   	public void verifyArticleType(String articleType) {	    	
    	Assert.assertTrue(bgPage.checkArticleType(articleType));
    }
    
    @Step
   	public void clickFilterByNewsType(String filterType) {
    	bgPage.selectFilterByNewsType(filterType);
   	}
    
    @Step
   	public void clickFilterByBenefitCategory(String filterType) {
    	bgPage.selectFilterByBenefitCategory(filterType);
   	}
    
    // Slider
    @Step
   	public void clickSliderTile(String sliderNum) {
    	bgPage.clickSliderTileNode(sliderNum);
   	}
    
    @Step 
   	public void verifySliderTitle(String sliderNum, String language) {	
    	    	
    	String selectedUrl = "";
    	
    	switch(sliderNum) {
		case "1": 
			if(language.equals("EN")){
   				Assert.assertTrue(bgPage.getWindowUrl().contains("benefits.gov/newsroom/eNewsletter"));
   			}
   			else if(language.equals("ES")){
   				Assert.assertTrue(bgPage.getWindowUrl().contains("benefits.gov/es/newsroom/eNewsletter"));
   			}
   			break;
		case "2": 
	    	Assert.assertEquals(bgPage.pullSliderTitle().split("\n")[1], bgPage.pullPageTitle(bgPage.getPageTitleXpath()));
			break;
   		case "3": 
   			Assert.assertEquals(bgPage.pullSliderTitle().split("\n")[1], bgPage.pullPageTitle(bgPage.getPageTitleXpath()));
			break;
		case "4": 
			selectedUrl = "https://www.youtube.com/watch?v=zz0UoSL-Ivw";
			Assert.assertEquals(selectedUrl, bgPage.processWindows());	
			break;
		case "5": 
			selectedUrl = "https://www.careeronestop.org/WorkerReEmployment/default.aspx";
			Assert.assertEquals(selectedUrl, bgPage.processWindows());
			break;
		case "6": 
			if(language.equals("EN")){
				Assert.assertTrue(bgPage.getWindowUrl().contains("benefits.gov/about-us#recognition"));
   			}
   			else if(language.equals("ES")){	
   				Assert.assertTrue(bgPage.getWindowUrl().contains("benefits.gov/es/sobre-nosotros#reconocimiento"));
   			}
   			break;
    	}
   	}
  
    @Step
	public void shouldSeePage(String expectedPageName) {

		switch(expectedPageName) {
		case "Browse":
			Assert.assertEquals(bgPage.pullPageTitle(bgPage.getHomepageTitleXpath()), "Looking for Benefits?");
			break;
		case "Búsqueda":
			Assert.assertEquals(bgPage.pullPageTitle(bgPage.getHomepageTitleXpath()), "¿Busca Beneficios?");
			break;	

		case "Newsroom": 
			Assert.assertEquals(bgPage.pullPageTitle(bgPage.getPageTitleXpath()), "News & Updates");
			break;
		case "Sala de Prensa": 
			Assert.assertEquals(bgPage.pullPageTitle(bgPage.getPageTitleXpath()), "Noticias & Actualizaciones");
			break;	
		
		case "Help":
			Assert.assertEquals(bgPage.pullPageTitle(bgPage.getPageTitleXpath()), "Frequently Asked Questions (FAQS)");
			break;
		case "Ayuda":
			Assert.assertEquals(bgPage.pullPageTitle(bgPage.getPageTitleXpath()), "Preguntas comunes");
			break;	
			
		case "Compass eNewsletter":
		case "Compass el boletín electrónico (en inglés)":
			Assert.assertEquals(bgPage.pullPageTitle(bgPage.getCompassTitleXpath()), "Quarterly eNewsletter About the Benefits.gov Program");
			break;	
			
		//Get Involved sub pages	
		case "Become an Advocate":
		case "Conviértase en un Representante":
		case "Become an Affiliate":
		case "Conviértase en un Afiliado":		
		case "Link to Us":
		case "Enlace su sitio al nuestro":	
		//About Us sub pages	
		case "Our Mission":
		case "Nuestra Misión":		
		case "Our History":
		case "Nuestra Historia":		
		case "Our Partners":
		case "Nuestros Socios":		
		case "Become a Partner":
		case "Conviértase en un socio":		
		case "Our Platform":
		case "Nuestra Plataforma":	
		case "Recognition":
		case "Reconocimiento":	
			Assert.assertEquals(bgPage.pullSubpageTitle(expectedPageName), expectedPageName);
			break;	
			
		//Main Nav	
		case "Get Involved":
		case "Involúcrese":
		case "About Us":
		case "Sobre Nosotros":		
		//Sub Nav	
		case "Browse by Category":
		case "Búsqueda por categoría":				
		case "Browse by State":
		case "Búsqueda por estado":	
		case "Browse by Agency":
		case "Búsqueda por agencia federal":
			
		case "Other Resources":
		case "Otros recursos":	

		case "News & Updates":
		case "Noticias & Actualizaciones":	
			
		case "Frequently Asked Questions (FAQS)":
		case "Preguntas comunes":	
		case "Contact Us":
		case "Contáctenos":	
		case "Privacy and Terms of Use":
		case "Privacidad y Términos de Uso":	
			
		case "Benefit Finder":
		case "Buscador de Beneficios":	
			
			Assert.assertEquals(bgPage.pullPageTitle(bgPage.getPageTitleXpath()), expectedPageName);
			break;
					
		default:
			System.err.println("INVALID PAGE SENT");
			break;
		} 
	}
     

}