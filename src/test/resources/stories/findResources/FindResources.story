Meta: 
@feature Resource Finder

Narrative:
I want to find benefits that apply to me using the Benefits.gov Questionnaire

Scenario: Find benefits using benefit finder
Meta: @skip
Given I am on the Benefits.gov benefit finder page
When I click the questionnaire button
When I enter my <information> into the questionnaire
When I add results from my <information> to my favorites
Then I should see available benefits related to my <information>

Examples:
|information|
|TestCase1.json|


Scenario: Find benefits using Spanish benefit finder
Meta: @skip
Given I am on the Spanish Benefits.gov benefit finder page
When I enter my <information> into the questionnaire
When I add results from my <information> to my favorites
Then I should see available benefits related to my <information>

Examples:
|information|
|TestCaseSpanish.json|







