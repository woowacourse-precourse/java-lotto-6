package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    void check_InputIsNotNumeric() {
        String invalidNumberInput = "abc";
        assertThatThrownBy(() -> LottoPurchaseAmountValidator.validateIsNumeric(invalidNumberInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_NegativeInput() {
        String negativeNumberInput = "-5";
        assertThatThrownBy(() -> LottoPurchaseAmountValidator.validateFitPurchaseAmountCondition(negativeNumberInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_IncorrectInput() {
        String notDividedThousand = "10005";
        assertThatThrownBy(() -> LottoPurchaseAmountValidator.validateFitPurchaseAmountCondition(notDividedThousand ))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_ZeroInput() {
        String negativeNumberInput = "0";
        assertThatThrownBy(() -> LottoPurchaseAmountValidator.validateFitPurchaseAmountCondition(negativeNumberInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}