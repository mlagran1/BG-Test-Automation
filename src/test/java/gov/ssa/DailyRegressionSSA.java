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

    
}
