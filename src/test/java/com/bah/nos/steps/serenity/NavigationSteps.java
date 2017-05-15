package com.bah.nos.steps.serenity;

import com.bah.nos.model.pages.NosBasePage;
import com.bah.nos.model.NosPageEnum;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class NavigationSteps {

    private NosBasePage currentPage;

    @Step
    public void openPage(NosPageEnum page) throws ReflectiveOperationException {
        currentPage = page.getPageClass().getDeclaredConstructor(WebDriver.class).newInstance(currentPage.getDriver());
        currentPage.open();
    }
    
    @Step
    public void navigate(String navBarPath) throws ReflectiveOperationException {
        currentPage = currentPage.navigate(navBarPath);
    }

    
    //i wanna set a condition for the nav bar path to distiguish between nav ans subnag titles
    @Step
    public void verifyTitle(String navBarPath) {
	
        NosPageEnum page = NosPageEnum.getPageByNavPath(navBarPath);
            
    	System.out.println("page is to string : " + page.toString() );
        
        if(page.toString().contains("SUBNAV")){
        	Assert.assertEquals(page.getPageTitle(), currentPage.getSubpageTitle());
        	System.out.println("hit subnav");
        }
        else{
        	 Assert.assertEquals(page.getPageTitle(), currentPage.getPageTitle());
        	 System.out.println("did NOT hit subnav");
        }    
        
    }

}
