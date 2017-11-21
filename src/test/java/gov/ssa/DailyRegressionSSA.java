package gov.ssa;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import gov.ssa.UserSSA;

public class DailyRegressionSSA {

    @Steps
    UserSSA userSSA;

    //Scenario: Verify all of the navbar tabs to assert that the pages open correctly
    
    @Given("the user is on the SSABest homepage")
    public void the_user_is_on_homepage() {
    	userSSA.onHomePage();
    }
    
    @Given("the user is on the Spanish SSABest homepage")
    public void the_user_is_on_Spanish_homepage() {
    	userSSA.open_page("/es");
    }
    
    //sub nav
    @When("the user clicks on the <subNavMenuItem> button within the SSABest top navigation bar")
    public void when_user_clicks_on_each_sublink_in_the_GL_top_navigation_bar(@Named("subNavMenuItem") String subNavMenuItem) {
    	userSSA.clickNavNode(subNavMenuItem);
	}

    @Then("the SSABest <subNavMenuItem> page should open correctly")
    public void then_the_SSA_sub_navigation_page_should_open_correctly(@Named("subNavMenuItem") String subNavMenuItem) {
    	userSSA.shouldSeePage(subNavMenuItem);
	}
    
    //footer links
    @When("the user clicks on the SSABest <footerItem> footer link")
    public void when_user_clicks_on_the_SSABest_footer_link(@Named("footerItem") String footerItem) {
    	userSSA.clickFooterLink(footerItem);
	}

    @Then("the SSABest <footerItem> page should open correctly")
    public void then_the_SSABest_footer_item_page_should_open_correctly(@Named("footerItem") String footerItem) {
    	userSSA.verifyFooterURL(footerItem);
    }
    
    //homepage links
    @When("the user clicks on the SSABest <homepageItem> homepage link")
    public void when_user_clicks_on_the_SSABest_homepage_link(@Named("homepageItem") String homepageItem) {
		userSSA.clickHomepageLink(homepageItem);
	}

    @Then("the SSABest <homepageItem> page should open correctly")
    public void then_the_SSABest_homepageItem_page_should_open_correctly(@Named("homepageItem") String homepageItem) {
    	userSSA.verifyHomepageLink(homepageItem);
	}

    //home button tests
    @Given("the user is on the SSABest FAQ page")
    public void given_the_user_is_on_the_SSABest_overview_page() {
        userSSA.open_page("/help/faqs");
    }
    
    @Given("the user is on the Spanish SSABest FAQ page")
    public void given_the_user_is_on_the_Spanish_SSABest_overview_page() {
        userSSA.open_page("/es/help/faqs");
    }
    
    @When("the user clicks on the SSABest <homeButton> button")
    public void when_user_clicks_on_the_SSABest_homeButton(@Named("homeButton") String homeButton) {
    	userSSA.clickHomeButton(homeButton);
	}

    @Then("the SSABest homepage should open correctly")
    public void then_the_SSABest_homepage_should_open_correctly() {
    	userSSA.verifyHomepage();
	}
    
    @Then("the Spanish SSABest homepage should open correctly")
    public void then_the_Spanish_SSABest_homepage_should_open_correctly() {
    	userSSA.verifyHomepageES();
	}
    
    //toggle language test
    @When("the user clicks on the SSABest toggle language button")
    public void when_the_user_clicks_on_the_SSABest_toggle_language_button() {
		userSSA.clickToggleLanguage();
	}
    
    @Then("the user should be taken to the SSABest Spanish homepage")
    public void then_the_user_should_be_taken_to_the_SSABest_Spanish_home_page() {
		userSSA.verifyToggleLanguage("ES");
	}
    
    @Then("the user should be taken to the SSABest English homepage")
    public void then_the_user_should_be_taken_to_the_SSABest_English_home_page() {
		userSSA.verifyToggleLanguage("EN");
	}
    
    //Browse by category test
    @Given("the user is on the SSABest Browse By Category page")
    public void given_the_user_is_on_the_SSABest_Browse_By_page() {
        userSSA.open_page("/benefits/browse-by-category");
    }
    
    @Given("the user is on the Spanish SSABest Browse By Category page")
    public void given_the_user_is_on_the_Spanish_SSABest_Browse_By_page() {
        userSSA.open_page("/es/benefits/browse-by-category");
    }
    
    @When("the user clicks on the SSABest Browse By <categoryItem> link")
    public void when_user_clicks_on_the_SSABest_Browse_By_categoryItem_link(@Named("categoryItem") String categoryItem) {
		userSSA.clickBrowseByCategorySSA(categoryItem);
	}
    
    @Then("the SSABest <categoryItem> page should open correctly")
    public void then_the_SSABest_categoryItem_page_should_open_correctly(@Named("categoryItem") String categoryItem) {
    	userSSA.shouldSeePage(categoryItem);
    }	

    @When("the user clicks on a <categoryItem> benefit")
    public void when_the_user_clicks_on_a_categoryItem_benefit() {
		userSSA.clickBenefitDetailNode();
	}
    
    @Then("the correct SSA benefit page should appear")
    public void then_the_correct_SSA_benefit_page_should_appear() {
		userSSA.verifyBenefitTitle();
	}
    
    //FAQ
    @When("the user clicks on the SSABest FAQ <questionNum> link")
    public void when_the_user_clicks_on_the_SSABest_FAQ_questionNum_link(@Named("questionNum") String questionNum) {
		userSSA.clickFAQ(questionNum);
	}
    
    @Then("the FAQ <questionNum> page should open correctly")
    public void then_the_FAQ_questionNum_page_should_open_correctly() {
		userSSA.verifyFAQTitle();
	}
    
    
}
