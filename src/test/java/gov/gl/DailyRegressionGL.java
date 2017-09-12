package gov.gl;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import gov.gl.UserGL;

public class DailyRegressionGL {

    @Steps
    UserGL userGL;

    //Scenario: Verify all of the navbar tabs to assert that the pages open correctly
    
    @Given("the user is on the GovLoans homepage")
    public void the_user_is_on_homepage() {
        userGL.onHomePage();
    }
    
    //sub nav
    @When("the user clicks on the <subNavMenuItem> button within the GovLoans top navigation bar")
    public void when_user_clicks_on_each_sublink_in_the_GL_top_navigation_bar(@Named("subNavMenuItem") String subNavMenuItem) {
    	userGL.clickNavNode(subNavMenuItem);
	}

    @Then("the GovLoans <subNavMenuItem> page should open correctly")
    public void then_the_GL_sub_navigation_page_should_open_correctly(@Named("subNavMenuItem") String subNavMenuItem) {
    	userGL.shouldSeePage(subNavMenuItem);
	}
    
    //footer links
    @When("the user clicks on the GovLoans <footerItem> footer link")
    public void when_user_clicks_on_the_GovLoans_footer_link(@Named("footerItem") String footerItem) {
		userGL.clickFooterLink(footerItem);
	}

    @Then("the GovLoans <footerItem> page should open correctly")
    public void then_the_GovLoans_footer_item_page_should_open_correctly(@Named("footerItem") String footerItem) {
    	userGL.verifyFooterURL(footerItem);
	}
    
    //Loan Category homepage links
    @When("the user clicks on the GovLoans <categoryItem> category link")
    public void when_user_clicks_on_the_GovLoans_category_link(@Named("categoryItem") String categoryItem) {
		userGL.clickCategoriesHomepage(categoryItem);
	}

    @Then("the GovLoans <categoryItem> page should open correctly")
    public void then_the_GovLoans_categoryItem_page_should_open_correctly(@Named("categoryItem") String categoryItem) {
    	userGL.shouldSeePage(categoryItem);
	}
    
    //homepage links
    @When("the user clicks on the GovLoans <homepageItem> homepage link")
    public void when_user_clicks_on_the_GovLoans_homepage_link(@Named("homepageItem") String homepageItem) {
		userGL.clickHomepageLink(homepageItem);
	}

    @Then("the GovLoans <homepageItem> page should open correctly")
    public void then_the_GovLoans_homepageItem_page_should_open_correctly(@Named("homepageItem") String homepageItem) {
    	userGL.verifyHomepageLink(homepageItem);
	}
   
    //home button tests
    @Given("the user is on the GovLoans Overview page")
    public void given_the_user_is_on_the_GovLoans_overview_page() {
        userGL.open_page("/about/overview");
    }
    
    @When("the user clicks on the GovLoans <homeButton> button")
    public void when_user_clicks_on_the_GovLoans_homeButton(@Named("homeButton") String homeButton) {
		userGL.clickHomeButton(homeButton);
	}

    @Then("the GovLoans homepage should open correctly")
    public void then_the_GovLoans_homepage_should_open_correctly() {
    	userGL.verifyHomepage();
	}
    

    //toggle language test
    @When("the user clicks on the GovLoans toggle language button")
    public void when_the_user_clicks_on_the_GovLoans_toggle_language_button() {
		//userGL.clickToggleLanguage();
	}
    
    @Then("the user should be taken to the GovLoans Spanish home page")
    public void then_the_user_should_be_taken_to_the_GovLoans_Spanish_home_page() {
		userGL.verifyToggleLanguage("ES");
	}
    
    @Then("the user should be taken to the GovLoans English home page")
    public void then_the_user_should_be_taken_to_the_GovLoans_English_home_page() {
		userGL.verifyToggleLanguage("EN");
	}
    

    
}
