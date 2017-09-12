package gov.bg.pages;


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

@DefaultUrl("https://www.benefits.gov")
public class BGPage extends PageObject {
    
	private String env = System.getProperty("environment");
	
	public BGPage(WebDriver driver) {
		super(driver);
		driver.manage().window().maximize();
		this.setImplicitTimeout(10, TimeUnit.SECONDS);
	}
	
	public void clearCookies() {
		this.getDriver().manage().deleteAllCookies();
	}
	
	public String setEnvironment() {
		if(env.isEmpty()){
			env ="www";
		}
		String defaultUrl = "https://" + env + ".benefits.gov";
		return defaultUrl;
	}
	
	public String getCurrUrl() {
		String currentUrl = getDriver().getCurrentUrl();
		return currentUrl;
	}


	//********************************************************************************				
	
	private static final String SUBHEADER_XPATH = "//div[@class='field-items']/div[text()='%s']";
		 
	private static final String BENEFIT_DETAIL_XPATH = "//div[@class='benefit-node']/div[text()='%s']";
	 
	public String pullBenefitDetailTitle(String benefitTabName) {
    	String benefitTitle_xpath = String.format(BENEFIT_DETAIL_XPATH, benefitTabName);
    	WebElement benefitTitle = getDriver().findElement(By.xpath(benefitTitle_xpath));
    	return benefitTitle.getText();
    }
	
	// ***********************************************************************************
	//Personalization tests
	@FindBy(xpath = "//*[@id='bg-personalization-change-location-form']/label/h2/span[2]/a")
	private WebElementFacade changeLocationButton;

	@FindBy(xpath = "//*[@id='edit-input']")
	public WebElementFacade enterStateOrTerritoryTextbox;

	@FindBy(xpath = "//*[@id='bg-personalization-change-location-form']/div[1]/span/div/div/div[1]/strong")
	private WebElementFacade stateDropdownSelect;

	@FindBy(xpath = "//*[@class='title pzn-title']/span")
	public WebElementFacade pznBenefitTabTitle;

	@FindBy(xpath = "//*[@class='field field-name-title']")
	public WebElementFacade pznBenefitDecriptionTitle;

	public List<WebElement> pznBenefitTabs() {
		return this.getDriver().findElements(By.xpath("//*[@class='title pzn-title']"));
	}

	public void clickChangeLocationButton() {
		((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0,0);");
		changeLocationButton.click();
	}

	public void clickenterStateOrTerritoryTextbox(String node) {
		enterStateOrTerritoryTextbox.sendKeys(node);
	}

	public void clickStateDropdownButton() {
		stateDropdownSelect.click();
	}
	
	public String pullStateName() {
		System.out.println("Waiting for state title to load");
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='state']")));

		WebElement stateName = getDriver().findElement(By.xpath("//*[@class='state']"));
		return stateName.getText();
	}
	
	// ***********************************************************************************
	//FAQ tests
	public List<WebElement> FAQButtonsExpand() {
		return this.getDriver().findElements(By.xpath(
				"//*[@class='content']/div[@class='field field-name-field-accordion-title field-type-text field-label-hidden']"));
	}

	public List<WebElement> FAQButtonsMinimize() {
		return this.getDriver().findElements(By.xpath(
				"//*[@class='content']/div[@class='field field-name-field-accordion-title field-type-text field-label-hidden active']"));
	}
	 
	public void clickExpandFAQButtons() {
		List<WebElement> footer = FAQButtonsExpand();
		for (int i = 0; i < 14; i++) {
			footer.get(i).click();
			pause(500);
		}
	}
		
