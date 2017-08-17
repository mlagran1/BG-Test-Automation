Navigate BG English

Meta: 
@feature BG_English

Narrative:
In order to assure that the basic functionality of benefits.gov is working
As a tester
I want to run the daily regressions at least twice a day


Scenario: Verify all of the navigation tabs open correctly
Meta: 
Given the user is on the Benefits home page
When the user clicks on <navMenuItem> within the top navigation bar
Then the <navMenuItem> page should open correctly

Examples:
|navMenuItem|
|newsroom|
|get involved|
|about us|
|help|


Scenario: Verify all of the sub-navigation tabs open correctly
Meta: 
Given the user is on the Benefits home page
When the user clicks on the <subNavMenuItem> within the top navigation bar
Then the <subNavMenuItem> page should open correctly

Examples:
|subNavMenuItem|
|Browse by Category|
|Browse by State|
|Browse by Agency|
|Other Resources|

|News & Updates|

|Become an Advocate|
|Become an Affiliate|
|Link to Us|

|Our Mission|
|Our History|
|Our Partners|
|Become a Partner|
|Our Platform|
|Recognition|

|Frequently Asked Questions (FAQS)|
|Contact Us|
|Privacy and Terms of Use|


Scenario: Verify all of the browse by buttons open correctly
Meta: 
Given the user is on the Benefits home page
When the user clicks on the <browseByItem> on the homepage
Then the <browseByItem> page should open correctly

Examples:
|browseByItem|
|Browse by Category|
|Browse by State|
|Benefit Finder|
|Browse by Agency|


Scenario: Verify all of the footer links open correctly
Meta: 
Given the user is on the Benefits home page
When the user clicks on the <footerLink> within the homepage
Then the <footerLink> page should open correctly

Examples:
|footerLink|
|Twitter|
|Facebook|
|Youtube|
|White House|
|USA.gov|
|SSABest|
|GovLoans|
|Disaster Assistance|


Scenario: Verify personalization functions correctly
Meta: 
Given the user is on the Benefits home page
When the user clicks on the change location button
Then the Enter State or Territory text field should show
When the user enters a <stateOrTerritory> in the text field
Then the correct <stateOrTerritory> should show
Then the correct benefits should show

Examples:
|stateOrTerritory|
|Florida|
|California|


Scenario: Verify FAQ page functions correctly
Meta: 
Given the user is on the Benefits FAQ page
When the user clicks on the expand button
Then the answer text should show
When the user clicks on the minimize button
Then the answer text should be hidden


Scenario: Verify that the home button works
Meta: 
Given the user is on the Benefits home page
Then the home page title should show
When the user clicks on the home button
Then the user should be taken to the home page


Scenario: Verify that toggle language button works
Meta: 
Given the user is on the Benefits home page
When the user clicks on the toggle language button
Then the user should be taken to the Spanish home page
When the user clicks on the toggle language button
Then the user should be taken to the English home page


Scenario: Verify the Browse by pages
Meta: 
Given the user is on the Browse by <browseByItem> page
When the user clicks on a category
Then the correct category page should appear
When the user clicks on a benefit
Then the correct benefit page should appear

Examples:
|browseByItem|
|category|
|state|
|agency|


Scenario: Verify the Other Resources page filter toggle
Meta: 
Given the user is on the Other Resources page
When the user clicks on the minimize filter button
Then the filter should disappear
When the user clicks on the expand filter button
Then the filter should reappear


Scenario: Verify the Other Resources page filter by type
Meta: 
Given the user is on the Other Resources page
When the user filters by type <filterByType>
Then the correct group headings for type <filterByType> should appear

Examples:
|filterByType|
|Federal|
|State|
|-ANY-|
|Other|


Scenario: Verify the Other Resources page filter by state
Meta: 
Given the user is on the Other Resources page
When the user filters by state <filterByState>
Then the correct group headings for state <filterByState> should appear

Examples:
|filterByState|
|Alaska|
|-ANY-|
|Nevada|


Scenario: Verify the Other Resources page filter by all categories
Meta: 
Given the user is on the Other Resources page
When the user filters by all categories
Then the correct group headings for categories should appear


Scenario: Verify the News & Updates click article
Meta: 
Given the user is on the News & Updates page
Then the user should see five news articles
When the user clicks on article <articleNum>
Then the user should be taken to the correct article

Examples:
|articleNum|
|1|
|2|

Scenario: Verify the News & Updates click read more
Meta: 
Given the user is on the News & Updates page
Then the user should see five news articles
When the user clicks on article <articleNum> read more
Then the user should be taken to the correct article

Examples:
|articleNum|
|1|
|2|

Scenario: Verify the News & Updates navigation buttons
Meta: 
Given the user is on the News & Updates page
When the user clicks on the next button
Then the user should be taken to the next page
When the user clicks on the previous button
Then the user should be taken to the previous page
When the user clicks on the last button
Then the user should be taken to the last page
When the user clicks on the first button
Then the user should be taken to the first page


Scenario: Verify the News & Updates page filter by news type works
Meta: 
Given the user is on the News & Updates page
When the user filters by news type <filterByType>
Then the correct articles for news type <filterByType> should appear on the page

Examples:
|filterByType|
|News Article|
|Compass Article|


Scenario: Verify the News & Updates page filter by benefit category works
Meta: 
Given the user is on the News & Updates page
When the user filters by benefit category <benefitCategory>
Then the correct articles for benefit category <benefitCategory> should appear on the page

Examples:
|benefitCategory|
|Child Care/Child Support|


Scenario: Verify the Compass Newsletter click article
Meta: 
Given the user is on the Compass Newsletter page
Then the user should see the correct number of compass articles
When the user clicks on compass article <articleNum>
Then the user should be taken to the correct compass article

Examples:
|articleNum|
|1|
|2|


Scenario: Verify the Compass Newsletter click read more
Meta: 
Given the user is on the Compass Newsletter page
When the user clicks on compass article <articleNum> read more
Then the user should be taken to the correct compass article

Examples:
|articleNum|
|1|
|2|


Scenario: Verify the home page slider
Meta: 
Given the user is on the Benefits home page
When the user clicks on slider tile <sliderNum>
Then the slider page should open correctly

Examples:
|sliderNum|

|1|
|2|
|3|
|4|
|5|
|6|

