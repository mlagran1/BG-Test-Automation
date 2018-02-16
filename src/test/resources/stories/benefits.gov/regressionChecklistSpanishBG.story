Meta: 
@feature BG Spanish

Narrative:
In order to assure that the basic functionality of Benefits.gov Spanish is working
As a tester
I want to run the daily regressions at least twice a day


Scenario: (Benefits, Spanish) Verify all of the navigation tabs open correctly
Meta:                          
Given the user is on the Spanish Benefits home page
When the user clicks on <navMenuItem> within the top navigation bar
Then the <navMenuItem> page should open correctly

Examples:
|navMenuItem|
|Sala de Prensa|
|Involúcrese|
|Sobre Nosotros|
|Ayuda|


Scenario: (Benefits, Spanish) Verify all of the sub-navigation tabs open correctly
Meta: 
Given the user is on the Spanish Benefits home page
When the user clicks on the <subNavMenuItem> within the top navigation bar
Then the <subNavMenuItem> page should open correctly

Examples:
|subNavMenuItem|
|Búsqueda por categoría|
|Búsqueda por estado|
|Búsqueda por agencia|
|Otros recursos|

|Noticias & Actualizaciones|

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


Scenario: (Benefits, Spanish) Verify all of the browse by buttons open correctly
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


Scenario: (Benefits, Spanish) Verify all of the footer links open correctly
Meta: 
Given the user is on the Spanish Benefits home page
When the user clicks on the <footerLink> within the homepage
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


Scenario: (Benefits, Spanish) Verify personalization functions correctly
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


Scenario: (Benefits, Spanish) Verify FAQ page functions correctly
Meta: 
Given the user is on the Spanish Benefits FAQ page
When the user clicks on the expand button
Then the answer text should show
When the user clicks on the minimize button
Then the answer text should be hidden


Scenario: (Benefits, Spanish) Verify that the home button works
Meta: 
Given the user is on the Spanish Benefits home page
Then the Spanish home page title should show
When the user clicks on the Spanish home button
Then the user should be taken to the Spanish home page


Scenario: (Benefits, Spanish) Verify the Browse by pages
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


Scenario: (Benefits, Spanish) Verify the Other Resources page filter toggle
Meta: 
Given the user is on the Spanish Other Resources page
When the user clicks on the minimize filter button
Then the filter should disappear
When the user clicks on the expand filter button
Then the filter should reappear


Scenario: (Benefits, Spanish) Verify the Other Resources page filter by type
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


Scenario: (Benefits, Spanish) Verify the Other Resources page filter by state
Meta: 
Given the user is on the Spanish Other Resources page
When the user filters by state <filterByState>
Then the correct Spanish group headings for state <filterByState> should appear

Examples:
|filterByState|
|Alaska|
|-TODAS-|
|Nevada|


Scenario: (Benefits, Spanish) Verify the Other Resources page filter by all categories
Meta: 
Given the user is on the Spanish Other Resources page
When the user filters by all categories
Then the correct Spanish group headings for categories should appear


Scenario: (Benefits, Spanish) Verify the News & Updates click article
Meta: 
Given the user is on the Spanish News & Updates page
Then the user should see five news articles
When the user clicks on article <articleNum>
Then the user should be taken to the correct article

Examples:
|articleNum|
|1|
|2|


Scenario: (Benefits, Spanish) Verify the News & Updates click read more
Meta: 
Given the user is on the Spanish News & Updates page
Then the user should see five news articles
When the user clicks on article <articleNum> read more
Then the user should be taken to the correct article

Examples:
|articleNum|
|1|
|2|


Scenario: (Benefits, Spanish) Verify the News & Updates navigation buttons
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


Scenario: (Benefits, Spanish) Verify the News & Updates page filter by news type works
Meta: 
Given the user is on the Spanish News & Updates page
When the user filters by news type <filterByType>
Then the correct articles for news type <filterByType> should appear on the page

Examples:
|filterByType|
|Noticia destacada|
|Artículo de Compass|


Scenario: (Benefits, Spanish) Verify the News & Updates page filter by benefit category works
Meta: 
Given the user is on the Spanish News & Updates page
When the user filters by benefit category <benefitCategory>
Then the correct articles for benefit category <benefitCategory> should appear on the page

Examples:
|benefitCategory|
|Cuidado infantil/Manutención|


Scenario: (Benefits, Spanish) Verify the Compass Newsletter click article
Meta: 
Given the user is on the Spanish Compass Newsletter page
Then the user should see the correct number of compass articles
When the user clicks on compass article <articleNum>
Then the user should be taken to the correct compass article

Examples:
|articleNum|
|1|
|2|


Scenario: (Benefits, Spanish) Verify the Compass Newsletter click read more
Meta: 
Given the user is on the Spanish Compass Newsletter page
When the user clicks on compass article <articleNum> read more
Then the user should be taken to the correct compass article

Examples:
|articleNum|
|1|
|2|


Scenario: (Benefits, Spanish) Verify the home page slider
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


