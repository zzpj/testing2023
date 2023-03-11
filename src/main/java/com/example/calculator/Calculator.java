package com.example.calculator;

import java.util.stream.IntStream;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) throws NotDividedByZeroException {
        if (b == 0) {
            throw new NotDividedByZeroException("Can't by zero!");
        }
        return a / b;
    }

    public int modulo(int a, int b) {
        return a % b;
    }

    public boolean isPrime(int a) {
        return IntStream.range(2, a).noneMatch(e -> modulo(a, e) == 0);
    }
}