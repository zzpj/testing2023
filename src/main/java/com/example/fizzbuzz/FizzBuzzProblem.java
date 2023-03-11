package com.example.fizzbuzz;

/**
 * Fizz Buzz is a 'game' where:
 * - if the number is divisible by 3, you say Fizz
 * - if the number is divisible by 5, you say Buzz
 * - if neither, you say the number
 */
public class FizzBuzzProblem {

    public String getFizzBuzzNumber(int number) {
        if (number % 15 == 0) {
            return "FizzBuzz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        }
        return String.valueOf(number);
    }
}