package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineParameterizedTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 5})
    public void getKittensWithArgumentReturnsArgumentValue(int kittensCount) {
        Feline feline = new Feline();

        int actualKittens = feline.getKittens(kittensCount);

        assertEquals(kittensCount, actualKittens);
    }
}