package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {

    @Test
    public void eatMeatReturnsPredatorFood() throws Exception {
        Feline feline = new Feline();

        List<String> actualFood = feline.eatMeat();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualFood);
    }

    @Test
    public void getFamilyReturnsCatsFamily() {
        Feline feline = new Feline();

        String actualFamily = feline.getFamily();

        assertEquals("Кошачьи", actualFamily);
    }

    @Test
    public void getKittensWithoutArgumentsReturnsOne() {
        Feline feline = new Feline();

        int actualKittens = feline.getKittens();

        assertEquals(1, actualKittens);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 5})
    public void getKittensWithArgumentReturnsArgumentValue(int kittensCount) {
        Feline feline = new Feline();

        int actualKittens = feline.getKittens(kittensCount);

        assertEquals(kittensCount, actualKittens);
    }
}