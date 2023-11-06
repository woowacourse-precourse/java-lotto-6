package lotto.util.parser;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AmountParserTest {

    private final InputParser<Integer> parser = new AmountParser();

    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "3000"})
    @DisplayName("입력값이 비어 있지 않고 정수로 변환될 때 올바른 값을 반환해야 한다.")
    void testParseValidInput(String input) {
        int result = parser.parse(input);
        assertEquals(Integer.parseInt(input), result);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   "})
    @DisplayName("입력값이 null이거나 빈 공간일 때 IllegalArgumentException을 던져야 한다.")
    void testParseInvalidInput(String input) {
        assertThrows(IllegalArgumentException.class, () -> parser.parse(input),
                ErrorMessage.IS_BLANK);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1000abc", "xyz123"})
    @DisplayName("입력값이 숫자가 아닐 때 IllegalArgumentException을 던져야 한다.")
    void testParseNonNumericInput(String input) {
        assertThrows(IllegalArgumentException.class, () -> parser.parse(input),
                ErrorMessage.NOT_A_NUMBER);
    }
}
