package gov.bg;

import gov.bg.pages.BGPage;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

/**
 * Class bridges DailyRegression.java with BGPage.java 
 */

public class User {

    BGPage bgPage;


    @Step
	public void open_page(String directoryPath) {
    	
    	bgPage.clearCookies();
		String url = bgPage.setEnvironment() + directoryPath;
		bgPage.openAt(url);
	}
    
    @Step
    public void clickNavNode(String node) {
    	
    	switch(node) {
    	// -------- Main Nav Links --------
		case "newsroom": 
		case "Sala de Prensa": 
			bgPage.clickNews();
			break;
		case "get involved":
		case "Involúcrese":
			bgPage.clickInvolved();
			break;
		case "help":
		case "Ayuda":
			bgPage.clickHelp();
			break;
		case "about us":
		case "Sobre Nosotros":
			bgPage.clickAboutUs();
			break;
		case "browse":
			bgPage.clickBrowse();
			break;	
		// -------- Sub Nav Links --------
		// Browse	
		case "Browse by Category":
		case "Búsqueda por categoría":
			bgPage.clickSubNavButtons(bgPage.browseNode, bgPage.browseByCategoryNode);
			break;	
		case "Browse by State":
		case "Búsqueda por estado":
			bgPage.clickSubNavButtons(bgPage.browseNode, bgPage.browseByStateNode);
			break;	
		case "Browse by Agency":
		case "Búsqueda por agencia":
			bgPage.clickSubNavButtons(bgPage.browseNode, bgPage.browseByAgencyNode);
			break;		
		case "Other Resources":
		case "Otros recursos":
			bgPage.clickSubNavButtons(bgPage.browseNode, bgPage.otherResourcesNode);
			break;		
		// Newsroom	
		case "News & Updates":
		case "Noticias & Actualizaciones":
			bgPage.clickSubNavButtons(bgPage.newsroomNode, bgPage.newsAndUpdatesNode);
			break;	
		case "Compass eNewsletter":
		case "Compass el boletín electrónico (en inglés)":
			bgPage.clickSubNavButtons(bgPage.newsroomNode, bgPage.compassENewsletterNode);
			break;		
		// Get Involved
		case "Become an Advocate":
		case "Conviértase en un Representante":
			bgPage.clickSubNavButtons(bgPage.involvedNode, bgPage.becomeAnAdvocateNode);
			break;	
		case "Become an Affiliate":
		case "Conviértase en un Afiliado":
			bgPage.clickSubNavButtons(bgPage.involvedNode, bgPage.becomeAnAffiliateNode);
			break;	
		case "Link to Us":
		case "Enlace su sitio al nuestro":
			bgPage.clickSubNavButtons(bgPage.involvedNode, bgPage.linkToUsNode);
			break;	
		// Aboust Us
		case "Our Mission":
		case "Nuestra Misión":
			bgPage.clickSubNavButtons(bgPage.aboutUsNode, bgPage.ourMissionNode);
			break;	
		case "Our History":
		case "Nuestra Historia":
			bgPage.clickSubNavButtons(bgPage.aboutUsNode, bgPage.ourHistoryNode);
			break;	
		case "Our Partners":
		case "Nuestros Socios":
			bgPage.clickSubNavButtons(bgPage.aboutUsNode, bgPage.ourPartnersNode);
			break;	
		case "Become a Partner":
		case "Conviértase en un socio":
			bgPage.clickSubNavButtons(bgPage.aboutUsNode, bgPage.becomeAPartnerNode);
			break;	
		case "Our Platform":
		case "Nuestra Plataforma":
			bgPage.clickSubNavButtons(bgPage.aboutUsNode, bgPage.ourPlatformNode);
			break;	
		case "Recognition":
		case "Reconocimiento":
			bgPage.clickSubNavButtons(bgPage.aboutUsNode, bgPage.recognitionNode);
			break;
		// Help
		case "Frequently Asked Questions (FAQS)":
		case "Preguntas comunes":
			bgPage.clickSubNavButtons(bgPage.helpNode, bgPage.faqsNode);
			break;
		case "Contact Us":
		case "Contáctenos":
			bgPage.clickSubNavButtons(bgPage.helpNode, bgPage.contactUsNode);
			break;
		case "Privacy and Terms of Use":
		case "Privacidad y Términos de Uso":
			bgPage.clickSubNavButtons(bgPage.helpNode, bgPage.privacyAndTermsOfUseNode);
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
  			Assert.assertEquals("https://twitter.com/benefitsGOV", bgPage.processWindows());	
  			break;
  		case "Facebook":
  			Assert.assertTrue(bgPage.processWindows().contains("facebook.com/benefitsGOV"));
  			break;
  		case "Youtube":
  			Assert.assertEquals("https://www.youtube.com/user/BenefitsGOV", bgPage.processWindows());	
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
    
    // -------- Personalization Tests --------
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
    		Serenity.takeScreenshot();
    		String currentBenefitTitle = bgPage.pznBenefitTabs().get(i).getAttribute("title");
    		String benefitDetailTitle = bgPage.pullBenefitDetailTitle(currentBenefitTitle);
    		
    		Assert.assertEquals(currentBenefitTitle.trim(), benefitDetailTitle);
		}
	}
    
