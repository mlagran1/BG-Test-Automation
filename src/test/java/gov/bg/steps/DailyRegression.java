package gov.bg.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

//import gov.benefits.bg.test.steps.serenity.User;
import gov.bg.steps.serenity.User;

public class DailyRegression {

    @Steps
    User user;

    //Scenario: Verify all of the navbar tabs to assert that the pages open correctly
    
    @Given("the user is on the Benefits home page")
    public void the_user_is_on_homepage() {
        user.onHomePage();
    }
    
    @Given("the user is on the Spanish Benefits home page")
    public void the_user_is_on_spanish_homepage() {
        user.open_page("/es");
    }
    
    @When("the user clicks on <navMenuItem> within the top navigation bar")
    public void when_I_click_on_each_link_in_the_top_navigation_bar(@Named("navMenuItem") String navMenuItem) {
		user.clickNavNode(navMenuItem);
	}

    @Then("the <navMenuItem> page should open correctly")
    public void then_the_navigation_tab_should_open_correctly(@Named("navMenuItem") String navMenuItem) {
		user.shouldSeePage(navMenuItem);
	}
    
    //sub nav
    @When("the user clicks on the <subNavMenuItem> within the top navigation bar")
    public void when_user_clicks_on_each_sublink_in_the_top_navigation_bar(@Named("subNavMenuItem") String subNavMenuItem) {
		user.clickNavNode(subNavMenuItem);
	}

    @Then("the <subNavMenuItem> page should open correctly")
    public void then_the_sub_navigation_page_should_open_correctly(@Named("subNavMenuItem") String subNavMenuItem) {
		user.shouldSeePage(subNavMenuItem);
	}
    
  //browse by links
    @When("the user clicks on the <browseByItem> on the homepage")
    public void when_user_clicks_on_each_browse_by_link_on_the_homepage(@Named("browseByItem") String browseByItem) {
		user.clickBrowseByNode(browseByItem);
	}

    @Then("the <browseByItem> page should open correctly")
    public void then_the_browse_by_page_should_open_correctly(@Named("browseByItem") String browseByItem) {
		user.shouldSeePage(browseByItem);
	}
    
    
    
  //footer links
    @When("the user clicks on the <footerLink> within the homepage")
    public void when_user_clicks_on_each_footer_link_on_the_homepage(@Named("footerLink") String footerLink) {
		user.clickFooterLink(footerLink);
	}

    @Then("the <footerLink> page should open correctly")
    public void then_the_footer_link_page_should_open_correctly(@Named("footerLink") String footerLink) {
    	user.verifyFooterURL(footerLink);
	}
    
//pzn test
    
    @When("the user clicks on the change location button")
    public void when_user_clicks_on_the_change_location_button() {
		user.clickChangeLocation();
	}

    @Then("the Enter State or Territory text field should show")
    public void then_the_enter_state_or_territory_text_field_should_show() {
    	user.verifyTextfieldVisible();
	}
    
    @When("the user enters a <stateOrTerritory> in the text field")
    public void the_user_enters_a_state_or_territory_in_the_text_field(@Named("stateOrTerritory") String stateOrTerritory) {
		user.clickPznButtons(stateOrTerritory);
	}

    @Then("the correct <stateOrTerritory> should show")
    public void then_the_correct_state_or_territory_should_show(@Named("stateOrTerritory") String stateOrTerritory) {
    	user.verifyStateName(stateOrTerritory);
	}
    
    @Then("the correct benefits should show")
    public void then_the_correct_benefits_should_show() {
    	user.verifyBenefitTitles();
	}
    
    
  //FAQ page test
    @Given("the user is on the Benefits FAQ page")
    public void the_user_is_on_FAQ_page() {
        user.open_page("/help/faqs");
    }
    
    @Given("the user is on the Spanish Benefits FAQ page")
    public void the_user_is_on_the_Spanish_FAQ_page() {
        user.open_page("/es/help/faqs");
    }
    
    
    @When("the user clicks on the expand button")
    public void when_the_user_clicks_on_the_expand_button() {
		user.clickExpandFAQ();
	}

