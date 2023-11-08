package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.Model.LottoPurchaseAmount;

public class PurchaseAmountTest {

    @Test
    void check_InputIsNotNumeric() {
        String invalidNumberInput = "abc";
        assertThatThrownBy(() -> LottoPurchaseAmount.validateIsNumeric(invalidNumberInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_NegativeInput() {
        int negativeNumberInput = -5;
        assertThatThrownBy(() -> LottoPurchaseAmount.validateFitPurchaseAmountCondition(negativeNumberInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_NotDividedThousandInput() {
        int notDividedThousand = 10005;
        assertThatThrownBy(() -> LottoPurchaseAmount.validateFitPurchaseAmountCondition(notDividedThousand))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_UnderThousandInput() {
        int negativeNumberInput = 500;
        assertThatThrownBy(() -> LottoPurchaseAmount.validateFitPurchaseAmountCondition(negativeNumberInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculatePurchaseLottoCount_ValidAmount_ShouldReturnCorrectCount() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount("5000");
        int lottoCount = lottoPurchaseAmount.calculatePurchaseLottoCount();
        assertThat(lottoCount).isEqualTo(5);
    }
}
