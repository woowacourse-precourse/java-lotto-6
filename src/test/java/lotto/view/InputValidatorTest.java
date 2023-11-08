package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.utils.ErrorMessages.INPUT_NUMBER_FORMAT;
import static lotto.view.InputValidator.parseNumber;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @Test
    @DisplayName("parseNumber 메서드 테스트 - 금액을 지불 후 형변환")
    public void getPaymentNumber() {
        String invalidPayment = "1000j";

        assertThatThrownBy(() -> parseNumber(invalidPayment))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(INPUT_NUMBER_FORMAT);
    }

}