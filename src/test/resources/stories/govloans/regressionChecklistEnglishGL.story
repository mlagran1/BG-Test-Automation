Navigate GL English

Meta:
@feature GL_English

Narrative:
In order to assure that the basic functionality of Govloans.gov is working
As a tester
I want to run the daily regressions at least twice a day


Scenario: (GovLoans) Verify all of the GovLoans sub-navigation tabs open correctly
Meta: @skip
Given the user is on the GovLoans homepage
When the user clicks on the <subNavMenuItem> button within the GovLoans top navigation bar
Then the GovLoans <subNavMenuItem> page should open correctly

Examples:
|subNavMenuItem|
|Loan Finder|
|Browse By Category|
|Other Resources|
|Overview|
|Link To GovLoans.gov|
|FAQs|
|Contact Us|
|Glossary|
|Privacy & Terms of Use|


Scenario: (GovLoans) Verify all of the GovLoans footer links open correctly
Meta: @skip
Given the user is on the GovLoans homepage
When the user clicks on the GovLoans <footerItem> footer link
Then the GovLoans <footerItem> page should open correctly

Examples:
|footerItem|
|Espanol|
|Loan Finder|
|By Category|
|Other Resources|
|Overview|
|Link To GovLoans.gov|
|FAQs|
|Glossary|
|Contact Us|
|Benefits.gov|
|USA.gov|
|Whitehouse.gov|


Scenario: (GovLoans) Verify the Loan Categories on the homepage open correctly
Meta: @skip
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


Scenario: (GovLoans) Verify the homepage links open correctly (non-nav, non-footer, non-loan categories)
Meta: @skip
Given the user is on the GovLoans homepage
When the user clicks on the GovLoans <homepageItem> homepage link
Then the GovLoans <homepageItem> page should open correctly

Examples:
|homepageItem|
|Get Started|
|Loans vs Grants|
|Benefits.gov|


Scenario: (GovLoans) Verify that the home buttons work
Meta: @skip
Given the user is on the GovLoans Overview page
When the user clicks on the GovLoans <homeButton> button
Then the GovLoans homepage should open correctly

Examples:
|homeButton|
|Home Logo|
|Home Nav|


Scenario: (GovLoans) Verify that toggle language button works
Meta: @skip not done
Given the user is on the GovLoans homepage
When the user clicks on the GovLoans toggle language button
Then the user should be taken to the GovLoans Spanish home page
When the user clicks on the GovLoans toggle language button
Then the user should be taken to the GovLoans English home page




