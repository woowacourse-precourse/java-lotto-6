package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import lotto.View.InputView;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    void check_InputIsNotNumeric() {
        String invalidNumberInput = "abc";
        assertThatThrownBy(() -> InputView.validateIsNumeric(invalidNumberInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_NegativeInput() {
        String negativeNumberInput = "-5";
        assertThatThrownBy(() -> InputView.validateFitPurchaseAmountCondition(negativeNumberInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_IncorrectInput() {
        String notDividedThousand = "10005";
        assertThatThrownBy(() -> InputView.validateFitPurchaseAmountCondition(notDividedThousand ))
                .isInstanceOf(IllegalArgumentException.class);
    }
}