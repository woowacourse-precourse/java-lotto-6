package validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.constants.Constants;
import view.validator.PurchaseAmountValidator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static util.message.ExceptionMessage.*;

public class PurchaseAmountValidatorTest {
    @ParameterizedTest
    @DisplayName("구입금액을 빈값으로 입력한 경우 예외가 발생한다.")
    @ValueSource(strings = {"", " ", "  ", "    ", "     ", "\n", "\t", "\r"})
    void givenBlankAmount_thenFail(final String purchaseAmount) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validate(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(BLANK_MESSAGE.getValue()));
    }

    @ParameterizedTest
    @DisplayName("구입금액을 숫자가 아닌 형태로 입력한 경우 예외가 발생한다.")
    @ValueSource(strings = {"abc", "12bd"})
    void givenNonNumeric_thenFail(final String purchaseAmount) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validate(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(TYPE_MESSAGE.getValue()));
    }

    @ParameterizedTest
    @DisplayName("구입금액이 0이하인경우 예외가 발생한다.")
    @ValueSource(strings = {"-1", "0"})
    void givenLessZero_thenFail(final String purchaseAmount) {
        assertThatThrownBy(() -> PurchaseAmountValidator.validate(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(RANGE_MESSAGE.getValue(), Constants.ZERO.getValue()));
    }
}
