package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChallengeTest {

    private final Challenge underTest = new Challenge();

    @Test
    public void procesNextStateTest() {
        int[][] input = {
                {1,1},
                {1,0}
        };
        // implementation goes here
        int[][] expected = {
                {1,1},
                {1,1}
        };
        assertEquals(expected, input);
    }

    @Test
    void shouldReturnAllLiveCells_CountLiveCells() {
        int[][] input = {
                {1,1},
                {1,0}
        };
        int expected = 3;
        int actual = underTest.countLiveCells(input, 1,1, 1, 1);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnAllLiveCells_CountLiveCells_NoLiveCells() {
        int[][] input = {
                {0,0},
                {0,0}
        };
        int expected = 0;
        int actual = underTest.countLiveCells(input, 1,1, 1, 1);

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnAllLiveCells_CountLiveCells_NoLiveCells_Beginning() {
        int[][] input = {
                {0,1},
                {0,1}
        };
        int expected = 2;
        int actual = underTest.countLiveCells(input, 0,0, 1, 1);

        assertEquals(expected, actual);
    }

}
