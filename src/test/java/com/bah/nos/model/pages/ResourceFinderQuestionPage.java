package com.bah.nos.model.pages;

import com.bah.nos.model.ResourceFinderAnswer;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

import org.openqa.selenium.JavascriptExecutor;

@DefaultUrl("https://www.benefits.gov/benefits/benefit-finder")
public class ResourceFinderQuestionPage extends ResourceFinderPage {

    // -------- Question and answer xpath strings --------

    private static final String ACTIVE_SECTION_XPATH = "//div[@class='tab-content']";

    private static final String PARENT_QUESTION_XPATH = ACTIVE_SECTION_XPATH +
            "/fieldset/div[./legend/div/span[@class='badge badge-info ui-question-text-number' and text()='%d']]";

    //The string input for answer label does not include single quotes, required to be placed by String.format
    private static final String ANSWER_BUTTON_XPATH = PARENT_QUESTION_XPATH +
            "/div/label/input[normalize-space(@data-answerlabel)=%s]";

    private static final String TEXT_INPUT_XPATH = PARENT_QUESTION_XPATH + "/div/input[@type='text']";
    
    private static final String DROPDOWN_XPATH = PARENT_QUESTION_XPATH + "/div/select";
    

    // -------- Page navigation xpath strings --------

    private static final String SECTION_NAV_XPATH =
            "//ul[@class='nav nav-tabs']/li/a/div[text()=%s]";

    private static final String PAGE_NUM_XPATH = "//div[@class='tab-content']/p/ul/li/a[text()='%d']";

    // -------- Static xpath derived elements --------

    @FindBy(xpath = "//div[@class='tab-content']/h6[@class='result-header']")
    private WebElementFacade sectionTitle;
    
     //div[@class='tab-content']/p/ul/li[@class='active' or @class='active disabled']/a

  //*[@id="bootpag_selection_cat_1"]/ul/li[2]/a
    @FindBy(xpath = "//div[@class='tab-content']/p/ul/li[@class='active' or @class='active disabled']/a")
    private WebElementFacade currentPageNum;
    
    @FindBy(xpath = "//div[@class='tab-content']/p/ul/li[(@class='active' or @class='active disabled') and (contains(@style,'display: none'))]/a")
    private WebElementFacade currentPageNumTest; 	
    
    @FindBy(xpath = "//div[@class='tab-content']/p/ul")
    private WebElementFacade currentPageNumTest2; 	
    
    //@FindBy(xpath = "//div[@class='tab-content']/p/ul/li[(@class='active' or @class='active disabled') and not(contains(@style,'display:none'))]/a")
    
    @FindBy(xpath = "//div[@class='tab-content']//a[@title='Next']")
    private WebElementFacade nextButton;

    public ResourceFinderQuestionPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void answer(ResourceFinderAnswer answer) {
        navigateToSection(answer);

        // Might have scrolled past answer when checking page num
        scrollToTop();

        switch (answer.getAnswerType()) {
            case RADIO:
                clickAnswerButton(answer.getQuestionId(), answer.getAnswer().get(0));
                break;
            case TEXT:
                enterText(answer.getQuestionId(), answer.getAnswer().get(0));
                break;
            case CHECKBOX:
                answer.getAnswer().forEach(s -> clickAnswerButton(answer.getQuestionId(), s));
                break;
            case DROPDOWN:
                selectFromDropdown(answer.getQuestionId(), answer.getAnswer().get(0)); //fix
                break;
            default:
                throw new UnsupportedOperationException("Answer type not supported: " + answer.getAnswerType());
        }
    }

    /**
     * Navigates to correct section and page within that section if not already there
     * @param answer
     */
    private void navigateToSection(ResourceFinderAnswer answer) {
        boolean screenshot = false;
        scrollToTop();
        
        //System.out.println("Sleep 10000"); 
        //sleep(10000);
        //sectionTitle.waitUntilVisible();
        
        System.out.println("Waiting 60 seconds for questionnaire to load");
        WebDriverWait wait = new WebDriverWait(getDriver(), 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='tab-content']/h6[@class='result-header']")));
        
        
        String sectionName = answer.getSection().getSectionTitle();

        // If we're not in right section, navigate to that section
        if (!sectionName.equalsIgnoreCase(sectionTitle.getText())) {
            Serenity.takeScreenshot();
            screenshot = true;

            String sectionNavXpath = String.format(SECTION_NAV_XPATH, formatXpathStringInput(sectionName));
            WebElementFacade sectionNavButton = find(By.xpath(sectionNavXpath));
            sectionNavButton.click();
            sleep(10000);
            System.out.println("section change"); // put a sleep here
        }
        
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        WebElement element = getDriver().findElement(By.xpath("//div[@class='tab-content']/p/ul/li[@class='active' or @class='active disabled']/a"));
        //((WebElementFacade) element).waitUntilVisible();
        String blah = (String) jse.executeScript("return arguments[0].text", element);

        Integer curPageNum =  Integer.parseInt(blah);

        // If we're not on the right page in the section, navigate to that page
        if (!curPageNum.equals(answer.getPageNum())) {
        	
            // If we didn't change section but need to changed page, screenshot before change
            if (!screenshot) Serenity.takeScreenshot();

            String pageNumXpath = String.format(PAGE_NUM_XPATH, answer.getPageNum());
            //WebElementFacade pageNumButton = find(By.xpath(pageNumXpath));
            //pageNumButton.click();

            JavascriptExecutor jse2 = (JavascriptExecutor)getDriver();
            WebElement element2 = getDriver().findElement(By.xpath(pageNumXpath));
            jse2.executeScript("arguments[0].click();", element2);
            sleep(10000);
            System.out.println("page change"); //put sleep 3000 here. or wait til visible?
            
        }

    }

    private void enterText(Integer questionId, String answer) {
        String answerXpath = String.format(TEXT_INPUT_XPATH, questionId);
        WebElementFacade textField = find(By.xpath(answerXpath));
        textField.type(answer);
    }

    private void clickAnswerButton(Integer questionId, String answer) {
        String answerXpath = String.format(ANSWER_BUTTON_XPATH, questionId, formatXpathStringInput(answer));
        WebElementFacade button = find(By.xpath(answerXpath));
        button.click();
    }
    
    private void selectFromDropdown(Integer questionId, String answer) {
        String answerXpath = String.format(DROPDOWN_XPATH, questionId); //fix
        WebElementFacade dropdown = find(By.xpath(answerXpath));
        dropdown.sendKeys(answer);
    }
    
    

    public String getSectionTitle() {
        return sectionTitle.getText();
    }

    public void clickNextButton() {
        nextButton.click();
    }

}