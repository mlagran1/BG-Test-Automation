Meta: @skip
@feature Govloans
@category English

Narrative:
In order to assure that the basic functionality of Govloans.gov is working
As a tester
I want to run the daily regressions at least twice a day


Scenario: (GovLoans) Homepage - Header - All the sub-navigation links (9 examples)
Meta: @skip @passed
Given the user is on the GovLoans homepage
When the user clicks on the <subNavMenuItem> button in the GovLoans top navigation bar (android)
Then the GovLoans <subNavMenuItem> page should open correctly (android)

Examples:
|subNavMenuItem|
|Home Nav|
|Loan Finder|
|Browse By Category|
|Other Resources|
|Overview|
|Link To GovLoans.gov|
|FAQs|
|Contact Us|
|Glossary|
|Privacy & Terms of Use|


Scenario: (GovLoans) Homepage - Footer - All the links open (13 examples)

Meta: @skip @passed
Given the user is on the GovLoans homepage
When the user clicks on the GovLoans <footerItem> footer link (android)
Then the GovLoans <footerItem> page should open correctly

Examples:
|footerItem|
|Contact Us|
|Benefits.gov|
|USA.gov|
|Whitehouse.gov|
|Privacy & Terms of Use|


Scenario: (GovLoans) Homepage - "Loan Categories" - All the category links open (6 examples)
Meta:@skip @passed
Given the user is on the GovLoans homepage
When the user clicks on the GovLoans <categoryItem> category link
Then the GovLoans <categoryItem> page should open correctly

Examples:
|categoryItem|
|Agriculture|
|Business|
|Disaster Relief|
|Education|
|Housing|
|Veteran|



Scenario: (GovLoans) Homepage - Main Content Block - All the links open (3 examples)
Meta: @skip @passed
Given the user is on the GovLoans homepage
When the user clicks on the GovLoans <homepageItem> homepage link
Then the GovLoans <homepageItem> page should open correctly

Examples:
|homepageItem|
|Get Started|
|Loans vs Grants|
|Benefits.gov|


Scenario: (GovLoans) Homepage - Verify home buttons (2 examples)
Meta: @skip @passed
Given the user is on the GovLoans Overview page
When the user clicks on the GovLoans <homeButton> button
Then the GovLoans homepage should open correctly

Examples:
|homeButton|
|Home Logo|


Scenario: (GovLoans) Homepage - Verify the toggle language button
Meta: @skip @passed
Given the user is on the GovLoans homepage
When the user clicks on the GovLoans toggle language button ES(android)
Then the user should be taken to the GovLoans Spanish homepage (android)
When the user clicks on the GovLoans toggle language button EN(android)
Then the user should be taken to the GovLoans English homepage


Scenario: (GovLoans) Browse By Category - All the category links open (7 examples)
Meta: @skip @passed
Given the user is on the GovLoans Browse By Category page
When the user clicks on the GovLoans Browse By <categoryItem> link
Then the GovLoans <categoryItem> page should open correctly
When the user clicks on a loan
Then the correct loan page should appear

Examples:
|categoryItem|
|Agriculture|
|Business|
|Disaster Relief|
|Education|
|General|
|Housing|
|Veteran|





