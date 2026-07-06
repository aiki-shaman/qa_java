package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void getSoundReturnsMeow() {
        Cat cat = new Cat(feline);

        String actualSound = cat.getSound();

        assertEquals("Мяу", actualSound);
    }

    @Test
    public void getFoodReturnsPredatorFood() throws Exception {
        Cat cat = new Cat(feline);

        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
        verify(feline).eatMeat();
    }
}