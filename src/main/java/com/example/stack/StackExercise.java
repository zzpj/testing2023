/**
 * This example is based on example from the book:
 * <p>
 * Pragmatic Unit Testing in Java with JUnit by:
 * Andy Hunt
 * Dave Thomas
 * <p>
 * All rights belong to the authors of the book.
 */
package com.example.stack;

public class StackExercise {

    private static final int INITIAL_ARRAY_SIZE = 10;
    private static final int INTERNAL_ARRAY_INCREASE_STEP = 10;
    private String[] internalArray = new String[INITIAL_ARRAY_SIZE];

    private int currentIndex = -1;

    public String pop() throws StackEmptyException {
        if (currentIndex == -1) {
            throw new StackEmptyException();
        }

        return internalArray[currentIndex--];
    }

    public void push(String item) {
        if (currentIndex == internalArray.length - 1) {
            increaseInternalArray();
        }

        internalArray[++currentIndex] = item;
    }

    private void increaseInternalArray() {
        String[] extendedArray = new String[internalArray.length + INTERNAL_ARRAY_INCREASE_STEP];
        for (int i = 0; i < internalArray.length; i++) {
            extendedArray[i] = internalArray[i];
        }
        internalArray = extendedArray;
    }

    public String top() throws StackEmptyException {
        return internalArray[currentIndex];
    }

    public boolean isEmpty() {
        return currentIndex == -1;
    }
}