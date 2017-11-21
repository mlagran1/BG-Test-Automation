package gov.bg;

import gov.bg.pages.BGPage;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

public class User {

    BGPage bgPage;

    @Step
    public void onHomePage() {
    	
    	bgPage.clearCookies();
		String url = bgPage.setEnvironment();		
		bgPage.openAt(url);		
		System.out.println("Directory path is: " + bgPage.setEnvironment());
    }

    @Step
	public void open_page(String directoryPath) {
    	
    	bgPage.clearCookies();
		String url = bgPage.setEnvironment() + directoryPath;
		bgPage.openAt(url);
		System.out.println("Directory path is: " + url);	
	}
    

    @Step
    public void clickNavNode(String node) {
    	

    	switch(node) {
    	//nav links 
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
		//sub nav links	
		//browse	
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
		//newsroom	
		case "News & Updates":
		case "Noticias & Actualizaciones":
			bgPage.clickSubNavButtons(bgPage.newsroomNode, bgPage.newsAndUpdatesNode);
			break;	
		case "Compass eNewsletter":
		case "Compass el boletín electrónico (en inglés)":
			bgPage.clickSubNavButtons(bgPage.newsroomNode, bgPage.compassENewsletterNode);
			break;		
		//get invovled	
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
		//about us	
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
		//Help
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
  		String selectedUrl = "";
  		
  		switch(expectedPageURL) {
  		case "Twitter": 
  			selectedUrl = "https://twitter.com/benefitsGOV";
  			break;
  		case "Facebook":
  			selectedUrl = "https://m.facebook.com/benefitsGOV"; // "m" when using phantomjs, "www" when using chrome
  			break;
  		case "Youtube":
  			selectedUrl = "https://www.youtube.com/user/BenefitsGOV";
  			break;
  			
  		case "White House":
  			selectedUrl = "https://www.whitehouse.gov/";
  			break;
  		case "USA.gov":
  			selectedUrl = "https://www.usa.gov/";
  			break;
  		case "SSABest":
  			selectedUrl = "https://ssabest.benefits.gov/";
  			break;
  		case "SSABest ES":	
  			selectedUrl = "https://ssabest.benefits.gov/es";
  			break;
  		case "GovLoans":
  			selectedUrl = "https://www.govloans.gov/";
  			break;	
  		case "GovLoans ES":
  			selectedUrl = "https://es.govloans.gov/";
  			break;	
  		case "Disaster Assistance":
  			selectedUrl = "https://www.disasterassistance.gov/";
  			break;	
  		case "Disaster Assistance ES":
  			selectedUrl = "https://www.disasterassistance.gov/es";
  			break;
	
  		default:
			System.err.println("INVALID PAGE SENT");
			break;	
  		}
  		Assert.assertEquals(selectedUrl, bgPage.processWindows());	
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
    
 
    //Pzn Test methods
    @Step
    public void clickPznButtons(String node) {
    		bgPage.clickenterStateOrTerritoryTextbox(node);
    		bgPage.clickStateDropdownButton();
    }
    
    @Step
	public void verifyStateName(String expectedStateName) {
    	
    	String currentStateName = bgPage.pullStateName();
    	System.out.println("current state name is: " + currentStateName);
    	
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
    		
    		System.out.println("benefit title of the tab clicked on is: " + currentBenefitTitle);
    		System.out.println("benefit detail title is: " + benefitDetailTitle);
    		
    		Assert.assertEquals(currentBenefitTitle.trim(), benefitDetailTitle);
		}
	}
    
    
    //FAQ tests
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
    	System.out.println("pullCategoryTitle : " + bgPage.pullCategoryTitle());
    	System.out.println("pullPageTitle : " + bgPage.pullPageTitle());
    	Assert.assertEquals(bgPage.pullCategoryTitle(), bgPage.pullPageTitle());
   	}
    
    @Step
    public void clickBrowseByBenefitNode() {
    	bgPage.clickBenefitTitle();
   	}
    
    
    @Step
   	public void verifyBenefitTitle() {
    	System.out.println("pullBenefitTitle : " + bgPage.pullBenefitTitle());
    	System.out.println("pullPageTitle : " + bgPage.pullPageTitle());
    	Assert.assertEquals(bgPage.pullBenefitTitle(), bgPage.pullPageTitle());
   	}
    
    
    
