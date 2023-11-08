package lotto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @DisplayName("입력값을 리스트로 변환하는 기능 테스트")
    @Test
    void parseInputToListTest() {
        String inputNumbers = "1, 4,10, 2,6,3";
        List<Integer> actual = Arrays.asList(1, 4, 10, 2, 6, 3);
        List<Integer> expected = Parser.parseInputToList(inputNumbers);
        assertEquals(expected, actual);
    }

    @DisplayName("입력값을 숫자로 변환하는 기능 테스트")
    @Test
    void parseInputToNumberTest() {
        String inputNumber = "7";
        int actual = Parser.parseInputToNumber(inputNumber);
        int expected = 7;
        assertEquals(expected, actual);
    }

}
