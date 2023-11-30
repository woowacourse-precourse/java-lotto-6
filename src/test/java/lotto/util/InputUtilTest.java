package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputUtilTest {

    @Test
    @DisplayName("정상적인 숫자가 들어왔을 때, int 값으로 반환을 한다.")
    void testParseInt() {
        // given
        String input = "123";

        // when
        int result = InputUtil.parseInt(input);

        // then
        int expectedResult = 123;
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("정상적인 숫자가 들어왔을 때, int 값으로 반환을 한다.")
    void testParseNums() {
        // given
        List<String> splitInput = List.of("1", "2", "3", "4", "5", "6");

        // when
        List<Integer> result = InputUtil.parseNums(splitInput);

        // then
        List<Integer> expectedResult = List.of(1,2,3,4,5,6);
        assertEquals(expectedResult, result);
    }


    @Test
    @DisplayName("(,)와 함께 입력이 들어오면 , 를 기준으로 나눠줘야한다.")
    void testSplitInput() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        List<String> result = InputUtil.splitInput(input);

        // then
        List<String> expectedResult = List.of("1", "2", "3", "4", "5", "6");
        assertEquals(expectedResult, result);
    }
}