    // -------- FAQ Tests --------
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
    
    //verify homepage items
    @Step
   	public void verifyHomepageTitle(String language) {
       	
    	if(language.equals("EN")){
    		Assert.assertEquals(bgPage.pullHomepageBenefitTitle(), "Looking for Benefits?");
    	}
    	else if(language.equals("ES")){
    		Assert.assertEquals(bgPage.pullHomepageBenefitTitle(), "¿Busca Beneficios?");
    	}
   	}
    
    @Step
   	public void clickHomeButtonNode() {
    	bgPage.clickHomeButton();
   	}
    
    @Step
   	public void clickToggleLanguageButtonNode() {
    	bgPage.clickToggleLanguageButton();
   	}
    
    //browse by category tests

    @Step
    public void clickBrowseByCategoryNode() {
    	bgPage.clickCategoryTitle();
   	}
    
    @Step
   	public void verifyCategoryTitle() {
    	Assert.assertEquals(bgPage.pullCategoryTitle(), bgPage.pullPageTitle());
   	}
    
    @Step
    public void clickBrowseByBenefitNode() {
    	bgPage.clickBenefitTitle();
   	}
    
    @Step
   	public void verifyBenefitTitle() {
    	Assert.assertEquals(bgPage.pullBenefitTitle(), bgPage.pullPageTitle());
   	}
    
    //other Resources test
   
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

		case "Alaska":
		case "Nevada":
			Assert.assertEquals("State", bgPage.checkGroupHeadingNodes().get(0));
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

