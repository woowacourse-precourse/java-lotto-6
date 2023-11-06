package lotto.utils;

import static lotto.utils.InputParser.parseStringToInteger;
import static lotto.utils.InputParser.parseStringToIntegerList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputParserTest {
    @DisplayName("문자열을 정수로 변환하도록 테스트한다.")
    @Test
    void testParseStringToInteger() {
        String inputNumber = "2000";
        int parseNumber = parseStringToInteger(inputNumber);
        assertThat(parseNumber).isEqualTo(2000);
    }

    @DisplayName("문자열을 정수 리스트로 변환하도록 테스트한다.")
    @Test
    void testParseStringToIntegerList() {
        String inputNumbers = "1,2,3,4,5,6";
        List<Integer> parseNumberList = parseStringToIntegerList(inputNumbers);
        assertThat(parseNumberList).contains(1, 2, 3, 4, 5, 6);
    }
}