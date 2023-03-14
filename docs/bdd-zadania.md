# BDD - Zadania

## Zadanie 1
* Przygotuj scenariusze dla podstawowych operacji matematycznych w pliku `calculator.feature` (i klasy `com.example.calculator.Calculator`) z wykorzystaniem języka
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
  Scenario Outline: Prime check
    Given there are some prime and non-prime numbers
    When I check <testNumber>
    Then I should get answer using <primeFlag>

    Examples:
    | testNumber | primeFlag |
    | 5          | false     |
    | 21         | true      |
```
## Zadanie 2
Stwórz i zaimplementuj scenariusz (plik `timetable.feature`), który pobierze aktualny plan zajęć Twojej grupy ze strony `https://ftims.edu.p.lodz.pl/`. Skorzystaj z automatyzacji z wykorzystaniem Selenium WebDriver'a.