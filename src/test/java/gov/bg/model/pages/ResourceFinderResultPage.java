package gov.bg.model.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://www.benefits.gov/benefits/benefit-finder#results")
public class ResourceFinderResultPage extends ResourceFinderPage {
	    
	//private static final String FAVORITE_BUTTON_XPATH = "//td[./a[" + "text()" +
    //        "=%s]]/div/a[text() = 'Add to Favorites']";
	
    private static final String FAVORITE_BUTTON_XPATH = "(//td[./a[" + "text()" +
                    "=%s]]/div/a)[2]";
        	

    @FindBy(xpath = "//tbody[@id='resultTableBody']/tr/td/a")
    private List<WebElementFacade> resourceTitles;

    public ResourceFinderResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<String> getResourceTitles() {
        return resourceTitles.stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }

    public void addToFavorites(String resourceTitle) {
        scrollToTop();
        String answerXpath = String.format(FAVORITE_BUTTON_XPATH, formatXpathStringInput(resourceTitle));
        //System.out.println("fav button path is: " + FAVORITE_BUTTON_XPATH);
        WebElementFacade button = find(By.xpath(answerXpath));
        //System.out.println("answer path is: " + answerXpath);
        button.click();
    }

}
