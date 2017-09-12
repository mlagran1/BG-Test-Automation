package gov.bg.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://www.benefits.gov/benefits/benefit-finder#mybenefits")
public class ResourceFinderFavoritePage extends ResourceFinderPage {

    @FindBy(xpath = "//tbody[@id='resultTableBody-fav']/tr/td/a")
    
    private List<WebElementFacade> favoriteTitles;

    public ResourceFinderFavoritePage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<String> getFavoriteTitles() {
        return favoriteTitles.stream().map(WebElementFacade::getText).collect(Collectors.toList());
    }
}