		case "Alaska":
		case "Nevada":
			Assert.assertEquals("Estado", bgPage.checkGroupHeadingNodes().get(0));
			break;
		}
	}
     
    @Step
   	public void clickToggleFilterButtonNode() {  	
    	bgPage.clickToggleFilterButton();
   	}
    
    @Step
   	public void verifyFilterIsPresent() {
    	Boolean filterPresent = bgPage.checkFilterShow();
    	Assert.assertTrue(filterPresent);
   	}
    
    @Step
   	public void verifyFilterIsHidden() {
    	Boolean filterHidden = bgPage.checkFilterHidden();
    	Assert.assertTrue(filterHidden);
   	}

    @Step
   	public void clickFilterByType(String filterType) {
    	bgPage.selectFilterByType(filterType);
   	}
    
    @Step
   	public void clickFilterByState(String filterType) {
    	bgPage.selectFilterByState(filterType);
   	}
    
    @Step
   	public void clickCategoriesCheckbox() {
    	bgPage.clickCategoriesCheckboxNodes();
   	}
    
    //news and updates tests, Compass tests
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
    	Assert.assertEquals(bgPage.pullNewsAndUpdatesArticleTitle(articleNum), bgPage.pullPageTitle());
   	}
	
    @Step 
   	public void verifyCompassArticleTitle(String articleNum) {	
    	Assert.assertEquals(bgPage.pullCompassArticleTitle(articleNum), bgPage.pullCurrentCompassTitle(articleNum));
   	}
    
    @Step 
	public void clickArticleReadMore(String articleNum) {   	
    	bgPage.clickArticleReadMoreNodes(articleNum);
   	}
    
	@Step
	public void clickCompassReadMore(String articleNum) {
		bgPage.clickCompassReadMoreNodes(articleNum);
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
    
    //Slider test
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
   				//Assert.assertEquals(bgPage.getWindowUrl(), "https://www.benefits.gov/newsroom/eNewsletter/october-2017");
   				Assert.assertTrue(bgPage.getWindowUrl().contains("benefits.gov/newsroom/eNewsletter"));
   			}
   			else if(language.equals("ES")){
   				//Assert.assertEquals(bgPage.getWindowUrl(), "https://www.benefits.gov/es/newsroom/eNewsletter/october-2017");
   				Assert.assertTrue(bgPage.getWindowUrl().contains("benefits.gov/es/newsroom/eNewsletter"));
   			}
   			break;
		case "2": 
	    	Assert.assertEquals(bgPage.pullSliderTitle(), bgPage.pullPageTitle());
			break;
   		case "3": 
   			Assert.assertEquals(bgPage.pullSliderTitle(), bgPage.pullPageTitle());
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
				Assert.assertEquals(bgPage.getWindowUrl(), "https://www.benefits.gov/about-us#recognition");
   			}
   			else if(language.equals("ES")){	
   				Assert.assertEquals(bgPage.getWindowUrl(), "https://www.benefits.gov/es/sobre-nosotros#reconocimiento");
   			}
   			break;
    	}
   	}
  
    @Step
	public void shouldSeePage(String expectedPageName) {

		String pageTitle = bgPage.pullPageTitle();
		
		switch(expectedPageName) {
		//case "browse":
			//Assert.assertEquals(pageTitle.toLowerCase(), "Welcome to Benefits.gov");
			//break;
		case "newsroom": 
			Assert.assertEquals(pageTitle.toLowerCase(), "news & updates");
			break;
		case "Sala de Prensa": 
			Assert.assertEquals(pageTitle.toLowerCase(), "noticias & actualizaciones");
			break;	
		case "help":
			Assert.assertEquals(pageTitle.toLowerCase(), "frequently asked questions (faqs)");
			break;
		case "Ayuda":
			Assert.assertEquals(pageTitle.toLowerCase(), "preguntas comunes");
			break;	
		
		case "Búsqueda por agencia":	
			Assert.assertEquals(pageTitle.toLowerCase(), "búsqueda por agencia federal");
			break;	
			
		case "Become an Advocate":
			Assert.assertEquals("become an advocate", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
		case "Conviértase en un Representante":	
			Assert.assertEquals("conviértase en un representante", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
			
		case "Become an Affiliate":
			Assert.assertEquals("become an affiliate", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
		case "Conviértase en un Afiliado":		
			Assert.assertEquals("conviértase en un afiliado", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
			
		case "Link to Us":
			Assert.assertEquals("link to us", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
		case "Enlace su sitio al nuestro":		
			Assert.assertEquals("enlace su sitio al nuestro", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
				
		case "Our Mission":
			Assert.assertEquals("our mission", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
		case "Nuestra Misión":		
			Assert.assertEquals("nuestra misión", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
			
		case "Our History":
			Assert.assertEquals("our history", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
		case "Nuestra Historia":		
			Assert.assertEquals("nuestra historia", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
			
		case "Our Partners":
			Assert.assertEquals("our partners", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
		case "Nuestros Socios":		
			Assert.assertEquals("nuestros socios", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
			
		case "Become a Partner":
			Assert.assertEquals("become a partner", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
		case "Conviértase en un socio":		
			Assert.assertEquals("conviértase en un socio", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;	
			
		case "Our Platform":
			Assert.assertEquals("our platform", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
		case "Nuestra Plataforma":	
			Assert.assertEquals("nuestra plataforma", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
			
		case "Recognition":
			Assert.assertEquals("recognition", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
		case "Reconocimiento":	
			Assert.assertEquals("reconocimiento", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
			
		case "get involved":
		case "Involúcrese":
			
		case "about us":
		case "Sobre Nosotros":	
		
		case "Browse by Category":
		case "Búsqueda por categoría":	
				
		case "Browse by State":
		case "Búsqueda por estado":
			
		case "Browse by Agency":	
			
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
			
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
			
		case "Compass eNewsletter":	
			Assert.assertTrue(bgPage.processWindows().contains("benefits.gov/newsroom/eNewsletter"));
  			break;
			
		default:
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			System.err.println("INVALID PAGE SENT");
			break;
		} 
	}
     

}