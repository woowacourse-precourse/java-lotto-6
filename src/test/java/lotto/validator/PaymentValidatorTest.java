package lotto.validator;

import static lotto.constants.ExceptionMessages.CATCH_ERROR;
import static lotto.constants.ExceptionMessages.INPUT_EMPTY;
import static lotto.constants.ExceptionMessages.INVALID_NUMBER;
import static org.junit.jupiter.api.Assertions.*;

import lotto.constants.ExceptionMessages;
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

//    @DisplayName("입력값에 문자가 포함된 경우")
//    @Test
//    void 문자가_포함된_입력_경우() {
//        // given
//        String text = "10000l";
//        // then
//        Assertions.assertThatThrownBy(() -> PaymentValidator.validate(text))
//                .hasMessage(CATCH_ERROR + INVALID_NUMBER);
//    }

    @DisplayName("공백 값인 경우")
    @Test
    void 입력이_공백인_경우() {
        // given
        String text = "";
        // then
        Assertions.assertThatThrownBy(() -> PaymentValidator.validate(text))
                .hasMessage(CATCH_ERROR + INPUT_EMPTY);
    }

}