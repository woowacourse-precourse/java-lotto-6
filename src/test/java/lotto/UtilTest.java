package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UtilTest {
    @ParameterizedTest
    @ValueSource(strings = {"532", "123", "6542"})
    void isInteger_true_반환_테스트(String input) {
        assertTrue(LottoUtil.isInteger(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "321.12"})
    void isInteger_false_반환_테스트(String input) {
        assertFalse(LottoUtil.isInteger(input));
    }

    @Test
    void isIntegers_true_반환_테스트() {
        List<String> input = Arrays.asList("1", "2", "-3");

        assertTrue(LottoUtil.isIntegers(input));
    }

    @Test
    void isIntegers_false_반환_테스트() {
        List<String> input = Arrays.asList("test", "3.3232");

        assertFalse(LottoUtil.isIntegers(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1,10", "10,1,10", "1,1,1"})
    void isInRange_true_반환_테스트(int check, int inclusiveMin, int inclusiveMax) {
        assertTrue(LottoUtil.isInRange(check, inclusiveMin, inclusiveMax));
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1,10", "11,1,10"})
    void isInRange_false_반환_테스트(int check, int inclusiveMin, int inclusiveMax) {
        assertFalse(LottoUtil.isInRange(check, inclusiveMin, inclusiveMax));
    }

    @Test
    void hasDuplicatedNumbers_true_반환_테스트() {
        List<Integer> input = List.of(1, 2, 2, 3, 4, 5);

        assertTrue(LottoUtil.hasDuplicatedNumbers(input));
    }

    @Test
    void hasDuplicatedNumbers_false_반환_테스트() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);

        assertFalse(LottoUtil.hasDuplicatedNumbers(input));
    }

    @Test
    void getMatchingNumberCount_테스트() {
        List<Integer> inputA = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> inputB = List.of(5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
        assertEquals(5, LottoUtil.getMatchingNumberCount(inputA, inputB));
    }
}
