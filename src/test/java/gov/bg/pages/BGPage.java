package gov.bg.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
import gov.bg.User;


/**
 * Class is for all of the Benefits.gov WebElements and methods to interact with them
 */

@DefaultUrl("https://www.benefits.gov")
public class BGPage extends PageObject {
    
	private String env = System.getProperty("environment");
	
	public String getEnvironment() {
		return env;
	}
	
	public BGPage(WebDriver driver) {
		super(driver);
		//driver.manage().window().maximize();
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
	
    // ***********************************************************************************
	// main nav
	@FindBy(xpath = "//*[@id='nav']/ul/li[1]/a")
	private WebElementFacade browseNode;
	
	@FindBy(xpath = "//*[@id='nav']/ul/li[2]/a")
	private WebElementFacade newsroomNode;

	@FindBy(xpath = "//*[@id='nav']/ul/li[3]/a")
	private WebElementFacade getInvolvedNode;

	@FindBy(xpath = "//*[@id='nav']/ul/li[4]/a")
	private WebElementFacade aboutUsNode;

	@FindBy(xpath = "//*[@id='nav']/ul/li[5]/a")
	private WebElementFacade helpNode;
	
    //Browse by links
    @FindBy(xpath = "//*[@id='nav']/ul/li[1]/ul/li[1]/a")
	public WebElementFacade browseByCategoryNode;

    @FindBy(xpath = "//*[@id='nav']/ul/li[1]/ul/li[2]/a")
	public WebElementFacade browseByStateNode;
    				
    @FindBy(xpath = "//*[@id='nav']/ul/li[1]/ul/li[3]/a")
	public WebElementFacade browseByAgencyNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[1]/ul/li[4]/a")
	public WebElementFacade otherResourcesNode;
    
	// Newsroom
    @FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[1]/a")
	public WebElementFacade newsAndUpdatesNode;

    @FindBy(xpath = "//*[@id='nav']/ul/li[2]/ul/li[2]/a")
	public WebElementFacade compassNode;
  
    //Get Involved
    @FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[1]/a")
	public WebElementFacade becomeAnAdvocateNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[2]/a")
    public WebElementFacade becomeAnAffiliateNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[3]/ul/li[3]/a")
    public WebElementFacade linkToUsNode;
    
    //About Us
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
    
    //Help Nav
    @FindBy(xpath = "//*[@id='nav']/ul/li[5]/ul/li[1]/a")
	public WebElementFacade faqsNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[5]/ul/li[2]/a")
    public WebElementFacade contactUsNode;
    
    @FindBy(xpath = "//*[@id='nav']/ul/li[5]/ul/li[3]/a")
    public WebElementFacade privacyAndTermsOfUseNode;
    
    //Personalization
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

    //Language toggle
  	@FindBy(xpath = "//*[@id='block-locale-language-content']/ul/li/a")
  	private WebElementFacade toggleLanguageNode;
  	
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
    
    //Browse for Benefits links
    @FindBy(xpath = "//*[@id='category-icon']/a/p")
    private WebElementFacade categoryNode;
    
    @FindBy(xpath = "//*[@id='state-icon']/a/p")
    private WebElementFacade stateNode;
    
    @FindBy(xpath = "//*[@id='agency-icon']/a/p")
    private WebElementFacade agencyNode;
    
	@FindBy(xpath = "//*[@id='startFinder']/a")
	private WebElementFacade startBenefitFinderNode;
    
	// Title xpaths
    private static final String HOMEPAGE_TITLE_XPATH = "//*[@id='benefit-title']";
    private static final String PAGE_TITLE_XPATH = "//*[@id='page-title']";
    private static final String COMPASS_TITLE_XPATH = "//*[@id='content']/article/div[1]/div[3]";
    private static final String SUBPAGE_TITLE_XPATH = "//div[@class='field-items']/div[text()='%s']";
    
    private static final String BENEFIT_DETAIL_XPATH = "//div[@class='benefit-node']/div[text()='%s']";

    // *************************************************************************
 	// Functions
    
    //Main Nav
    public void clickBrowse() { 	
    	browseNode.click();
    }
    public void clickNews() { 	
    	newsroomNode.click();
    }
    public void clickInvolved() {
    	getInvolvedNode.click();
    }
    public void clickAboutUs() {
    	aboutUsNode.click();
    }
    public void clickHelp() {
    	helpNode.click();
    }
    //Sub Nav
    //Browse
    public void clickBrowseByCategory() { 	
    	clickSubNavButton(browseNode, browseByCategoryNode);
    }
    public void clickBrowseByState() { 	
    	clickSubNavButton(browseNode, browseByStateNode);
    }
    public void clickBrowseByAgency() { 	
    	clickSubNavButton(browseNode, browseByAgencyNode);
    }
    public void clickOtherResources() { 	
    	clickSubNavButton(browseNode, otherResourcesNode);
    }
    //Newsroom
    public void clickNewsAndUpdates() { 	
    	clickSubNavButton(newsroomNode, newsAndUpdatesNode);
    }
    public void clickCompass() { 	
    	clickSubNavButton(newsroomNode, compassNode);
    }
    //Get Involved
    public void clickBecomeAnAdvocate() { 	
    	clickSubNavButton(getInvolvedNode, becomeAnAdvocateNode);
    }
    public void clickBecomeAnAffiliate() { 	
    	clickSubNavButton(getInvolvedNode, becomeAnAffiliateNode);
    }
    public void clickLinkToUs() { 	
    	clickSubNavButton(getInvolvedNode, linkToUsNode);
    }
    //About Us
    public void clickOurMission() { 	
    	clickSubNavButton(aboutUsNode, ourMissionNode);
    }
    public void clickOurHistory() { 	
    	clickSubNavButton(aboutUsNode, ourHistoryNode);
    }
    public void clickOurPartners() { 	
    	clickSubNavButton(aboutUsNode, ourPartnersNode);
    }
    public void clickBecomeAPartner() { 	
    	clickSubNavButton(aboutUsNode, becomeAPartnerNode);
    }
    public void clickOurPlatform() { 	
    	clickSubNavButton(aboutUsNode, ourPlatformNode);
    }
    public void clickRecognition() { 	
    	clickSubNavButton(aboutUsNode, recognitionNode);
    }
    //Help
    public void clickFAQs() { 	
    	clickSubNavButton(helpNode, faqsNode);
    }
    public void clickContactUs() { 	
    	clickSubNavButton(helpNode, contactUsNode);
    }
    public void clickPrivacyAndTermsOfUse() { 	
    	clickSubNavButton(helpNode, privacyAndTermsOfUseNode);
    }
    // Get Title 
    public String getHomepageTitleXpath(){
    	return HOMEPAGE_TITLE_XPATH;
    }
    public String getPageTitleXpath(){
    	return PAGE_TITLE_XPATH;
    }
    public String getCompassTitleXpath(){
    	return COMPASS_TITLE_XPATH;
    }
    public String getSubpageTitleXpath(){
    	return SUBPAGE_TITLE_XPATH;
    } 
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
    //footer links
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
    
    public void clickSubNavButton(WebElementFacade nav, WebElementFacade subNav) {
        Actions action = new Actions(getDriver());
        action.moveToElement(nav).pause(1000).moveToElement(subNav).click().build().perform();
    }
    
    public String pullPageTitle(String xpath) {
    	WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));  
    	WebElement pageTitle = getDriver().findElement(By.xpath(xpath));
		return pageTitle.getText();
	}
        
    public String pullSubpageTitle(String subpageName) {
    	String subpage_xpath = String.format(SUBPAGE_TITLE_XPATH, subpageName);
    	
    	return pullPageTitle(subpage_xpath);
    }
	
	public String pullBenefitDetailTitle(String benefitTabName) {
    	String benefitTitle_xpath = String.format(BENEFIT_DETAIL_XPATH, benefitTabName);
    	WebElement benefitTitle = getDriver().findElement(By.xpath(benefitTitle_xpath));
    	return benefitTitle.getText();
    }
	
	// Personalization
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
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
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
	 
	public List<WebElement> FAQAnswers() {
		return this.getDriver().findElements(By.xpath(
				"//*[@class='content']/div[@class='field field-name-field-accordion-body field-type-text-with-summary field-label-hidden'][contains(@style,'display: block')]"));
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

	public boolean checkFAQAnswersShow() {
		List<WebElement> footer = FAQAnswers();

		return footer.size() == 14;
	}

	public boolean checkFAQAnswersHidden() {
		List<WebElement> footer = FAQButtonsExpand();

		return footer.size() == 14;
	}
	
	// Language toggle
	public void clickToggleLanguageButton() {
		pause(500);
		toggleLanguageNode.click();
	}
	
	// ***********************************************************************************
	//browse by category
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
	
	public String pullCategoryTitle(){
		return categoryTitle;
	}
	
	public String pullBenefitTitle(){
		return benefitTitle;
	}
	
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
	
	// ***********************************************************************************
	// Other resources
	public List<WebElement> groupHeadingNodes() {
		return this.getDriver().findElements(By.xpath("//*[@class='view-grouping-header']"));
	}

	public List<String> checkGroupHeadingNodes(){
		pause(500);
		List<String> headingList = new ArrayList<String>();
		List<WebElement> footer = groupHeadingNodes();
		
		for(int i = 0; i < footer.size(); i++){	
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
	
	@FindBy(xpath = "//*[@id='edit-field-resource-type-value-i18n']")
    private WebElementFacade filterByTypeDropdown;
	
	@FindBy(xpath = "//*[@id='edit-field-agency-state-value-i18n']")
    private WebElementFacade filterByStateDropdown;
	
	public void selectFilterByType(String filterType) {
		filterByTypeDropdown.sendKeys(filterType);
		pause(1000);
	}

	public void selectFilterByState(String filterType) {
		filterByStateDropdown.sendKeys(filterType);
		pause(1000);
	}
	
	// ***********************************************************************************
	// Compass, News and Updates
	private List<String> currentArticleTitles = new ArrayList<String>();
	private List<String> currentCompassArticleTitles = new ArrayList<String>();
	
	public List<WebElement> newsArticleNodes() {
		return this.getDriver().findElements(By.xpath("//*[@class='field field-name-field-bg-article-title field-type-text field-label-hidden']/div/div/a"));
	}
			
	public int checkNewsArticles() {
		List<WebElement> articles = newsArticleNodes();
		for(int i = 0; i < articles.size(); i++){
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
		 WebElementFacade articleNode = find(By.xpath(compassXpath));
		 currentCompassArticleTitles.add(articleNode.getText());
		 
		 articleNode.click();
		 pause(1000);
	}
	
	public String pullNewsAndUpdatesArticleTitle(String articleNum){
		int index = Integer.parseInt(articleNum) - 1;
		return currentArticleTitles.get(index);
	}
	
	public String pullCompassArticleTitle(String articleNum) {
		int index = Integer.parseInt(articleNum) - 1;
		return currentCompassArticleTitles.get(index).toLowerCase();
	}
	
	
	public String pullCurrentCompassTitle(String articleNum) {
		String compassTitleXpath = String.format(COMPASS_ARTICLE_TITLE_XPATH, articleNum);
		WebElementFacade articleTitleNode = find(By.xpath(compassTitleXpath));

		return articleTitleNode.getText().toLowerCase();
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
	
	@FindBy(xpath = "//*[@class='pager-current last']")
    private WebElementFacade newsUpdateLastPageNumber;
	
	public String getNewsAndUpdatesLastPageNumber(){
		return newsUpdateLastPageNumber.getText();
	}
	
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
	// Filter News and Updates articles
	public List<WebElement> articleTypeNodes() {
		return this.getDriver().findElements(By.xpath("//*[@class='field field-name-field-bg-article-type field-type-list-text field-label-hidden']/div/div"));
	}
			
	public boolean checkArticleType(String articleType) {
		List<WebElement> articlesType = articleTypeNodes();
		for(int i = 0; i < articlesType.size(); i++){
			String currentArticleType = articlesType.get(i).getText();
					
			if(!currentArticleType.contains(articleType)){
				return false;
			}	
		}
		return true;
	}	

	@FindBy(xpath = "//*[@id='edit-field-bg-article-type-value-i18n']")
    private WebElementFacade filterByNewsDropdown;
	
	@FindBy(xpath = "//*[@id='edit-field-article-categories-english-target-id']")
    private WebElementFacade filterByBenefitCategoryDropdown;
	
	@FindBy(xpath = "	//*[@id='edit-submit-articles']")
    private WebElementFacade applyButtonNewsAndUpdates;
	
	public void selectFilterByNewsType(String filterType) {
		
		filterByNewsDropdown.sendKeys(filterType);
		applyButtonNewsAndUpdates.click();
		pause(1000);
	}
	
	public void selectFilterByBenefitCategory(String filterType) {
		filterByBenefitCategoryDropdown.sendKeys(filterType);
		applyButtonNewsAndUpdates.click();
		pause(1000);
	}
	
	// ***********************************************************************************
	//Homepage Slider
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
		 }
		 
		 sliderTitle = sliderTileNode.getText();
		 sliderTileNode.click();
	}
	
	public String pullSliderTitle(){
		return sliderTitle;
	}
    
	public String processWindows() {
		// Store the current window handle
		String winHandleBefore = getDriver().getWindowHandle();
		
		// Perform the click operation that opens new window

		// Switch to new window opened
		List<String> browserTabs = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(browserTabs.get(1));
	
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("page loading");
			} catch (InterruptedException e) {
			}
			// To check page ready state.
			if (!getDriver().getCurrentUrl().equals("about:blank")) {
				System.out.println("done");
				break;	
			}
		}
	
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
	
	public String getWindowUrl(){
		String windowUrl = getDriver().getCurrentUrl();
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