    //other Resources test
   
    
	@Step
	public void verifyGroupHeadingsEN(String filterType) {

		switch (filterType) {
		case "-ANY-":
			List<String> expectedHeadingsEN = new ArrayList<>(Arrays.asList("Federal", "State", "Other"));
			System.out.println("expectedHeadings are: " + expectedHeadingsEN);
			System.out.println("groupHeadingNodes are: " + bgPage.checkGroupHeadingNodes());
			for (int i = 0; i < expectedHeadingsEN.size(); i++) {
				Assert.assertEquals(expectedHeadingsEN.get(i), bgPage.checkGroupHeadingNodes().get(i));
			}
			break;

		case "Federal":
		case "State":
		case "Other":
			Assert.assertEquals(filterType, bgPage.checkGroupHeadingNodes().get(0));
			System.out.println("filter heading is: " + bgPage.checkGroupHeadingNodes().get(0));
			break;

		case "Alaska":
		case "Nevada":
			Assert.assertEquals("State", bgPage.checkGroupHeadingNodes().get(0));
			System.out.println("filter heading is: " + bgPage.checkGroupHeadingNodes().get(0));
			break;
		}
	}
    	
    	
    	
	@Step
	public void verifyGroupHeadingsES(String filterType) {

		switch (filterType) {
		case "-TODAS-":
			List<String> expectedHeadingsES = new ArrayList<>(Arrays.asList("Federal", "Estado", "Otro"));
			System.out.println("expectedHeadings are: " + expectedHeadingsES);
			System.out.println("groupHeadingNodes are: " + bgPage.checkGroupHeadingNodes());
			for (int i = 0; i < expectedHeadingsES.size(); i++) {
				Assert.assertEquals(expectedHeadingsES.get(i), bgPage.checkGroupHeadingNodes().get(i));
			}
			break;

		case "Federal":
		case "Estado":
		case "Otro":
			Assert.assertEquals(filterType, bgPage.checkGroupHeadingNodes().get(0));
			System.out.println("filter heading is: " + bgPage.checkGroupHeadingNodes().get(0));
			break;

		case "Alaska":
		case "Nevada":
			Assert.assertEquals("Estado", bgPage.checkGroupHeadingNodes().get(0));
			System.out.println("filter heading is: " + bgPage.checkGroupHeadingNodes().get(0));
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
    
    //news and updates tests
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
    	System.out.println("link title : " + bgPage.pullNewsAndUpdatesArticleTitle(articleNum));
    	System.out.println("article title is : " + bgPage.pullPageTitle());
    	Assert.assertEquals(bgPage.pullNewsAndUpdatesArticleTitle(articleNum), bgPage.pullPageTitle());
   	}
	
    
    @Step 
   	public void verifyCompassArticleTitle(String articleNum) {	
    	System.out.println("link title : " + bgPage.pullCompassArticleTitle(articleNum));
    	System.out.println("compass article title is : " + bgPage.pullCurrentCompassTitle(articleNum));
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
    	Assert.assertEquals(7, bgPage.checkCompassArticles());
    }
    
    @Step 
	public void clickCompassArticle(String articleNum) { 	
    	bgPage.clickCompassArticleNodes(articleNum);
   	}
    
    @Step 
	public void clickCompassTabs(String articleNum) {   	
    	bgPage.clickCompassTabs(articleNum);
   	}
    
    @Step 
	public void verifyCompassTabs(String articleNum) {  
    	
    	int index = Integer.parseInt(articleNum) - 2;
    	
    	String tabTitle = bgPage.compassTabTitles.get(index);
    	int trimLength = tabTitle.length();
    	
    	if(tabTitle.contains("...")){
    		trimLength -= 3;
    	}
    	
    	articleNum = String.valueOf(Integer.parseInt(articleNum) - 1 );
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
    	
    	System.out.println("bool value is " + bgPage.checkArticleType(articleType));
    	
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
		case "2": 
	    	System.out.println("pullSliderTitle : " + bgPage.pullSliderTitle());
	    	System.out.println("pullPageTitle : " + bgPage.pullPageTitle());
	    	Assert.assertEquals(bgPage.pullSliderTitle(), bgPage.pullPageTitle());
			break;
   		case "3": 
   			if(language.equals("EN")){
   				Assert.assertEquals(bgPage.getWindowUrl(), "https://www.benefits.gov/newsroom/eNewsletter/october-2017");
   			}
   			else if(language.equals("ES")){
   				Assert.assertEquals(bgPage.getWindowUrl(), "https://www.benefits.gov/es/newsroom/eNewsletter/october-2017");
   			}
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
		//String subpageTitle = bgPage.pullSubpageTitle(expectedPageName);
		
		System.out.println("page title is: " + pageTitle.toLowerCase());
		System.out.println("expected PageName is: " + expectedPageName.toLowerCase());
		
		
		switch(expectedPageName) {
		//case "welcome to benefits.gov":
		//case "browse":
			//Assert.assertEquals(pageTitle.toLowerCase(), "Welcome to Benefits.gov sasdfasdf");
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
		
		//case "Compass eNewsletter":	
			//Assert.assertEquals("April 2017 Compass eNewsletter", pageTitle.toLowerCase());
			//break;	
			
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
			
		default:
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			System.err.println("INVALID PAGE SENT");
			break;
		} 
	}

}