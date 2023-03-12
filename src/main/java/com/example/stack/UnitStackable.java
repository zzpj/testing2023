package com.example.stack;

public interface UnitStackable<T> {

    void push(T t);

    T pop() throws StackEmptyException;

    T top() throws StackEmptyException;

    int size();

    boolean isEmpty();
}
