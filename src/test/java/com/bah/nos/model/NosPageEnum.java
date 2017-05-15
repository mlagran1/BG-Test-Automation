package com.bah.nos.model;

import com.bah.nos.model.pages.HomePage;
import com.bah.nos.model.pages.NosBasePage;
import com.bah.nos.model.pages.ResourceFinderQuestionPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum NosPageEnum {
    BROWSE("Welcome to Benefits.gov", new ArrayList<>(Arrays.asList("Browse")), HomePage.class),
    //FINDER("Benefit Finder", new ArrayList<>(Arrays.asList("Benefits", "Benefits,Benefit Finder")), ResourceFinderQuestionPage.class),
    
    CATEGORY("Browse by Category", new ArrayList<>(Arrays.asList("Browse", "Browse,Browse by Category"))),
    STATE("Browse by State", new ArrayList<>(Arrays.asList("Browse,Browse by State"))),
    AGENCY("Browse by Agency", new ArrayList<>(Arrays.asList("Browse,Browse by Agency"))),
    OTHER_RESOURCES("Other Resources", new ArrayList<>(Arrays.asList("Browse,Other Resources"))),
    
    NEWS_UPDATES("News & Updates", new ArrayList<>(Arrays.asList("NEWSROOM", "NEWSROOM,News and Updates"))),
    COMPASS("April 2017 Compass eNewsletter", new ArrayList<>(Arrays.asList("NEWSROOM,Compass eNewsletter"))),
    
    BECOME_ADVOCATE_SUBNAV("Become an Advocate", new ArrayList<>(Arrays.asList("GET INVOLVED", "GET INVOLVED,Become an Advocate"))),
    BECOME_AFFILIATE_SUBNAV("Become an Affiliate", new ArrayList<>(Arrays.asList("GET INVOLVED,Become an Affliliate"))), 																				
    LINK_TO_US("Link to Us", new ArrayList<>(Arrays.asList("GET INVOLVED,Link to Us"))),
    
    //OUR_MISSION("Our Mission", new ArrayList<>(Arrays.asList("About Us,Our Mission"))),
    //OUR_HISTORY("Our History", new ArrayList<>(Arrays.asList("About Us,Our History"))),
    //OUR_PARTNERS("Our Partners", new ArrayList<>(Arrays.asList("About Us,Our Partners"))),
    //BECOME_PARTNER("Become a Partner", new ArrayList<>(Arrays.asList("About Us,Become a Partner"))),
    //OUR_PLATFORM("Our Platform", new ArrayList<>(Arrays.asList("About Us,Our Platform"))),
    //RECOGNITION("Recognition", new ArrayList<>(Arrays.asList("About Us,Recognition"))),
    
    FAQ("Frequently Asked Questions (FAQS)", new ArrayList<>(Arrays.asList("HELP", "HELP,FAQs"))),
    CONTACT_US("Contact Us", new ArrayList<>(Arrays.asList("HELP,Contact Us"))),
    PRIVACY("Privacy and Terms of Use", new ArrayList<>(Arrays.asList("HELP,Privacy and Terms of Use")));
	
	
    private String pageTitle;
    private List<String> navPathList;
    private Class<? extends NosBasePage> pageClass;

    NosPageEnum(String pageTitle, List<String> navPathList, Class<? extends NosBasePage> pageClass) {
        this.pageTitle = pageTitle;
        this.navPathList = navPathList;
        this.pageClass = pageClass;
    }

    NosPageEnum(String pageTitle, List<String> navTitleList) {
        this(pageTitle, navTitleList, NosBasePage.class);
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public List<String> getNavPathList() {
        return navPathList;
    }

    public Class<? extends NosBasePage> getPageClass() {
        return pageClass;
    }

    public static NosPageEnum getPageByNavPath(String navPath) {
        for (NosPageEnum page : NosPageEnum.values()) {
            for (String curNavPath : page.getNavPathList()) {
                if (curNavPath.equalsIgnoreCase(navPath)) {
                    return page;
                }
            }
        }

        throw new EnumConstantNotPresentException(NosPageEnum.class, navPath);
    }

}