    @Then("the answer text should show")
    public void then_the_answer_text_should_show() {
		user.verifyFAQAnswersArePresent();
	}

    @When("the user clicks on the minimize button")
    public void when_the_user_clicks_on_the_minimize_button() {
		user.clickMinimizeFAQ();
	}
    
    @Then("the answer text should be hidden")
    public void then_the_answer_text_should_be_hidden() {
		user.verifyFAQAnswersAreHidden();
	}
    
    //Homepage test
    
    @Then("the home page title should show")
    public void then_the_home_page_title_should_show() {
		user.verifyHomepageTitle("EN");
	}

    @When("the user clicks on the home button")
    public void when_the_user_clicks_on_the_home_button() {
    	user.open_page("/newsroom/news-and-updates");
		user.clickHomeButtonNode();
	}
    
    @Then("the user should be taken to the home page")
    public void then_the_user_should_be_taken_to_the_home_page() {
		user.verifyHomepageTitle("EN");
	}
    
    //homepage ES
    @Then("the Spanish home page title should show")
    public void then_the_Spanish_home_page_title_should_show() {
		user.verifyHomepageTitle("ES");
	}

    @When("the user clicks on the Spanish home button")
    public void when_the_user_clicks_on_the_Spanish_home_button() {
    	user.open_page("/es/newsroom/news-and-updates");
		user.clickHomeButtonNode();
	}
    
//    @Then("the user should be taken to the Spanish home page")
//    public void then_the_user_should_be_taken_to_the_Spanish_home_page() {
//		user.verifyHomepageTitle("ES");
//	}
    
    
    
    //toggle language test
    
    @When("the user clicks on the toggle language button")
    public void when_the_user_clicks_on_the_toggle_language_button() {
		user.clickToggleLanguageButtonNode();
	}
    
    @Then("the user should be taken to the Spanish home page")
    public void then_the_user_should_be_taken_to_the_Spanish_home_page() {
		user.verifyHomepageTitle("ES");
	}
    
    @Then("the user should be taken to the English home page")
    public void then_the_user_should_be_taken_to_the_English_home_page() {
		user.verifyHomepageTitle("EN");
	}
    
    //Browse by category page

    @Given("the user is on the Browse by <browseByItem> page")
    public void the_user_is_on_Browse_by_Item_page(@Named("browseByItem") String browseByItem) {
        user.open_page("/benefits/browse-by-" + browseByItem);
    }
    
    @Given("the user is on the Spanish Browse by <browseByItem> page")
    public void the_user_is_on_Spanish_Browse_by_Item_page(@Named("browseByItem") String browseByItem) {
        user.open_page("/es/benefits/browse-by-" + browseByItem);
    }
    
    @When("the user clicks on a category")
    public void when_the_user_clicks_on_a_category() {
		user.clickBrowseByCategoryNode();
	}
    
    @Then("the correct category page should appear")
    public void then_the_correct_category_page_should_appear() {
		user.verifyCategoryTitle();
	}
    
    @When("the user clicks on a benefit")
    public void when_the_user_clicks_on_a_benefit() {
		user.clickBrowseByBenefitNode();
	}
    
    @Then("the correct benefit page should appear")
    public void then_the_correct_benefit_page_should_appear() {
		user.verifyBenefitTitle();
	}
    
    
    
    

    
   //Other resources page    
    @Given("the user is on the Other Resources page")
    public void the_user_is_on_Other_Resources_page() {
        user.open_page("/benefits/other-resources");
    }
    
    @Given("the user is on the Spanish Other Resources page")
    public void the_user_is_on_Spanish_Other_Resources_page() {
        user.open_page("/es/benefits/other-resources");
    }
    
    
    @When("the user clicks on the minimize filter button")
    public void when_the_correct_number_of_filter_categories_should_appear() {
		user.clickToggleFilterButtonNode();
	}
    @Then("the filter should disappear")
    public void then_the_filter_should_disappear() {
		user.verifyFilterIsHidden();
	}
    @When("the user clicks on the expand filter button")
    public void when_the_user_clicks_on_the_expand_filter_button() {
		user.clickToggleFilterButtonNode();
	}
    @Then("the filter should reappear")
    public void then_the_filter_should_reappear() {
		user.verifyFilterIsPresent();
	}
 

