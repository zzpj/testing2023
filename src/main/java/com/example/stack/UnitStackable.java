package com.example.stack;

public interface UnitStackable<T> {

    void push(T t);

    T pop();

    T top();

    int size();

    boolean isEmpty();
}
