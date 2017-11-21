package gov.bg;

import gov.bg.ResourceFinderAnswer;
import gov.bg.ResourceFinderResult;
import gov.bg.ResourceFinderTestCase;
import gov.bg.ResourceFinderSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.io.IOException;
import java.io.InputStream;

public class ResourceFinderNarrative {

    @Steps
    private ResourceFinderSteps resourceFinderSteps;

    @Given("I am on the Benefits.gov benefit finder page")
    public void onResourceFinderPage() {
        resourceFinderSteps.onFinderPage("");
    }
    
    @Given("I am on the Spanish Benefits.gov benefit finder page")
    public void onSpanishResourceFinderPage() {
        resourceFinderSteps.onFinderPage("es/");
    }
    
    
    @Given("I am on the SSABest.gov benefit finder page")
    public void onResourceFinderPageSSA() {
        resourceFinderSteps.onFinderPageSSA("");
    }
    
    @Given("I am on the Govloans.gov benefit finder page")
    public void onResourceFinderPageGL() {
        resourceFinderSteps.onFinderPageGL("");
    }
      

    @When("I enter my <information> into the questionnaire")
    public void completeResourceFinder(@Named("information") String testCaseFileName) throws IOException {
    	
    	
    	resourceFinderSteps.resetAnswers();
    	
    	ResourceFinderTestCase testCase = getTestCase(testCaseFileName);

        for (ResourceFinderAnswer answer : testCase.getAnswers()) {
            resourceFinderSteps.answerQuestion(answer);
        }
    }

    @When("I add results from my <information> to my favorites")
    public void addToFavorites(@Named("information") String testCaseFileName) throws IOException {
        ResourceFinderTestCase testCase = getTestCase(testCaseFileName);

        if (!testCase.getResult().getFavorites().isEmpty()) {
            resourceFinderSteps.navigateToResults();
            for (String resourceTitle : testCase.getResult().getFavorites()) {
                resourceFinderSteps.addResultsToFavorites(resourceTitle);
            }
        }

        Serenity.takeScreenshot();
    }

    @Then("I should see available benefits related to my <information>")
    public void thenBenefitsDisplayed(@Named("information") String testCaseFileName) throws IOException {
    	//resourceFinderSteps.closeWindow();
    	
        ResourceFinderResult result = getTestCase(testCaseFileName).getResult();

        resourceFinderSteps.verifyBenefitsDisplayed(result);

        Serenity.takeScreenshot();
        
        
    }

    private ResourceFinderTestCase getTestCase(String testCaseFileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("stories/findResources/" + testCaseFileName);
        String json = IOUtils.toString(inputStream);

        return mapper.readValue(json, ResourceFinderTestCase.class);
    }
}
