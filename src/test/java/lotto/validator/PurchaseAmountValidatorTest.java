package lotto.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.TestConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountValidatorTest {

    @DisplayName("올바른 구매 금액 입력 시 정상 처리된다.")
    @Test
    void 올바른_구매_금액_검사() {
        String validInput = "1000";
        long expectedAmount = 1000;

        long actualAmount = PurchaseAmountValidator.validate(validInput);

        assertThat(actualAmount).isEqualTo(expectedAmount);
    }

    @DisplayName("입력값이 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void 숫자_형식_아닌_입력_예외_검사() {
        String invalidInput = "천원";

        assertThatThrownBy(() -> PurchaseAmountValidator.validate(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TestConstant.ERROR_MESSAGE);
    }

    @DisplayName("구매 금액이 최소 단위보다 적을 경우 예외가 발생한다.")
    @Test
    void 최소_단위_미만_금액_예외_검사() {
        String invalidInput = "500";

        assertThatThrownBy(() -> PurchaseAmountValidator.validate(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TestConstant.ERROR_MESSAGE);
    }

    @DisplayName("구매 금액이 단위로 나누어 떨어지지 않을 경우 예외가 발생한다.")
    @Test
    void 단위로_나누어_떨어지지_않는_금액_예외_검사() {
        String invalidInput = "1050";

        assertThatThrownBy(() -> PurchaseAmountValidator.validate(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TestConstant.ERROR_MESSAGE);
    }

    @DisplayName("구매 금액이 최대 금액을 초과할 경우 예외가 발생한다.")
    @Test
    void 최대_금액_초과_예외_검사() {
        String invalidInput = "100000000";

        assertThatThrownBy(() -> PurchaseAmountValidator.validate(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TestConstant.ERROR_MESSAGE);
    }
}
