@Google
Feature: Probar la b�squeda en Google

	Scenario: busco algo en Google
	
		Given navego a Google
		When busco algo
		And hago click en buscar
		Then obtengo resultados
	


