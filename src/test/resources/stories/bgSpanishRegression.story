Meta: @skip
@feature Benefits
@category Spanish

Narrative:
In order to assure that the basic functionality of Benefits.gov Spanish is working
As a tester
I want to run the daily regressions at least twice a day


Scenario: (Benefits, Spanish) Homepage - Header - All the main navigation links (5 examples)
Meta:                          
Given the user is on the Spanish Benefits home page
When the user clicks on <navMenuItem> in the top navigation bar
Then the <navMenuItem> page should open correctly

Examples:
|navMenuItem|
|Búsqueda|
|Sala de Prensa|
|Involúcrese|
|Sobre Nosotros|
|Ayuda|


Scenario: (Benefits, Spanish) Homepage - Header - All the sub-navigation links (18 examples)
Meta: 
Given the user is on the Spanish Benefits home page
When the user clicks on the <subNavMenuItem> in the top navigation bar
Then the <subNavMenuItem> page should open correctly

Examples:
|subNavMenuItem|
|Búsqueda por categoría|
|Búsqueda por estado|
|Búsqueda por agencia federal|
|Otros recursos|

|Noticias & Actualizaciones|
|Compass el boletín electrónico (en inglés)|

|Conviértase en un Representante|
|Conviértase en un Afiliado|
|Enlace su sitio al nuestro|

|Nuestra Misión|
|Nuestra Historia|
|Nuestros Socios|
|Conviértase en un socio|
|Nuestra Plataforma|
|Reconocimiento|

|Preguntas comunes|
|Contáctenos|
|Privacidad y Términos de Uso|


Scenario: (Benefits, Spanish) Homepage - "Looking for Benefits" - All the Browse for Benefits links (4 examples)
Meta: 
Given the user is on the Spanish Benefits home page
When the user clicks on the <browseByItem> on the homepage
Then the <browseByItem> page should open correctly

Examples:
|browseByItem|
|Búsqueda por categoría|
|Búsqueda por estado|
|Buscador de Beneficios|
|Búsqueda por agencia|


Scenario: (Benefits, Spanish) Homepage - Footer - All the links open (8 examples)
Meta: 
Given the user is on the Spanish Benefits home page
When the user clicks on the <footerLink> on the homepage
Then the <footerLink> page should open correctly

Examples:
|footerLink|
|Twitter|
|Facebook|
|Youtube|
|White House|
|USA.gov|
|SSABest ES|
|GovLoans ES|
|Disaster Assistance ES|


Scenario: (Benefits, Spanish) Homepage - "Discover Popular Benefits" - Personalization functions correctly
Meta: 
Given the user is on the Spanish Benefits home page
When the user clicks on the change location button
Then the Enter State or Territory text field should show
When the user enters a <stateOrTerritory> in the text field
Then the correct <stateOrTerritory> should show
Then the correct benefits should show

Examples:
|stateOrTerritory|
|Florida|
|California|


Scenario: (Benefits, Spanish) Homepage - "News & Updates" - Verify the slider links (6 examples)
Meta: 
Given the user is on the Spanish Benefits home page
When the user clicks on slider tile <sliderNum>
Then the Spanish slider page should open correctly

Examples:
|sliderNum|
|1|
|2|
|3|
|4|
|5|
|6|


Scenario: (Benefits, Spanish) "Browse By" Pages - Verify Category, State, and Agency
Meta: 
Given the user is on the Spanish Browse by <browseByItem> page
When the user clicks on a category
Then the correct category page should appear
When the user clicks on a benefit
Then the correct benefit page should appear

Examples:
|browseByItem|
|category|
|state|
|agency|


Scenario: (Benefits, Spanish) Other Resources - Verify filter by type
Meta: 
Given the user is on the Spanish Other Resources page
When the user filters by type <filterByType>
Then the correct Spanish group headings for type <filterByType> should appear

Examples:
|filterByType|
|Federal|
|Estado|
|-TODAS-|
|Otro|


Scenario: (Benefits, Spanish) Other Resources - Verify filter by state
Meta: 
Given the user is on the Spanish Other Resources page
When the user filters by state <filterByState>
Then the correct Spanish group headings for state <filterByState> should appear

Examples:
|filterByState|
|Alaska|
|-TODAS-|
|Nevada|


Scenario: (Benefits, Spanish) News & Updates - All article title links open
Meta: 
Given the user is on the Spanish News & Updates page
Then the user should see five news articles
When the user clicks on article <articleNum>
Then the user should be taken to the correct article

Examples:
|articleNum|
|1|
|2|
|3|
|4|
|5|


Scenario: (Benefits, Spanish) News & Updates - Verify navigation buttons
Meta: 
Given the user is on the Spanish News & Updates page
When the user clicks on the next button
Then the user should be taken to the next page
When the user clicks on the previous button
Then the user should be taken to the previous page
When the user clicks on the last button
Then the user should be taken to the Spanish last page
When the user clicks on the first button
Then the user should be taken to the first page


Scenario: (Benefits, Spanish) News & Updates - Verify filter by news type
Meta: 
Given the user is on the Spanish News & Updates page
When the user filters by news type <filterByType>
Then the correct articles for news type <filterByType> should appear on the page

Examples:
|filterByType|
|Noticia destacada|
|Artículo de Compass|


Scenario: (Benefits, Spanish) News & Updates - Verify filter by benefit category
Meta: 
Given the user is on the Spanish News & Updates page
When the user filters by benefit category <benefitCategory>
Then the correct articles for benefit category <benefitCategory> should appear on the page

Examples:
|benefitCategory|
|Cuidado infantil/Manutención|


Scenario: (Benefits, Spanish) Compass eNewsLetter - All article title links open
Meta: 
Given the user is on the Spanish Compass Newsletter page
Then the user should see the correct number of compass articles
When the user clicks on compass article <articleNum>
Then the user should be taken to the correct compass article

Examples:
|articleNum|
|1|
|2|
|3|
|4|
|5|
|6|


Scenario: (Benefits, Spanish) FAQ Page - All the question tabs expand
Meta: 
Given the user is on the Spanish Benefits FAQ page
When the user clicks on the expand button
Then the answer text should show
When the user clicks on the minimize button
Then the answer text should be hidden





