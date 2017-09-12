Navigate SSA English

Meta:
@feature SSA_English

Narrative:
In order to assure that the basic functionality of SSABest.benefits.gov is working
As a tester
I want to run the daily regressions at least twice a day


Scenario: (SSABest) Verify all of the SSABest sub-navigation tabs open correctly
Meta: @skip
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
Meta: @skip
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





