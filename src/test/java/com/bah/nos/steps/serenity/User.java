package com.bah.nos.steps.serenity;

import com.bah.nos.model.pages.BGPage;
import net.thucydides.core.annotations.Step;



import org.junit.Assert;

public class User {

    BGPage bgPage;

    @Step
    public void onHomePage() {
        bgPage.open();
    }
    
    @Step
	public void open_page(String directoryPath) {
		bgPage.clearCookies();
		
		String url = bgPage.defaultUrl + directoryPath;
		if(bgPage.defaultUrl.contains("staging")) {
			url += "?mobile=unL9HuS";
		}
		
		bgPage.openAt(url);
		
		//System.out.print(directoryPath);
	}
    
    @Step
    public void onBenefitFinderPage() {
        bgPage.openAt("https://www.benefits.gov/benefits/benefit-finder");
        		
    }
    
    
    

    @Step
    public void clickNavNode(String node) {
    	if (node.equals("newsroom")) {
    		bgPage.clickNews(node);
    	} 
    	else if (node.equals("get involved")) {
    		bgPage.clickInvolved(node);
    	}
    	else if (node.equals("help")) {
    		bgPage.clickHelp(node); 
    	}
    	else if (node.equals("about us")) {
    		bgPage.clickAboutUs(node); 
    	}
    	else if (node.equals("browse")) {
    		bgPage.clickBrowse(node);
    	}
    	else if (node.equals("Browse by Category")) {
    		bgPage.clickBrowseByCategory(node);
    	} 
    	else if (node.equals("Browse by State")) {
    		bgPage.clickBrowseByState(node);
    	} 
    	else if (node.equals("Browse by Agency")) {
    		bgPage.clickBrowseByAgency(node);
    	} 
    	else if (node.equals("Other Resources")) {
    		bgPage.clickOtherResources(node);
    	} 
    	
    	else if (node.equals("News & Updates")) {
    		bgPage.clickNewsAndUpdates(node);
    	} 
    	else if (node.equals("Compass eNewsletter")) {
    		bgPage.clickCompassENewsletter(node);
    	} 
    	
    	else if (node.equals("Become an Advocate")) {
    		bgPage.clickBecomeAnAdvocate(node);
    	} 
    	else if (node.equals("Become an Affiliate")) {
    		bgPage.clickBecomeAnAffiliate(node);
    	} 
    	else if (node.equals("Link to Us")) {
    		bgPage.clickLinkToUs(node);
    	} 
    	
    	else if (node.equals("Our Mission")) {
    		bgPage.clickOurMission(node);
    	} 
    	else if (node.equals("Our History")) {
    		bgPage.clickOurHistory(node);
    	} 
    	else if (node.equals("Our Partners")) {
    		bgPage.clickOurPartners(node);
    	} 
    	else if (node.equals("Become a Partner")) {
    		bgPage.clickBecomeAPartner(node);
    	} 
    	else if (node.equals("Our Platform")) {
    		bgPage.clickOurPlatform(node);
    	} 
    	else if (node.equals("Recognition")) {
    		bgPage.clickRecognition(node);
    	} 
    	//Help Nav
    	else if (node.equals("Frequently Asked Questions (FAQS)")) {
    		bgPage.clickFAQs(node);
    	} 
    	else if (node.equals("Contact Us")) {
    		bgPage.clickContactUs(node);
    	} 
    	else if (node.equals("Privacy and Terms of Use")) {
    		bgPage.clickPrivacyAndTermsOfUse(node);
    	} 
    	
    }
    

    
    @Step
    public void clickFooterLink(String link) {
    	if (link.equals("Twitter")) {
    		bgPage.clickTwitter(link);
    	} 
    	else if (link.equals("Facebook")) {
    		bgPage.clickFacebook(link);
    	} 
    	else if (link.equals("Youtube")) {
    		bgPage.clickYoutube(link);
    	} 
    	/*
    	 * else if (link.equals("USA gov")) {
    		bgPage.click(link);
    	} 
    	else if (link.equals("SSABest")) {
    		bgPage.click(link);
    	} 
    	else if (link.equals("Gov Loans")) {
    		bgPage.click(link);
    	} 
    	else if (link.equals("Disaster Assistance")) {
    		bgPage.click(link);
    	} 
    	else if (link.equals("Native One Stop")) {
    		bgPage.click(link);
    	} 
    	 */
    	
    }
    
    @Step
	public void clickBrowseByLink(String link) {
    	if (link.equals("Category")) {
    		bgPage.clickCategoryLink(link);
    	}
    	else if (link.equals("State")) {
    		bgPage.clickStateLink(link);
    	}
    	else if (link.equals("Agency")) {
    		bgPage.clickAgencyLink(link);
    	}
	}
    
  
    
    @Step
    public void clickBrowseNode(String node) {
    	if (node.equals("Browse by Category")) {
    		bgPage.clickBrowseByCategory(node);
    	} 
    	
   }
    
    
    @Step
	public void shouldSeePage(String expectedPageName) {
    	
    	
    	
		String pageTitle = bgPage.pullPageTitle();
		//String subpageTitle = bgPage.pullSubpageTitle(expectedPageName);
		
		System.out.println("page title is: " + pageTitle.toLowerCase());
		System.out.println("expected PageName is: " + expectedPageName.toLowerCase());
		//System.out.println("subpage title is: " + subpageTitle.toLowerCase());
		
		
		switch(expectedPageName) {
		//case "welcome to benefits.gov":
		//case "browse":
			//Assert.assertEquals(pageTitle.toLowerCase(), "Welcome to Benefits.gov sasdfasdf");
			//break;
		case "newsroom": 
			Assert.assertEquals(pageTitle.toLowerCase(), "news & updates");
			break;
		case "help":
			Assert.assertEquals(pageTitle.toLowerCase(), "frequently asked questions (faqs)");
			break;
		//case "Compass eNewsletter":	
			//Assert.assertEquals("April 2017 Compass eNewsletter", pageTitle.toLowerCase());
			//break;	
			
		case "Become an Advocate":
			Assert.assertEquals("become an advocate", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
		case "Become an Affiliate":
			Assert.assertEquals("become an affiliate", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
		case "Link to Us":
			Assert.assertEquals("link to us", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
			
		case "Our Mission":
			Assert.assertEquals("our mission", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
		case "Our History":
			Assert.assertEquals("our history", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
		case "Our Partners":
			Assert.assertEquals("our partners", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
		case "Become a Partner":
			Assert.assertEquals("become a partner", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;	
		case "Our Platform":
			Assert.assertEquals("our platform", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
		case "Recognition":
			Assert.assertEquals("recognition", bgPage.pullSubpageTitle(expectedPageName).toLowerCase());
			break;
	
		case "get involved":
		case "about us":
		
		case "Browse by Category": 
		case "Browse by State":
		case "Browse by Agency":
		case "Other Resources":

		case "News & Updates":
			
		case "Frequently Asked Questions (FAQS)":
		case "Contact Us":
		case "Privacy and Terms of Use":
			

			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			break;
			
		default:
			Assert.assertEquals(expectedPageName.toLowerCase(), pageTitle.toLowerCase());
			System.err.println("INVALID PAGE SENT");
			break;
		} 
	}

}