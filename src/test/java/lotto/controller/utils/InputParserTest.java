package lotto.controller.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class InputParserTest {
    private InputParser inputParser;

    @BeforeEach
    void setUp(){
        inputParser = new InputParser();
    }

    @DisplayName("문자열을 정수로 변환하는지 확인")
    @Test
    void parseToIntegerTest1() {
        String input = "10";
        int expectedOutput = 10;
        int actualOutput = inputParser.parseToInteger(input);
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @DisplayName("문자열을 정수로 변환하는지 확인")
    @Test
    void parseToIntegerTest2() {
        String input = "abc";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputParser.parseToInteger(input);
        });
    }

    @DisplayName("로또 번호 문자열을 리스트로 변환하는지 확인")
    @Test
    void parseLottoNumbersTest1() {
        String input = "1,2,3,4,5,6";
        List<Integer> expectedOutput = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> actualOutput = inputParser.parseLottoNumbers(input);
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @DisplayName("로또 번호 문자열을 리스트로 변환하는지 확인")
    @Test
    void parseLottoNumbersTest2() {
        String input = "1,2,abc,4,5,6";
        Assertions.assertThrows(NumberFormatException.class, () -> {
            inputParser.parseLottoNumbers(input);
        });
    }
}