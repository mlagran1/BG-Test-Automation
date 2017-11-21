package gov.ssa.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import net.thucydides.core.pages.PageObject;

//@DefaultUrl("https://ssabest.benefits.gov")
public class SSAFAQPage extends PageObject {
    
	// *************************************************************************
	//
	private static final String FAQ_QUESTION_XPATH = "(//*[@class='node__title node-title']/a)[%s]";
	
	private String FAQquestion;
	
	// *************************************************************************
	// Functions
	public void clickFAQNode(String questionNum) {

		String faqXpath = String.format(FAQ_QUESTION_XPATH, questionNum.substring(1));
		WebElementFacade faqNode = find(By.xpath(faqXpath));
		
		FAQquestion = faqNode.getText();
		
		faqNode.click();
	}
	
	public String getFAQquestion() {
		return FAQquestion;
	}
	
}