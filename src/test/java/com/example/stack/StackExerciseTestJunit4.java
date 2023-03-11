package com.example.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StackExerciseTestJunit4 {

    private StackExercise sut;

    @Before
    public void initializeSut() {
        sut = new StackExercise();
    }

    @Test
    public void shouldBeEmptyWhenNothingPushed() {
        //given
        //when
        //then
        assertTrue(sut.isEmpty());

    }

    @Test
    public void shouldTopReturnLastPushedValue() throws StackEmptyException {
        //given
        //when
        pushValuesToStack(3);
        //then
        assertEquals("e3", sut.pop());
        assertEquals("e2", sut.pop());
        assertEquals("e1", sut.pop());
    }

    @Test
    public void shouldNotFailWhen200ElementsPushed() throws StackEmptyException {
        //given
        //when
        pushValuesToStack(200);
        //then
        assertEquals("e200", sut.pop());
    }

    private void pushValuesToStack(int numElements) {

        for (int i = 1; i <= numElements; i++) {
            sut.push("e" + i);
        }
    }

    @Test
    public void shouldBeEmptyWhenAllPopped() throws StackEmptyException {
        pushValuesToStack(3);
        //then
        sut.pop();
        sut.pop();
        sut.pop();

        assertTrue(sut.isEmpty());
    }

    @Test(expected = StackEmptyException.class)
    public void shouldThrowStackEmptyExceptionWhenEmptyPopped() throws StackEmptyException {
        //given
        //when
        //then
        sut.pop();


    }
}