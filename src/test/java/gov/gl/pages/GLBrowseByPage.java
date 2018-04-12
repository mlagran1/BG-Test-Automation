package gov.gl.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.WebElementFacade;


import net.thucydides.core.pages.PageObject;

public class GLBrowseByPage extends PageObject {
    
	// *************************************************************************
	// browse by category tests
	
	public List<WebElement> loanDetailNodes() {
		return this.getDriver().findElements(By.xpath("//*[@class='browse-by-header']/a"));
	}

	private static final String CATEGORY_TITLE_XPATH = "//*[@class='browse-by-category']/a[contains(text(),'%s')]";
	private static final String LOAN_TITLE_XPATH = "(//*[@class='browse-by-header']/a)[%s]";

	private String loanTitle;
	
	// *************************************************************************
	// Functions
	public void clickCategoryTitle(String category) {

		String categoryXpath = String.format(CATEGORY_TITLE_XPATH, category);		
		WebElementFacade categoryNode = find(By.xpath(categoryXpath));
		
		categoryNode.click();
	}

	// clicks a random loan from that category page
	public void clickLoanTitle() {
		List<WebElement> loans = loanDetailNodes();
		int random = (int) (Math.random() * loans.size() + 1);

		String loanXpath = String.format(LOAN_TITLE_XPATH, random);
		WebElementFacade loanNode = find(By.xpath(loanXpath));

		loanTitle = loanNode.getText();
		loanNode.click();
	}

	// returns the loan title variable clicked that we set in the clickLoanTitle method
	public String getLoanTitle() {
		return loanTitle;
	}
	
}