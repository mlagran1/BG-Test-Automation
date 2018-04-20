Meta: @skip
@feature SSABest
@category English

Narrative:
In order to assure that the basic functionality of SSABest.benefits.gov is working
As a tester
I want to run the daily regressions at least twice a day

Scenario: (SSABest) Homepage - Header - All the sub-navigation links (6 examples)
Meta: @skip @failed
Given the user is on the SSABest homepage
When the user clicks on the <subNavMenuItem> button in the SSABest top navigation bar (android)
Then the SSABest <subNavMenuItem> page should open correctly

Examples:
|subNavMenuItem|
|SSA Best Questionnaire|
|Browse By Category|
|Other Resources|
|FAQs|
|Contact Us|
|Privacy & Terms of Use|
|SSA.gov|
|Home Nav|


Scenario: (SSABest) Homepage - Footer - All the links open (6 examples)
Meta: @skip @passed
Given the user is on the SSABest homepage
When the user clicks on the SSABest <footerItem> footer link (android)
Then the SSABest <footerItem> page should open correctly

Examples:
|footerItem|
|The White House|
|USA.gov|
|Benefits.gov|
|Disaster Assistance|
|GovLoans|
|Privacy & Terms of Use|


Scenario: (SSABest) Homepage - Main Content Block - All the links open (5 examples)
Meta: @skip @passed
Given the user is on the SSABest homepage
When the user clicks on the SSABest <homepageItem> homepage link
Then the SSABest <homepageItem> page should open correctly

Examples:
|homepageItem|
|Start Questionnaire|
|Benefits.gov|
|Help With Medicare|
|BG Logo|


Scenario: (SSABest) Homepage - Verify home buttons (2 examples)
Meta: @skip @passed
Given the user is on the SSABest FAQ page
When the user clicks on the SSABest <homeButton> button
Then the SSABest homepage should open correctly

Examples:
|homeButton|
|Home Logo|


Scenario: (SSABest) Homepage - Verify the toggle language button
Meta: @skip @passed
Given the user is on the SSABest homepage
When the user clicks on the SSABest toggle language button
Then the user should be taken to the SSABest Spanish homepage
When the user clicks on the SSABest toggle language button
Then the user should be taken to the SSABest English homepage


Scenario: (SSABest) Browse By Category - All the category links open (8 examples)
Meta: @skip @passed
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


Scenario: (SSABest) FAQ Page - All the question links open
Meta: @skip @passed
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

