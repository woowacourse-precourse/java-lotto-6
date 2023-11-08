package lotto;

import lotto.exception.PurchaseAmountExceptionMessage;
import lotto.validator.LottoPurchaseAmountValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 로또 구입 금액 검증에 대한 테스트
 */
public class LottoPurchaseAmountValidatorTest {

    private LottoPurchaseAmountValidator lottoPurchaseAmountValidator = new LottoPurchaseAmountValidator();

    @Test
    @DisplayName("입력값이 숫자가 아닌 경우 예외 발생")
    void notNumber() {
        String input = "abc";
        assertThatThrownBy(() -> lottoPurchaseAmountValidator.isValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PurchaseAmountExceptionMessage.NOT_POSITIVE_NUMBER);
    }

    @Test
    @DisplayName("입력값이 음수인 경우 예외 발생")
    void negativeNumber() {
        String input = "-1000";
        assertThatThrownBy(() -> lottoPurchaseAmountValidator.isValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PurchaseAmountExceptionMessage.NOT_POSITIVE_NUMBER);
    }

    @Test
    @DisplayName("입력값이 1000원 단위가 아닌 경우 예외 발생")
    void notMultipleOf1000() {
        String input = "1500";
        assertThatThrownBy(() -> lottoPurchaseAmountValidator.isValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PurchaseAmountExceptionMessage.NOT_MULTIPLE_OF_1000);
    }

    @Test
    @DisplayName("입력값이 0인 경우 예외 발생")
    void zero() {
        String input = "0";
        assertThatThrownBy(() -> lottoPurchaseAmountValidator.isValid(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PurchaseAmountExceptionMessage.NOT_POSITIVE_NUMBER);
    }

}
