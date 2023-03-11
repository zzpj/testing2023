package com.example.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParametrizedCalculatorTest {

    Calculator sut;

    @BeforeEach
    public void setup() {
        sut = new Calculator();
    }

    @ParameterizedTest
    @ValueSource(ints = {40, 60, 70, 2000})
    public void shouldDividedBy10(int a) {
        assertEquals(0, sut.modulo(a, 10));
    }


    @ParameterizedTest
    @CsvSource({"25, 5","36,6","70, 10"})
    public void shouldCheckDivibility(int a, int b) {
        assertEquals(0, sut.modulo(a, b));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data/ABsum.csv", numLinesToSkip = 1, delimiter = ';')
    public void shouldCheckDivibility(int a, int b, int sum) {
        assertEquals(sum, sut.add(a, b));
    }

}
