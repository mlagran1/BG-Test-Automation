package gov.bg.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

public abstract class ResourceFinderPage extends BasePage {

    @FindBy(xpath = "//div[@id='questionnaire-id']/div[@id='mtid']/ul/li/a[text()='Answer Questions']")
    private WebElementFacade questionnaireNavAnswer;

    @FindBy(xpath = "(//div[@id='questionnaire-id']/div[@id='mtid']/ul/li/a)[2]")
    private WebElementFacade questionnaireNavResults;

    @FindBy(xpath = "(//div[@id='questionnaire-id']/div[@id='mtid']/ul/li/a)[3]")
    private WebElementFacade questionnaireNavFavorites;

    @FindBy(xpath = "//div[@id='bc-value']")
    private WebElementFacade benefitTotal;
    
    
    @FindBy(xpath = "//*[@id='resetButton']")
    private WebElementFacade resetAnswersButton;

    @FindBy(xpath = "//*[@class='btn'][1]")
  
    private WebElementFacade resetAnswersPopup;
    
    public void clickResetAnswers() {
    	resetAnswersButton.click();
    	System.out.println("Answers Reset");
    	sleep(1000);
    	resetAnswersPopup.click();
    }
    
    public void closePage() {
    	System.out.println("Closing Window");
    	this.getDriver().quit();
    }
    
    

    public ResourceFinderPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void clickQuestionnaireNavAnswer() {
        scrollToTop();
        questionnaireNavAnswer.click();
    }

    public void clickQuestionnaireNavResults() {
        scrollToTop();
        questionnaireNavResults.click();
    }

    public void clickQuestionnaireNavFavorites() {
        scrollToTop();
        questionnaireNavFavorites.click();
    }

    public Integer getBenefitTotal() {
        return Integer.parseInt(benefitTotal.getText());
    }

}
