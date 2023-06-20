package ua.lviv.iot.algo.part1.lab5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReplaceNumbersWithLettersTest {
    private int length;
    private String text;


    @Test
    void testEmptyStr() {
        ReplaceNumbersWithLetters replacer = new ReplaceNumbersWithLetters(text, length);
        assertEquals("", replacer.replaceOneDigitNumbers());
    }

    @Test
    void testDoOperation() {
        text = "Some words 1 2 3 0 two more 2345 2A F2 f3 2. 3- 2, 3! 2@ 3№ 4; 5%";
        length = 30;
        ReplaceNumbersWithLetters replacer = new ReplaceNumbersWithLetters(text, length);
        assertEquals("Some words A B C 0 two more 2345 2A F2 f3 2. 3- 2, 3! 2@ 3№ 4; 5%", replacer.replaceOneDigitNumbers());
    }

}