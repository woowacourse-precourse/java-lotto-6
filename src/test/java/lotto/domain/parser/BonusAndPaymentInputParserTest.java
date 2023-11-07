package lotto.domain.parser;

import static lotto.ErrorMessage.BONUS_AND_PAYMENT_WRONG_INPUT_ERROR_MESSAGE;
import static lotto.ErrorMessage.PARSE_INT_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusAndPaymentInputParserTest {
    InputParser inputParser = new BonusAndPaymentInputParser();

    @Test
    @DisplayName("숫자가 아닌 값을 넣으면 예외가 발생한다.")
    void caseNotNumericInput() {
        assertThatThrownBy(() -> inputParser.parse("-ㅂㄴㅇㅁㄴ"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_AND_PAYMENT_WRONG_INPUT_ERROR_MESSAGE.get());
    }

    @Test
    @DisplayName("int 범위를 초과하는 숫자를 입력하면 예외가 발생한다.")
    void caseByNotIntRange() {
        assertThatThrownBy(() -> inputParser.parse("3333333333"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PARSE_INT_ERROR_MESSAGE.get());
    }
}
