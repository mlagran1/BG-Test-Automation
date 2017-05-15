package com.bah.nos.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

//import gov.benefits.bg.test.steps.serenity.User;
import com.bah.nos.steps.serenity.User;

public class DailyRegression {

    @Steps
    User user;

    //Scenario: Verify all of the navbar tabs to assert that the pages open correctly
    
    @Given("the user is on the Benefits home page")
    public void the_user_is_on_homepage() {
        user.onHomePage();
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
    

	

}
