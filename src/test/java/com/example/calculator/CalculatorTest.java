package com.example.calculator;

//import org.junit.After;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.condition.JRE.JAVA_18;

@DisplayName(" Calculator testing ")
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

    Calculator sut;
    static long startTime;

    @BeforeAll
    public static void initAll() {
        startTime = System.currentTimeMillis();
    }

    @BeforeEach
    public void setup() {
        sut = new Calculator();
    }

   // @Order(100)
    @Test
    @DisplayName("  Calculates adding two numbers")
    public void shouldAddTwoNumbers() {

        //given
        //Calculator sut = new Calculator();
        //when
        int actual = sut.add(4, 3);
        //then
        assertEquals(7, actual);
    }

  //  @Order(200)
    @Test
    public void shouldCheckPrimeNumbers() {
        assertAll(
                () -> assertTrue(sut.isPrime(7)),
                () -> assertFalse(sut.isPrime(12))
        );
    }

    @Test
    @EnabledOnOs(OS.MAC)
    public void shouldCheckNotNull() {
        assertNotNull(sut, " check null ");
    }

    @RepeatedTest(10)
    public void shouldCheckTimeout() {

        assertTimeout(Duration.ofMillis(30), () -> sut.multiply(4, 6));
    }

    @Test
    @Tag("FEATURE-1")
    //@EnabledOnJre(JAVA_18)
    //@EnabledIfSystemProperty(named = "os.arch", matches = ".*77.*")
    public void shouldThrownAnException() {

        NotDividedByZeroException notDividedByZeroException = assertThrows(NotDividedByZeroException.class, () -> sut.divide(5, 0));
        assertEquals("Can't by zero!", notDividedByZeroException.getMessage());
    }



    @AfterAll
    public static void tearDownAll() {
        long endTIme = System.currentTimeMillis();
        long result = endTIme - startTime;
        System.out.println("execution time " + result + " ms ");
    }
}