Meta: 
@feature GL Spanish

Narrative:
In order to assure that the basic functionality of Govloans.gov Spanish is working
As a tester
I want to run the daily regressions at least twice a day


Scenario: (GovLoans, Spanish) Verify all of the GovLoans sub-navigation tabs open correctly
Meta: 
Given the user is on the Spanish GovLoans homepage
When the user clicks on the <subNavMenuItem> button within the GovLoans top navigation bar
Then the GovLoans <subNavMenuItem> page should open correctly

Examples:
|subNavMenuItem|
|Buscador de Préstamos|
|Búsqueda por Categoría|
|Otros Recursos|
|Visión General|
|Vínculo a GovLoans.gov|
|Preguntas más frecuentes|
|Contáctenos|
|Glosario|
|Privacidad y Términos de Uso|


Scenario: (GovLoans, Spanish) Verify all of the GovLoans footer links open correctly
Meta: 
Given the user is on the Spanish GovLoans homepage
When the user clicks on the GovLoans <footerItem> footer link
Then the GovLoans <footerItem> page should open correctly

Examples:
|footerItem|
|English|
|Buscador de Préstamos|
|Búsqueda por Categoría|
|Otros Recursos|
|Visión General|
|Vínculo a GovLoans.gov|
|Preguntas más frecuentes|
|Glosario|
|Contáctenos|
|Benefits.gov ES|
|USA.gov ES|
|Whitehouse.gov|
|Privacidad y Términos de Uso|


Scenario: (GovLoans, Spanish) Verify the Loan Categories on the homepage open correctly
Meta: 
Given the user is on the Spanish GovLoans homepage
When the user clicks on the GovLoans <categoryItem> category link
Then the GovLoans <categoryItem> page should open correctly

Examples:
|categoryItem|
|Agrícolas|
|Empresariales|
|Alivio de Desastre|
|Educación|
|Vivienda|
|Veteranos|


Scenario: (GovLoans, Spanish) Verify the homepage links open correctly (non-nav, non-footer, non-loan categories)
Meta: 
Given the user is on the Spanish GovLoans homepage
When the user clicks on the GovLoans <homepageItem> homepage link
Then the GovLoans <homepageItem> page should open correctly

Examples:
|homepageItem|
|Empezar|
|Préstamos vs Subvenciones|
|Benefits.gov ES|


Scenario: (GovLoans, Spanish) Verify that the home buttons work
Meta: 
Given the user is on the Spanish GovLoans Overview page
When the user clicks on the GovLoans <homeButton> button
Then the Spanish GovLoans homepage should open correctly

Examples:
|homeButton|
|Home Logo ES|
|Home Nav ES|


Scenario: (GovLoans, Spanish) Verify the Browse By Category page functions correctly
Meta: 
Given the user is on the Spanish GovLoans Browse By Category page
When the user clicks on the GovLoans Browse By <categoryItem> link
Then the GovLoans <categoryItem> page should open correctly
When the user clicks on a loan
Then the correct loan page should appear

Examples:
|categoryItem|
|Agrícolas|
|Empresariales|
|Alivio de Desastre|
|Educación|
|General|
|Vivienda|
|Veteranos|





