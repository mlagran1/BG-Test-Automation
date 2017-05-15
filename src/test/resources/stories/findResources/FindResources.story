Find Resources

Meta: 
@feature Finder

Narrative:
I want to find benefits that apply to me using the Benefits.gov Questionnaire

Scenario: Find benefits using benefit finder
Given I am on the Benefits.gov benefit finder page
When I enter my <information> into the questionnaire
When I add results from my <information> to my favorites
Then I should see available benefits related to my <information>
Examples:
|information|
|TestCase2.json|
