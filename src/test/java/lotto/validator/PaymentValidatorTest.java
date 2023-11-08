package lotto.validator;

import static lotto.constants.ExceptionMessages.CATCH_ERROR;
import static lotto.constants.ExceptionMessages.INPUT_EMPTY;
import static lotto.constants.ExceptionMessages.INVALID_NUMBER;
import static lotto.constants.ExceptionMessages.INVALID_PAYMENT;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaymentValidatorTest {
    @DisplayName("공백을 입력한 경우")
    @Test
    void 입력이_공백인_경우() {
        // given
        String text = "";
        // then
        Assertions.assertThatThrownBy(() -> PaymentValidator.validate(text))
                .hasMessage(CATCH_ERROR + INPUT_EMPTY);
    }

    @DisplayName("입력값에 문자가 포함된 경우")
    @Test
    void 문자가_포함된_입력_경우() {
        // given
        String text = "10000l";
        // then
        Assertions.assertThatThrownBy(() -> PaymentValidator.validate(text))
                .hasMessage(CATCH_ERROR + INVALID_NUMBER);
    }

    @DisplayName("1000단위로 입력하지 않은 경우")
    @Test
    void 단위가_1000이_아닌_경우() {
        // given
        String text = "2300";
        // then
        Assertions.assertThatThrownBy(() -> PaymentValidator.validate(text))
                .hasMessage(CATCH_ERROR + INVALID_PAYMENT);
    }

    @DisplayName("올바르게 입력한 경우")
    @Test
    void 올바른_입력_경우() {
        // given
        String text = "13000";
        // then
        Assertions.assertThat(PaymentValidator.validate(text)).isEqualTo(13000);
    }

}