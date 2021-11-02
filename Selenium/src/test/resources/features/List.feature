@List
Feature: Buscar un elemento en una lista
	
  Scenario Outline: Validar que un texto esta presente en una lista
    Given navegar hasta la pagina de la lista
    When busco <state> en la lista
    Then puedo encontrar <city> en la lista
    
    Examples:
		|state     |city               |
		|Washington|Seattle, Washington|
		|Chicago   |Chicago, Illinois  |
    
	


