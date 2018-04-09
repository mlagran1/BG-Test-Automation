package gov.bg;

import gov.bg.ResourceFinderAnswer;
import gov.bg.ResourceFinderResult;
import gov.bg.ResourceFinderTestCase;
import gov.bg.pages.ResourceFinderFavoritePage;
import gov.bg.pages.ResourceFinderQuestionPage;
import gov.bg.pages.ResourceFinderResultPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class ResourceFinderSteps {

    private static final Logger log = LoggerFactory.getLogger(ResourceFinderSteps.class);

    private ResourceFinderQuestionPage questionPage;

    private ResourceFinderResultPage resultPage;

    private ResourceFinderFavoritePage favoritePage;
    
    @Step
    public void closeWindow() {
    			
    	questionPage.closePage();
    }

    @Step
    public void onFinderPage(String language) {
    	
		questionPage.clearCookies();
		System.out.println("Cleared Cookies");
		String url = questionPage.setEnvironment(language);
//		questionPage.openAt(url);		
//		System.out.println("Directory path is: " + questionPage.setEnvironment(language));	
		
		questionPage.openAt("https://www.benefits.gov/");
		//startFinder.click();
	
    }
    
    @Step
    public void clickQuestionnaireButton() {
    	questionPage.clickFinderButton();
    }

    @Step
    public void resetAnswers() {
        questionPage.clickResetAnswers();
    }
    
    
    @Step
    public void openPage() {
        questionPage.open();
    }

    @Step
    public void answerQuestion(ResourceFinderAnswer resourceFinderAnswer) {
        questionPage.answer(resourceFinderAnswer);
    }

    @Step
    public void navigateToResults() {
        questionPage.clickQuestionnaireNavResults();
    }

    @Step
    public void addResultsToFavorites(String resourceTitle) throws IOException {
        resultPage.addToFavorites(resourceTitle);
    }

    @Step
    public void verifyBenefitsDisplayed(ResourceFinderResult result) throws IOException {
        if (result == null) {
            log.info("No results in test case to assert");
            return;
        }

        questionPage.clickQuestionnaireNavResults();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            log.info("sleep interrupted");
        }

        // Assert total count
        if (result.getTotalResourceCount() != null) {
            Assert.assertEquals(result.getTotalResourceCount(), resultPage.getBenefitTotal());
        }

        // Assert all resource titles on results page
        List<String> resourceTitles = resultPage.getResourceTitles();

       // result.getResultAssertionList().forEach(s -> Assert.assertTrue(resourceTitles.contains(s)));
       // result.getResultAssertionList().forEach(s -> Assert.assertEquals(resourceTitles, s));
        
        Assert.assertEquals(result.getResultAssertionList(), resourceTitles);
        
        //System.out.println("result.getResultAssertionList(): " + result.getResultAssertionList());
        //System.out.println("resourceTitles:" + resourceTitles);
        
        // Assert all resource titles on favorites page
        resultPage.clickQuestionnaireNavFavorites();

        List<String> favoriteTitles = favoritePage.getFavoriteTitles();
        result.getFavorites().forEach(s -> Assert.assertTrue(favoriteTitles.contains(s)));



    }

}
