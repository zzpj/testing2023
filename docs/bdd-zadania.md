# BDD - Zadania

## Zadanie 1
* Przygotuj scenariusze dla podstawowych operacji matematycznych w pliku `calculator.feature` z wykorzystaniem języka 
Gherkin oraz frameworka Cucumber:
```gherkin
Scenario: All done
  Given I am out shopping
  And I have eggs
  And I have milk
  And I have butter
  When I check my list
  Then I don't need anything
```
* Dla sprawdzenia poprawności metody `isPrime` wykorzystaj `Scenario Outline` wraz z przedstawieniem danych wejściowych w formie tabelarycznej (`Examples`)
```gherkin
Scenario Outline: eating
  Given there are <start> cucumbers
  When I eat <eat> cucumbers
  Then I should have <left> cucumbers

  Examples:
    | start | eat | left |
    |    12 |   5 |    7 |
    |    20 |   5 |   15 |
```
## Zadanie 2