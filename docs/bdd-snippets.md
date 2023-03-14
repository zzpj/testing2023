# BDD Snippets

### Init basic project
````
mvn archetype:generate                      \
"-DarchetypeGroupId=io.cucumber"           \
"-DarchetypeArtifactId=cucumber-archetype" \
"-DarchetypeVersion=7.11.1"               \
"-DgroupId=hellocucumber"                  \
"-DartifactId=hellocucumber"               \
"-Dpackage=hellocucumber"                  \
"-Dversion=1.0.0-SNAPSHOT"                 \
"-DinteractiveMode=false"
````

### cucumber.properties file
````properties
cucumber.publish.enabled=true
cucumber.publish.quiet=true
````

### First test
* create `stack.feature` file in `src/test/resources/bdd`
```gherkin
Feature: Test stack features

  Scenario: Adding element to new stack
    Given empty stack is created
    When new element is added to stack
    Then new element is at the top of the stack
```
* create `StackStepDefinitions` class:
```java
public class StackStepDefinitions {

    UnitStackable<String> unitStack;

    @Before
    public void init() {
        unitStack = new UnitStack<>();
    }
    @Given("empty stack is created")
    public void emptyStackIsCreated() {
        assertTrue(unitStack.isEmpty());
    }

    @When("new element is added to stack")
    public void newElementIsAddedToStack() {
        unitStack.push("element");
    }

    @Then("new element is at the top of the stack")
    public void newElementIsAtTheTopOfTheStack() {
        assertEquals("element", unitStack.top());
    }
}
```

### Evaluate passed expressions
```gherkin
  Scenario: Removing elements from the stack
    Given non-empty stack with 3 elements
    When all elements are removed from stack
    Then stack is empty
    And throws "java.util.NoSuchElementException" for getting element from empty stack
```

```java
    @Given("non-empty stack with {int} elements")
    public void nonEmptyStackWithElements(int size) {

        unitStack.push("element");
        unitStack.push("element");
        unitStack.push("element");
        assertEquals(size, unitStack.size());
    }

    @When("all elements are removed from stack")
    public void allElementsAreRemovedFromStack() {
        unitStack.pop();
        unitStack.pop();
        unitStack.pop();
    }

    @Then("stack is empty")
    public void stackIsEmpty() {
        assertTrue(unitStack.isEmpty());
    }

    @And("throws {string} for getting element from empty stack")
    public void throwsForGettingElementFromEmptyStack(String clazz) throws ClassNotFoundException {
        NoSuchElementException noSuchElementException = assertThrows(NoSuchElementException.class, () -> unitStack.pop());
        assertEquals(noSuchElementException.getClass(), forName(clazz));
    }
```

### Scenario Outlines
```gherkin
Feature: FizzBuzzProblem

  Scenario Outline: Solve Fizz Buzz Problem
    Given I have set of numbers
    When I pass <number> through algorithm
    Then I get "<answer>"

    Examples:
      | number | answer   |
      | 3      | Fizz     |
      | 4      | 4        |
      | 5      | Buzz     |
      | 15     | FizzBuzz |
```

```java
public class FizzBuzzStepDefinitions {

    FizzBuzzProblem fizzBuzzProblem;
    String result;

    @Given("I have set of numbers")
    public void iHaveSetOfNumbers() {
        fizzBuzzProblem = new FizzBuzzProblem();
    }

    @When("^I pass (-?\\d+) through algorithm$")
    public void iPassThroughAlgorithm(int number) {
        result = fizzBuzzProblem.getFizzBuzzNumber(number);
    }

    @Then("I get {string}")
    public void iGet(String expectedResult) {
        assertEquals(expectedResult, result);
    }
}
```