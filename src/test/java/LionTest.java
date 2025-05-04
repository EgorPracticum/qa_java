package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void getKittens_ShouldReturnFelineKittensCount() throws Exception {
        when(feline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", feline);
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void getFood_ShouldReturnPredatorFood() throws Exception {
        when(feline.eatMeat()).thenReturn(List.of("Мясо", "Рыба"));
        Lion lion = new Lion("Самка", feline);
        assertEquals(List.of("Мясо", "Рыба"), lion.getFood());
    }

    @Test
    public void doesHaveMane_ShouldReturnTrueForMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void constructor_ShouldThrowExceptionForInvalidSex() throws Exception {
        new Lion("Неизвестно", feline);
    }
}