	public void clickMinimizeFAQButtons() {
		((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0,0);");
		List<WebElement> footer = FAQButtonsMinimize();
		for (int i = 0; i < 14; i++) {
			footer.get(i).click();
			pause(500);
		}
	}

	public List<WebElement> FAQAnswers() {
		return this.getDriver().findElements(By.xpath(
				"//*[@class='content']/div[@class='field field-name-field-accordion-body field-type-text-with-summary field-label-hidden'][contains(@style,'display: block')]"));
	}

	public boolean checkFAQAnswersShow() {
		List<WebElement> footer = FAQAnswers();
//		for (int i = 0; i < footer.size(); i++) {
//			System.out.println("answer text is: " + footer.get(i).getText());
//		}
		return footer.size() == 14;
	}

	public boolean checkFAQAnswersHidden() {
		List<WebElement> footer = FAQButtonsExpand();
//		for (int i = 0; i < footer.size(); i++) {
//			System.out.println("text is: " + footer.get(i).getText());
//		}
		return footer.size() == 14;
	}
	
	// ***********************************************************************************	
	//homepage test nodes	
	@FindBy(xpath = "//div[@id='benefit-title']")
	private WebElementFacade homepageBenefitTitleNode;	
		
	public String pullHomepageBenefitTitle(){
		return homepageBenefitTitleNode.getText();
	}
	
	@FindBy(xpath = "//*[@id='logo']")
	private WebElementFacade homeButtonNode;	
	
	public void clickHomeButton() {
		pause(500);
		homeButtonNode.click();
	}
	
	@FindBy(xpath = "//*[@id='block-locale-language-content']/ul/li/a")
	private WebElementFacade toggleLanguageNode;
	
	public void clickToggleLanguageButton() {
		pause(500);
		toggleLanguageNode.click();
	}
	
	// ***********************************************************************************
	//browse by category tests
	public List<WebElement> browseByCategoryNodes() {  
		return this.getDriver().findElements(By.xpath("//*[@class='browse-by-category']/a"));
	}
	
	public List<WebElement> browseByBenefitNodes() {  
		return this.getDriver().findElements(By.xpath("//*[@class='browse-by-header']/a"));
	}
	
	private static final String CATEGORY_TITLE_XPATH = "(//*[@class='browse-by-category']/a)[%s]";

	private static final String BENEFIT_TITLE_XPATH = "(//*[@class='browse-by-header']/a)[%s]";	
	
	private String categoryTitle;
	
	private String benefitTitle;
	
	public void clickCategoryTitle() {
		List<WebElement> categories = browseByCategoryNodes();
		int random = (int) (Math.random() * categories.size() + 1);

		String categoryXpath = String.format(CATEGORY_TITLE_XPATH, random);
		WebElementFacade categoryNode = find(By.xpath(categoryXpath));

		categoryTitle = categoryNode.getText();

		categoryNode.click();
	}
	
	public void clickBenefitTitle() {
		List<WebElement> benefits = browseByBenefitNodes();
		int random = (int) (Math.random() * benefits.size() + 1);

		String benefitXpath = String.format(BENEFIT_TITLE_XPATH, random);
		WebElementFacade benefitNode = find(By.xpath(benefitXpath));

		benefitTitle = benefitNode.getText();

		benefitNode.click();
	}
	
	
	public String pullCategoryTitle(){
		return categoryTitle;
	}
	
	public String pullBenefitTitle(){
		return benefitTitle;
	}
	
	
	// ***********************************************************************************
	//other resources tests
	public List<WebElement> groupHeadingNodes() {
		return this.getDriver().findElements(By.xpath("//*[@class='view-grouping-header']"));
	}

	public List<String> checkGroupHeadingNodes(){
		pause(500);
		List<String> headingList = new ArrayList<String>();
		List<WebElement> footer = groupHeadingNodes();
		
		for(int i = 0; i < footer.size(); i++){	
			//System.out.println("text is: " + footer.get(i).getText());
			headingList.add(footer.get(i).getText());
		}
		return headingList;
	}
	
	public List<WebElement> resourceNodes() {
		return this.getDriver().findElements(By.xpath("//*[contains(@class,'views-row')]"));
	}
	
	public int checkResourceNodes() {
		pause(500);
		List<WebElement> footer = resourceNodes();
		
		System.out.println("Number of resources is: " + footer.size());
		return footer.size();		
	}
	
	public List<WebElement> otherResourceCategoryNodes() {
		return this.getDriver().findElements(By.xpath("//*[contains(@class,'form-item form-type-bef-checkbox')]/label"));
	}
	
	
	@FindBy(xpath = "//*[@id='content']/div/div[1]/h2")
    private WebElementFacade toggleFilterNode;
	
	public void clickToggleFilterButton() {
		pause(500);
		toggleFilterNode.click();
	}
	
	
	@FindBy(xpath = "//*[contains(@class,'ctools-auto-submit-full')][contains(@style,'display: block')]")
    private WebElementFacade showFilterNode;
	
	@FindBy(xpath = "//*[contains(@class,'ctools-auto-submit-full')][contains(@style,'display: none')]")
    private WebElementFacade hiddenFilterNode;
	
	public boolean checkFilterShow() {
		pause(500);
		Boolean isPresent = getDriver().findElements(By.xpath("//*[contains(@class,'ctools-auto-submit-full')][contains(@style,'display: block')]")).size() == 1;
		
		return isPresent;
	}
	
	public boolean checkFilterHidden() {
		pause(500);
		Boolean isHidden = getDriver().findElements(By.xpath("//*[contains(@class,'ctools-auto-submit-full')][contains(@style,'display: none')]")).size() == 1;
		
		return isHidden;
	}
	
	@FindBy(xpath = "//*[@id='edit-field-resource-type-value-i18n']")
    private WebElementFacade filterByTypeDropdown;
	
	
	public void selectFilterByType(String filterType) {
		filterByTypeDropdown.sendKeys(filterType);
		pause(1000);
	}


	@FindBy(xpath = "//*[@id='edit-field-agency-state-value-i18n']")
    private WebElementFacade filterByStateDropdown;
	
	public void selectFilterByState(String filterType) {
		filterByStateDropdown.sendKeys(filterType);
		pause(1000);
	}
	
 
	public void clickCategoriesCheckboxNodes() {
		
		int categoryCount= this.getDriver().findElements(By.xpath("//*[contains(@class,'form-item form-type-bef-checkbox')]/label")).size();
		for(int i = 0; i < categoryCount; i++){	
			List<WebElement> categoriesFilter = otherResourceCategoryNodes();
			//pause(1000);
			System.out.println("Category is: " + categoriesFilter.get(i).getText());
			categoriesFilter.get(i).click();
		}
	}
	
	// ***********************************************************************************
	//Compass tests
	private List<String> currentArticleTitles = new ArrayList<String>();
	
	private List<String> currentCompassArticleTitles = new ArrayList<String>();
	
	public List<String> compassTabTitles = new ArrayList<String>();
	
	public List<WebElement> compassTabTitles() {
		return this.getDriver().findElements(By.xpath("//*[@class='sp-thumbnail-title']/div/div/div"));
	}
	
	
	private static final String COMPASS_TAB_TITLE_XPATH = "(//*[@class='sp-thumbnail-title']/div/div/div)[%s]";
    
	public void clickCompassTabs(String articleNum) {
		 String articleXpath = String.format(COMPASS_TAB_TITLE_XPATH, articleNum);
		 WebElementFacade articleNode = find(By.xpath(articleXpath));
		 compassTabTitles.add(articleNode.getText());
		 
		 articleNode.click();
		 pause(1000);
	}
	
	public List<WebElement> newsArticleNodes() {
		return this.getDriver().findElements(By.xpath("//*[@class='field field-name-field-bg-article-title field-type-text field-label-hidden']/div/div/a"));
	}
			
	public int checkNewsArticles() {
		List<WebElement> articles = newsArticleNodes();
		for(int i = 0; i < articles.size(); i++){
			System.out.println("Article text: " + articles.get(i).getText());
			currentArticleTitles.add(articles.get(i).getText());
		}
		return articles.size();
	}	
	
	public List<WebElement> compassArticleNodes() {
		return this.getDriver().findElements(By.xpath("//*[@class='field field-name-field-compass-article-title field-type-link-field field-label-hidden']/div/div/a"));
	}
			
	public int checkCompassArticles() {
		List<WebElement> articles = compassArticleNodes();

		return articles.size();
	}	
	
    private static final String ARTICLE_NUM_XPATH = "(//*[@class='field field-name-field-bg-article-title field-type-text field-label-hidden']/div/div/a)[%s]";
	
    private static final String COMPASS_ARTICLE_NUM_XPATH = "(//*[@class='field field-name-field-compass-article-title field-type-link-field field-label-hidden']/div/div/a)[%s]";
    
    private static final String COMPASS_ARTICLE_TITLE_XPATH = "(//*[@class='ds-header']/div[@class='field field-name-field-compass-article-title field-type-link-field field-label-hidden']/div/div)[%s]";
    
	public void clickNewsArticleNodes(String articleNum) {
		 String articleXpath = String.format(ARTICLE_NUM_XPATH, articleNum);
		 WebElementFacade articleNode = find(By.xpath(articleXpath));
		 
		 articleNode.click();
		 pause(1000);
	}
	
	public void clickCompassArticleNodes(String articleNum) {
		 String compassXpath = String.format(COMPASS_ARTICLE_NUM_XPATH, articleNum);
		 System.out.println("compass xpath is: " + compassXpath);	 
		 WebElementFacade articleNode = find(By.xpath(compassXpath));
		 
		 currentCompassArticleTitles.add(articleNode.getText());
		 
		 articleNode.click();
		 pause(1000);
	}
	
	
	public String pullNewsAndUpdatesArticleTitle(String articleNum){
		int index = Integer.parseInt(articleNum) - 1;
		System.out.println("article xpath is : " + currentArticleTitles.get(index));
		//return currentArticleTitles.get(index);
		return currentArticleTitles.get(index);
	}
	
	public String pullCompassArticleTitle(String articleNum) {
		int index = Integer.parseInt(articleNum) - 1;
		//System.out.println("article xpath is : " + currentCompassArticleTitles.get(index));
		return currentCompassArticleTitles.get(index).toLowerCase();
	}
	
	
	public String pullCurrentCompassTitle(String articleNum) {
		String compassTitleXpath = String.format(COMPASS_ARTICLE_TITLE_XPATH, articleNum);
		//System.out.println("compass title xpath is: " + compassTitleXpath);
		WebElementFacade articleTitleNode = find(By.xpath(compassTitleXpath));

		return articleTitleNode.getText().toLowerCase();
	}
	
	private static final String READ_MORE_NUM_XPATH = "(//*[@class='more-link'])[%s]";
	
	private static final String READ_MORE_COMPASS_NUM_XPATH = "(//*[@class='readmore fa fa-angle-double-right-alt fa-lg']/a)[%s]";

	public void clickArticleReadMoreNodes(String articleNum) {

		String articleXpath = String.format(READ_MORE_NUM_XPATH, articleNum);
		System.out.println("read more xpath is : " + articleXpath);
		WebElementFacade readMoreNode = find(By.xpath(articleXpath));

		readMoreNode.click();
		pause(1000);
	}
	
	public void clickCompassReadMoreNodes(String articleNum) {

		String articleXpath = String.format(READ_MORE_COMPASS_NUM_XPATH, articleNum);
		System.out.println("read more xpath is : " + articleXpath);
		WebElementFacade readMoreNode = find(By.xpath(articleXpath));

		String compassXpath = String.format(COMPASS_ARTICLE_NUM_XPATH, articleNum);
		System.out.println("compass xpath is: " + compassXpath);
		WebElementFacade articleNode = find(By.xpath(compassXpath));

		currentCompassArticleTitles.add(articleNode.getText());

		readMoreNode.click();
		pause(1000);
	}
	
	public String getWindowUrl(){
		String windowUrl = getDriver().getCurrentUrl();
	    System.out.println("current window url is: " + windowUrl);
	    return windowUrl;
	}
	// ***********************************************************************************
	
	//Slider tests
	
	private static final String SLIDER_TILE_XPATH = "(//*[contains(@class,'field-name-field-custom-slider-title') or contains(@class,'field-name-field-bg-article-title')])[%s]";
    
    @FindBy(xpath = "//*[@id='block-views-slider-block']/div/div/div/div/div/div/div[2]/div[2]/div[2]")
    private WebElementFacade sliderNextButton;
	
	private String sliderTitle;
    
	
	public void clickSliderTileNode(String sliderNum) {
		 String sliderTileXpath = String.format(SLIDER_TILE_XPATH, sliderNum);
		 WebElementFacade sliderTileNode = find(By.xpath(sliderTileXpath));
		 
		 while(!sliderTileNode.isDisplayed()){
			 pause(500);
			 sliderNextButton.click();
			 System.out.println("hit");
		 }
		 
		 sliderTitle = sliderTileNode.getText();
		 
		 sliderTileNode.click();
	}
	
	
	
	public String pullSliderTitle(){
		return sliderTitle;
	}
	
	
	

	// ***********************************************************************************
	@FindBy(xpath = "//*[@class='pager-next']/a")
    private WebElementFacade newsUpdateNavNextNode;
	
	@FindBy(xpath = "//*[@class='pager-previous']/a")
    private WebElementFacade newsUpdateNavPrevNode;
	
	@FindBy(xpath = "//*[@class='pager-first first']/a")
    private WebElementFacade newsUpdateNavFirstNode;
	
	@FindBy(xpath = "//*[@class='pager-last last']/a")
    private WebElementFacade newsUpdateNavLastNode;

	public void clickNewsNavNextNode() {
		newsUpdateNavNextNode.click();
	}
	public void clickNewsNavPrevNode() {
		newsUpdateNavPrevNode.click();
	}
	public void clickNewsNavFirstNode() {
		newsUpdateNavFirstNode.click();
	}
	public void clickNewsNavLastNode() {
		newsUpdateNavLastNode.click();
	}
	// ***********************************************************************************
	
	public List<WebElement> articleTypeNodes() {
		return this.getDriver().findElements(By.xpath("//*[@class='field field-name-field-bg-article-type field-type-list-text field-label-hidden']/div/div"));
	}
			
	public boolean checkArticleType(String articleType) {
		List<WebElement> articlesType = articleTypeNodes();
		for(int i = 0; i < articlesType.size(); i++){
			String currentArticleType = articlesType.get(i).getText();
			
			System.out.println("curr article type is: " + currentArticleType);
			System.out.println("article type is: " + articleType);
			
			
			//System.out.println("Article type: " + articlesType.get(i).getText());
			
			if(!currentArticleType.contains(articleType)){
				return false;
			}	
		}
		return true;
	}	
	
	
	@FindBy(xpath = "//*[@id='edit-field-bg-article-type-value-i18n']")
    private WebElementFacade filterByNewsDropdown;
	
	@FindBy(xpath = "	//*[@id='edit-submit-articles']")
    private WebElementFacade applyButtonNewsAndUpdates;
	
	public void selectFilterByNewsType(String filterType) {
		
		System.out.println("what we are selecting by: " + filterType);
		filterByNewsDropdown.sendKeys(filterType);
		applyButtonNewsAndUpdates.click();
		pause(1000);
	}
	

	@FindBy(xpath = "//*[@id='edit-field-article-categories-english-target-id']")
    private WebElementFacade filterByBenefitCategoryDropdown;
	
	public void selectFilterByBenefitCategory(String filterType) {
		filterByBenefitCategoryDropdown.sendKeys(filterType);
		applyButtonNewsAndUpdates.click();
		pause(1000);
	}
    
    // ***********************************************************************************
    //Browse for Benefits links
    @FindBy(xpath = "//*[@id='category-icon']/a/p")
    private WebElementFacade categoryNode;
    
    @FindBy(xpath = "//*[@id='state-icon']/a/p")
    private WebElementFacade stateNode;
    
    @FindBy(xpath = "//*[@id='agency-icon']/a/p")
    private WebElementFacade agencyNode;
    
	@FindBy(xpath = "//*[@id='startFinder']/a")
	private WebElementFacade startBenefitFinderNode;
	
    //click browse by links
    public void clickCategoryNode() {
    	categoryNode.click();
    }
    public void clickStateNode() {
    	stateNode.click();
    }
    public void clickAgencyNode() {
    	agencyNode.click();
    }
    public void clickStartBenefitFinder() {
    	startBenefitFinderNode.click();
    	pause(5000);
    }
  // ***********************************************************************************
    
    //Browse by links
    @FindBy(xpath = "//*[@id='nav']/ul/li[1]/ul/li[1]/a")
	public WebElementFacade browseByCategoryNode;

    @FindBy(xpath = "//*[@id='nav']/ul/li[1]/ul/li[2]/a")
	public WebElementFacade browseByStateNode;
    				
    @FindBy(xpath = "//*[@id='nav']/ul/li[1]/ul/li[3]/a")
	public WebElementFacade browseByAgencyNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[1]/ul/li[4]/a")
	public WebElementFacade otherResourcesNode;
    
    // ***********************************************************************************
	// main nav links
	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/a")
	public WebElementFacade newsroomNode;

	@FindBy(xpath = "//*[@class='field-item even']")
	private WebElementFacade subpageTitle;

	@FindBy(xpath = "//*[@id='nav']/ul/li[3]/a")
	public WebElementFacade involvedNode;

	@FindBy(xpath = "//*[@id='nav']/ul/li[4]/a")
	public WebElementFacade aboutUsNode;

	@FindBy(xpath = "//*[@id='nav']/ul/li[5]/a")
	public WebElementFacade helpNode;

	@FindBy(xpath = "//*[@id='nav']/ul/li[1]/a")
	public WebElementFacade browseNode;
	
    public void clickNews() { 	
    	newsroomNode.click();
    }
    public void clickInvolved() {
    	involvedNode.click();
    }
    public void clickAboutUs() {
    	aboutUsNode.click();
    }
    public void clickHelp() {
    	helpNode.click();
    }
    public void clickBrowse() {
    	browseNode.click();
    }
    // ***********************************************************************************

	// Newsroom links
    @FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[1]/a")
	public WebElementFacade newsAndUpdatesNode;

    @FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[2]/a")
	public WebElementFacade compassENewsletterNode;
  
    //get involved Nodes
    @FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[1]/a")
	public WebElementFacade becomeAnAdvocateNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[2]/a")
    public WebElementFacade becomeAnAffiliateNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[3]/a")
    public WebElementFacade linkToUsNode;
    
    //About Us Nodes
    @FindBy(xpath = "//*[@id='nav']/ul/li[4]/ul/li[1]/a")
	public WebElementFacade ourMissionNode;

    @FindBy(xpath = "//*[@id='nav']/ul/li[4]/ul/li[2]/a")
    public WebElementFacade ourHistoryNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[4]/ul/li[3]/a")
    public WebElementFacade ourPartnersNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[4]/ul/li[4]/a")
    public WebElementFacade becomeAPartnerNode;
    				 
    @FindBy(xpath = "//*[@id='nav']/ul/li[4]/ul/li[5]/a")
    public WebElementFacade ourPlatformNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[4]/ul/li[6]/a")
    public WebElementFacade recognitionNode;
    
    //Help Nav Nodes
    @FindBy(xpath = "//*[@id='nav']/ul/li[5]/ul/li[1]/a")
	public WebElementFacade faqsNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[5]/ul/li[2]/a")
    public WebElementFacade contactUsNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[5]/ul/li[3]/a")
    public WebElementFacade privacyAndTermsOfUseNode;
    
    public void clickSubNavButtons(WebElementFacade nav, WebElementFacade subNav) {
        Actions action = new Actions(getDriver());
        action.moveToElement(nav).pause(1000).moveToElement(subNav).click().build().perform();
    }
    // ***********************************************************************************
    
    public String pullPageTitle() {
    	
    	System.out.println("Waiting for page title to load");
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='page-title']")));
        
        String windowUrl = getDriver().getCurrentUrl();
        System.out.println("current window url is: " + windowUrl);

    	WebElement pageTitle = getDriver().findElement(By.xpath("//*[@id='page-title']"));
    	//pause(2000);
		return pageTitle.getText();
	}
        
