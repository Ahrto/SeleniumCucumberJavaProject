@Grid
Feature: Grid Test
  Voy a extraer valores de una tabla
  
Rule: El ususario puede extraer valores de la tabla y validarlos
 
  Background: Navegar hasta la tabla
  	Given navegar hasta la tabla

	@Smoke @Regression
  Scenario: Extraer valores de la misma
    
    Then extraer el valor que quiero

  @Regression
  Scenario: Comprobar que la tabla es visible
    
    Then comprobar que la tabla es visible

