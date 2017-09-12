Test Feature

Meta: @skip
@feature Test Feature
@categories testFilter

Narrative:
As a user
I want to test features on the benefits.gov site
So that I can find the desired site functionality


Scenario: Verify the Compass Newsletter click tabs
Meta: @skip
Given the user is on the Compass Newsletter page
When the user clicks on compass article tab <articleNum>
Then the user should see the correct compass article

Examples:
|articleNum|
|2|
|3|
|4|
|5|
|6|
|7|




