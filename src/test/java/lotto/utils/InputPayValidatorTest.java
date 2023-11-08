package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constants.ExceptionMessage;
import lotto.domain.User;
import org.junit.jupiter.api.Test;

class InputPayValidatorTest {

    @Test
    void 숫자가_아닌_경우() {
        // given
        String pay = "asdf";

        assertThatThrownBy(() -> InputValidator.validatePayNumber(pay))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NOT_INTEGER_ERROR.getMessage());
    }

    @Test
    void 음수인_경우() {
        // given
        String pay = "-10000";
        assertThatThrownBy(() -> InputValidator.validatePayNumber(pay))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NEGATIVE_NUMBER_ERROR.getMessage());
    }

    @Test
    void 나머지가_0이_아닌_경우() {
        // given
        String payLessThan = "123";
        String payNotMultiple = "1234";

        assertThatThrownBy(() -> User.paid(payLessThan))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.PAY_RANGE_ERROR.getMessage());

        assertThatThrownBy(() -> User.paid(payNotMultiple))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.PAY_RANGE_ERROR.getMessage());
    }
}