package lotto.domain.parser;

import static lotto.ErrorMessage.LOTTO_WRONG_INPUT_ERROR_MESSAGE;
import static lotto.ErrorMessage.PARSE_INT_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersInputParserTest {
    InputParser inputParser = new WinningNumbersInputParser();

    @Test
    @DisplayName("정수가 아닌 값을 넣으면 예외가 발생한다.")
    void caseByNotNumeric() {
        assertThatThrownBy(() -> inputParser.parse("일,이,삼사"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_WRONG_INPUT_ERROR_MESSAGE.get());
    }

    @Test
    @DisplayName("Int 범위를 넘으면 예외가 발생한다.")
    void caseByNotIntRange() {
        assertThatThrownBy(() -> inputParser.parse("2222222222,1,3,4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PARSE_INT_ERROR_MESSAGE.get());
    }
}
