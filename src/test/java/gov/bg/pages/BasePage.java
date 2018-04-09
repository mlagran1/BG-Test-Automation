package gov.bg.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DefaultUrl("https://www.benefits.gov")
public class BasePage extends PageObject {

    private static final Logger log = LoggerFactory.getLogger(BasePage.class);

    // -------- Xpath Functions --------

    protected static final String XPATH_TO_UPPERCASE =
            "translate(%s,'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ')";
    // -------- Navigation xpath components --------


    @FindBy(xpath = "//*[@id='page-title']")
    private WebElementFacade pageTitle;
    
    @FindBy(xpath = "//*[@class='field-item even']")
    private WebElementFacade subpageTitle;

    public BasePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }
    
    public String getSubpageTitle() {
        return subpageTitle.getText();
    }

    protected void sleep(long duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            log.error("Sleep interrupted");
        }
    }

    /**
     * This is only necessary because scroll to element that is called automatically puts some objects
     * behind the page header
     */
    protected void scrollToTop() {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0,0);");
        sleep(500);
    }

    /**
     * Format input to xPath statement
     * Wraps all inputs with single quotes (') in a concat statement using double quotes
     * http://www.seleniumtests.com/2010/08/xpath-and-single-quotes.html
     * @param input the string to be verified and changed if necessary - comparison string not wrapped in quotes
     * @return formatted string wrapped in single quotes if no xPath function necessary,
     *         xPath function if input contains a single quote
     */
    protected String formatXpathStringInput(String input) {
        StringBuilder result = new StringBuilder();

        if (input.contains("'")) {
            result.append("concat(\"");
            result.append(input.replaceAll("'", "\", \"'\", \""));
            result.append("\")");
        } else {
            result.append("'");
            result.append(input);
            result.append("'");
        }

        return result.toString();
    }

}

