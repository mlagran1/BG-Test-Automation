Meta: 
@feature SSABest
@category English

Narrative:
In order to assure that the basic functionality of SSABest.benefits.gov is working
As a tester
I want to run the daily regressions at least twice a day

Scenario: (SSABest) Verify all of the SSABest sub-navigation tabs open correctly
Meta: 
Given the user is on the SSABest homepage
When the user clicks on the <subNavMenuItem> button within the SSABest top navigation bar
Then the SSABest <subNavMenuItem> page should open correctly

Examples:
|subNavMenuItem|
|SSA Best Questionnaire|
|Browse By Category|
|Other Resources|
|FAQs|
|Contact Us|
|Privacy & Terms of Use|


Scenario: (SSABest) Verify all of the SSABest footer links open correctly
Meta: 
Given the user is on the SSABest homepage
When the user clicks on the SSABest <footerItem> footer link
Then the SSABest <footerItem> page should open correctly

Examples:
|footerItem|
|The White House|
|USA.gov|
|Benefits.gov|
|Disaster Assistance|
|GovLoans|
|Privacy & Terms of Use|


Scenario: (SSABest) Verify the homepage links open correctly (non-nav, non-footer)
Meta: 
Given the user is on the SSABest homepage
When the user clicks on the SSABest <homepageItem> homepage link
Then the SSABest <homepageItem> page should open correctly

Examples:
|homepageItem|
|Start Questionnaire|
|Benefits.gov|
|Help With Medicare|
|BG Logo|
|SSA.gov|


Scenario: (SSABest) Verify that the home buttons work
Meta: 
Given the user is on the SSABest FAQ page
When the user clicks on the SSABest <homeButton> button
Then the SSABest homepage should open correctly

Examples:
|homeButton|
|Home Logo|
|Home Nav|


Scenario: (SSABest) Verify that toggle language button works
Meta: 
Given the user is on the SSABest homepage
When the user clicks on the SSABest toggle language button
Then the user should be taken to the SSABest Spanish homepage
When the user clicks on the SSABest toggle language button
Then the user should be taken to the SSABest English homepage


Scenario: (SSABest) Verify the Browse By Category page functions correctly
Meta: 
Given the user is on the SSABest Browse By Category page
When the user clicks on the SSABest Browse By <categoryItem> link
Then the SSABest <categoryItem> page should open correctly
When the user clicks on a <categoryItem> benefit
Then the correct SSA benefit page should appear

Examples:
|categoryItem|
|Family|
|Disability Assistance|
|Insurance|
|Medicare|
|Retirement|
|Spouse & Widow(er)|
|Supplemental Security Income|
|Veterans|



Scenario: (SSABest) Verify that the FAQ page functions correctly
Meta: 
Given the user is on the SSABest FAQ page
When the user clicks on the SSABest FAQ <questionNum> link
Then the FAQ <questionNum> page should open correctly

Examples:
|questionNum|
|Q1|
|Q2|
|Q3|
|Q4|
|Q5|
|Q6|
|Q7|
|Q8|
|Q9|
|Q10|

