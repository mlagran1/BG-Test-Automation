Navigate

Meta:
@feature Navigate

Narrative:
As a user
I want to be able to navigate around the benefits.gov site
So that I can find the desired site functionality

Scenario: Verify all of the navbar tabs to assert that the pages open correctly
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



Scenario: Verify all of the sub navigation links to assert that the pages open correctly
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
