package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("구입 금액이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void validateAmountNotNumber() {
        // given
        String purchaseAmount = "hello";

        // when, then
        assertThatThrownBy(() -> InputValidator.validateAmountNotNumber(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 당첨 번호가 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void validateAnswerNumberIsNumber() {
        // given
        String answerNumbers = "1,2,3,4,5,hello";

        // when, then
        assertThatThrownBy(() -> InputValidator.validateAnswerNumberIsNumber(answerNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}