package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void constructorWithUnknownSexThrowsException() {
        Exception exception = assertThrows(
                Exception.class,
                () -> new Lion("Неизвестно", feline)
        );

        assertEquals(
                "Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage()
        );
    }

    @Test
    public void getKittensReturnsFelineKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);

        when(feline.getKittens()).thenReturn(3);

        int actualKittens = lion.getKittens();

        assertEquals(3, actualKittens);
        verify(feline).getKittens();
    }

    @Test
    public void getFoodReturnsFelineMeatFood() throws Exception {
        Lion lion = new Lion("Самец", feline);

        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
        verify(feline).eatMeat();
    }
}