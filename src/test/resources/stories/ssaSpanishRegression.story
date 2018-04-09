Meta: 
@feature SSABest
@category Spanish

Narrative:
In order to assure that the basic functionality of SSABest.benefits.gov Spanish is working
As a tester
I want to run the daily regressions at least twice a day

Scenario: (SSABest, Spanish) Verify all of the SSABest sub-navigation tabs open correctly
Meta: 
Given the user is on the Spanish SSABest homepage
When the user clicks on the <subNavMenuItem> button within the SSABest top navigation bar
Then the SSABest <subNavMenuItem> page should open correctly

Examples:
|subNavMenuItem|
|Buscador de Beneficios|
|Búsqueda por Categoría|
|Otros recursos|
|Preguntas más frecuentes|
|Contáctenos|
|Privacidad y Términos de Uso|


Scenario: (SSABest, Spanish) Verify all of the SSABest footer links open correctly
Meta: 
Given the user is on the Spanish SSABest homepage
When the user clicks on the SSABest <footerItem> footer link
Then the SSABest <footerItem> page should open correctly

Examples:
|footerItem|
|The White House|
|USA.gov ES|
|Benefits.gov ES|
|Disaster Assistance ES|
|GovLoans ES|
|Privacidad y Términos de Uso|


Scenario: (SSABest, Spanish) Verify the homepage links open correctly (non-nav, non-footer)
Meta: 
Given the user is on the Spanish SSABest homepage
When the user clicks on the SSABest <homepageItem> homepage link
Then the SSABest <homepageItem> page should open correctly

Examples:
|homepageItem|
|Empieza Cuestionario|
|Benefits.gov ES|
|Medicare ES|
|BG Logo ES|
|SSA.gov ES|


Scenario: (SSABest, Spanish) Verify that the home buttons work
Meta: 
Given the user is on the Spanish SSABest FAQ page
When the user clicks on the SSABest <homeButton> button
Then the Spanish SSABest homepage should open correctly

Examples:
|homeButton|
|Home Logo ES|
|Home Nav ES|


Scenario: (SSABest, Spanish) Verify the Browse By Category page functions correctly
Meta: 
Given the user is on the Spanish SSABest Browse By Category page
When the user clicks on the SSABest Browse By <categoryItem> link
Then the SSABest <categoryItem> page should open correctly
When the user clicks on a <categoryItem> benefit
Then the correct SSA benefit page should appear

Examples:
|categoryItem|
|Asistencia por discapacidad|
|Cónyuge y viudo o viuda|
|Jubilación|
|Medicare|
|Seguridad de Ingreso Suplementario|
|Familia|
|Seguros|
|Veteranos|


Scenario: (SSABest, Spanish) Verify that the FAQ page functions correctly
Meta: 
Given the user is on the Spanish SSABest FAQ page
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