    @When("the user filters by type <filterByType>")
    public void when_the_user_filters_by_type_filterByType(@Named("filterByType") String filterByType) {
		user.clickFilterByType(filterByType);
	}
    
    @Then("the correct group headings for type <filterByType> should appear")
    public void then_the_correct_group_headings_for_type_filterByType_should_appear(@Named("filterByType") String filterByType) {
		user.verifyGroupHeadingsEN(filterByType);
	}
    
    @Then("the correct Spanish group headings for type <filterByType> should appear")
    public void then_the_correct_Spanish_group_headings_for_type_filterByType_should_appear(@Named("filterByType") String filterByType) {
		user.verifyGroupHeadingsES(filterByType);
	}
    
    
    @When("the user filters by state <filterByState>")
    public void when_the_user_filters_by_state_filterByState(@Named("filterByState") String filterByState) {
		user.clickFilterByState(filterByState);
	}
    
    @Then("the correct group headings for state <filterByState> should appear")
    public void then_the_correct_group_headings_for_state_filterByState_should_appear(@Named("filterByState") String filterByState) {
		user.verifyGroupHeadingsEN(filterByState);
	}
    
    @Then("the correct Spanish group headings for state <filterByState> should appear")
    public void then_the_correct_Spanish_group_headings_for_state_filterByState_should_appear(@Named("filterByState") String filterByState) {
		user.verifyGroupHeadingsES(filterByState);
	}

    
     
    @When("the user filters by all categories")
    public void when_the_user_filters_by_all_categories() {
		user.clickCategoriesCheckbox();
	}
    
    @Then("the correct group headings for categories should appear")
    public void then_the_correct_group_headings_for_categories_should_appear() {
    	user.verifyGroupHeadingsEN("-ANY-");
	}
    
    @Then("the correct Spanish group headings for categories should appear")
    public void then_the_correct_Spanish_group_headings_for_categories_should_appear() {
    	user.verifyGroupHeadingsES("-TODAS-");
	}
    
    
    
    //News & Updates
    
    @Given("the user is on the News & Updates page")
    public void given_the_user_is_on_the_news_and_updates_page() {
		user.open_page("/newsroom/news-and-updates");
	}
    
    @Given("the user is on the Spanish News & Updates page")
    public void given_the_user_is_on_the_Spanish_news_and_updates_page() {
		user.open_page("/es/newsroom/news-and-updates");
	}
    
    @Then("the user should see five news articles")
    public void then_the_user_should_see_five_news_articles() {
    	user.verifyNewsArticles();
	}
    
    @When("the user clicks on article <articleNum>")
    public void when_the_user_clicks_on_article_articleNum(@Named("articleNum") String articleNum) {
		user.clickNewsArticle(articleNum);
	}
    
    @Then("the user should be taken to the correct article")
    public void then_the_user_shsould_be_taken_to_the_correct_article_page(@Named("articleNum") String articleNum) {
		user.verifyNewsArticleTitle(articleNum);
	}
    
    
    @When("the user clicks on article <articleNum> read more")
    public void when_the_user_clicks_on_article_articleNum_read_more(@Named("articleNum") String articleNum) {
		user.clickArticleReadMore(articleNum);
	}
    
    
    @When("the user clicks on the next button")
    public void when_the_user_clicks_on_the_next_button() {
    	user.clickNewsNavButton("next");
	}
    
    @Then("the user should be taken to the next page")
    public void then_the_user_should_be_taken_to_the_next_page() {
    	user.verifyNewsAndUpdatesNavButtons("next");
	}
    
    @When("the user clicks on the previous button")
    public void when_the_user_clicks_on_the_previous_button() {
    	user.clickNewsNavButton("prev");
	}
    
    @Then("the user should be taken to the previous page")
    public void then_the_user_should_be_taken_to_the_previous_page() {
    	user.verifyNewsAndUpdatesNavButtons("prev");
	}
    
    @When("the user clicks on the last button")
    public void when_the_user_clicks_on_the_last_button() {
    	user.clickNewsNavButton("last");
	}
    