    public String pullSubpageTitle(String subpageName) {
    	
    	String subpage_xpath = String.format(SUBHEADER_XPATH, subpageName);
    	
    	System.out.println("Waiting for subpage title to load");
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(subpage_xpath)));
    	
    	WebElement subpageTitle = getDriver().findElement(By.xpath(subpage_xpath));
    	return subpageTitle.getText();
    }
    

    
  // ***********************************************************************************
  //footer links
    @FindBy(xpath = "//*[@id='twitter-icon']")
    private WebElementFacade twitterLink;
    
    @FindBy(xpath = "//*[@id='fb-icon']")
    private WebElementFacade facebookLink;
    
    @FindBy(xpath = "//*[@id='youtube-icon']")
    private WebElementFacade youtubeLink;
    
    @FindBy(xpath = "//*[@id='footer-sites']/li[1]/a")
    private WebElementFacade whiteHouseLink;
    
    @FindBy(xpath = "//*[@id='footer-sites']/li[2]/a")
    private WebElementFacade USAGovLink;

    @FindBy(xpath = "(//*[@id='footer-sites']/li[1]/a)[last()]")
    private WebElementFacade SSABestLink;
    
    @FindBy(xpath = "(//*[@id='footer-sites']/li[2]/a)[last()]")
    private WebElementFacade govLoansLink;
    
    @FindBy(xpath = "//*[@id='footer-sites']/li[3]/a")
    private WebElementFacade disasterAssistanceLink;

	public void clickTwitter() {
		twitterLink.click();
	}
	public void clickFacebook() {
		facebookLink.click();
	}
	public void clickYoutube() {
		youtubeLink.click();
	}
	public void clickWhiteHouse() {
		whiteHouseLink.click();
	}
	public void clickUSAGov() {
		USAGovLink.click();
	}
	public void clickSSABest() {
		SSABestLink.click();
	}
	public void clickGovLoans() {
		govLoansLink.click();
	}
	public void clickDisasterAssistance() {
		disasterAssistanceLink.click();
	}
    // ***********************************************************************************

	public String processWindows() {
		// Store the current window handle
		String winHandleBefore = getDriver().getWindowHandle();

		// Perform the click operation that opens new window
		//System.out.println("url passed in is " + url);

		// Switch to new window opened
		List<String> browserTabs = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(browserTabs.get(1));
		pause(1000);

		// Perform the actions on new window
		Serenity.takeScreenshot();
		String windowUrl = getDriver().getCurrentUrl();

		// Close the new window, if that window no more required
		getDriver().close();

		// Switch back to original browser (first window)
		getDriver().switchTo().window(winHandleBefore);

		// Continue with original browser (first window)
		return windowUrl;
	}

	public void pause(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}