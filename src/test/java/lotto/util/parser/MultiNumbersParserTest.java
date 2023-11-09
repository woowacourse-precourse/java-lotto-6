package lotto.util.parser;

import java.util.List;
import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MultiNumbersParserTest {

    private MultiNumbersParser parser;

    @BeforeEach
    void setUp() {
        parser = new MultiNumbersParser();
    }

    @Test
    @DisplayName("올바른 형식의 당첨 번호 문자열을 파싱하면 숫자 리스트를 반환한다.")
    void testParseValidInput() {
        String input = "1, 2, 3, 4, 5, 6";
        List<Integer> result = parser.parse(input);
        Assertions.assertEquals(List.of(1, 2, 3, 4, 5, 6), result);
    }

    @Test
    @DisplayName("입력 문자열이 빈 경우 예외를 발생시킨다.")
    void testParseBlankInput() {
        String input = " ";
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parse(input));
        Assertions.assertEquals(ErrorMessage.IS_BLANK, exception.getMessage());
    }

    @Test
    @DisplayName("입력 문자열에 숫자가 아닌 값이 포함된 경우 예외를 발생시킨다.")
    void testParseNonNumericInput() {
        String input = "1, 2, x, 4, 5, 6";
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parse(input));
        Assertions.assertEquals(ErrorMessage.NOT_A_NUMBER, exception.getMessage());
    }
}