    @Then("the user should be taken to the last page")
    public void then_the_user_should_be_taken_to_the_last_page() {
    	user.verifyNewsAndUpdatesNavButtons("last");
	}
    
    @Then("the user should be taken to the Spanish last page")
    public void then_the_user_should_be_taken_to_the_Spanish_last_page() {
    	user.verifyNewsAndUpdatesNavButtonsES("last");
	}
    
    @When("the user clicks on the first button")
    public void when_the_user_clicks_on_the_first_button() {
    	user.clickNewsNavButton("first");
	}
    
    @Then("the user should be taken to the first page")
    public void then_the_user_should_be_taken_to_the_first_page() {
    	user.verifyNewsAndUpdatesNavButtons("first");
	}
    
   

    @When("the user filters by news type <filterByType>")
    public void when_the_user_filers_by_news_type_filterByType(@Named("filterByType") String filterByType) {
		user.clickFilterByNewsType(filterByType);
	}
    
    @Then("the correct articles for news type <filterByType> should appear on the page")
    public void then_the_correct_articles_for_news_type_filterByType_should_appear_on_the_page(@Named("filterByType") String filterByType) {
		user.verifyArticleType(filterByType);;
	}

    
    @When("the user filters by benefit category <benefitCategory>")
    public void when_the_user_filers_by_benefit_category(@Named("benefitCategory") String benefitCategory) {
		user.clickFilterByBenefitCategory(benefitCategory);
	}
    
    @Then("the correct articles for benefit category <benefitCategory> should appear on the page")
    public void then_the_correct_articles_for_benefit_category_should_appear_on_the_page(@Named("benefitCategory") String benefitCategory) {
		user.verifyArticleType(benefitCategory);;
	}
    
    //compass tests

    @Given("the user is on the Compass Newsletter page")
    public void given_the_user_is_on_the_compass_newsletter_page() {
		user.open_page("/newsroom/eNewsletter/july-2017");
	}
    
    @Given("the user is on the Spanish Compass Newsletter page")
    public void given_the_user_is_on_the_Spanish_compass_newsletter_page() {
		user.open_page("/es/newsroom/eNewsletter/july-2017");
	}
    
    @Then("the user should see the correct number of compass articles")
    public void then_the_user_should_see_six_compass_articles() {
    	user.verifyCompassArticles();
	}
    
   
    
    @When("the user clicks on compass article <articleNum>")
    public void when_the_user_clicks_on_compass_article_articleNum(@Named("articleNum") String articleNum) {
		user.clickCompassArticle(articleNum);
	}
    
    
    @Then("the user should be taken to the correct compass article")
    public void then_the_user_should_be_taken_to_the_correct_compass_article(@Named("articleNum") String articleNum) {
    	user.verifyCompassArticleTitle(articleNum);
	}
    
    
    @When("the user clicks on compass article <articleNum> read more")
    public void when_the_user_clicks_on_compass_article_articleNum_read_more(@Named("articleNum") String articleNum) {
		user.clickCompassReadMore(articleNum);
	}

    
    @When("the user clicks on compass article tab <articleNum>")
    public void when_the_user_clicks_on_compass_article_tab(@Named("articleNum") String articleNum) {
		user.clickCompassTabs(articleNum);
	}
    
 
    @Then("the user should see the correct compass article")
    public void then_the_user_should_see_the_correct_compass_article(@Named("articleNum") String articleNum) {
		user.verifyCompassTabs(articleNum);
	}

    //Slider test
    
    @When("the user clicks on slider tile <sliderNum>")
    public void when_the_user_clicks_on_slider_tile_silderNum(@Named("sliderNum") String sliderNum) {
		user.clickSliderTile(sliderNum);
	}
    
    
    @Then("the slider page should open correctly")
    public void then_the_slider_page_should_open_correctly(@Named("sliderNum") String sliderNum) {
		user.verifySliderTitle(sliderNum, "EN");
	}
    
    @Then("the Spanish slider page should open correctly")
    public void then_the_Spanish_slider_page_should_open_correctly(@Named("sliderNum") String sliderNum) {
		user.verifySliderTitle(sliderNum, "ES");
	}
    


    
}
