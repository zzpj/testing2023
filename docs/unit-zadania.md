# Unit Testing - Zadania

# Zadanie 1
Przygotuj testy z wykorzystaniem JUnita w wersji 5 dla wybranych metod z klasy `com.example.Calculator`.
Użyj:
- odpowiednich adnotacji
    - `@BeforeEach`
    - `@AfterEach`
    - `@BeforeAll`
    - `@AfterAll`
    - `@Test`
- nowego API asercji
    - `@assertThrow`
    - `@assertAll`
    - `@assertTimeout` (wskazówka: `Thread.sleep(2000)`)
- asumpcji
    - `assumeTrue()`
    - `assumeFalse()`
    - `assumingThat()`
- `@DisplayName`
- `@Nested`
- `@ParametrizedTest`
    - `@ValueSource`
    - `@CsvSource`
    - `@CsvFileSource`
    - `@MethodSource`
- On/Off
    - `@Disabled`
    - `@EnabledOnJre`
    - `@EnabledOnOs`
- `@Tag`

# Zadanie 2
Wykonaj testy jednostkowe z wykorzystaniem wyrażen regularnych dla metody która weryfikuje 
poprawność maila (`com.example.validation.EmailValidator`). Wykorzystaj sugestie z nazw metod.

# Zadanie 3 
Wykonaj testy jednostkowe z klasie `com.example.tolkien.service.DataServiceTest`.