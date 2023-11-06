package lotto.model;

import static lotto.constant.ErrorMessage.CONTAINING_OTHER_THAN_NUMBER;
import static lotto.constant.ErrorMessage.EXCEEDING_MAXIMUM_PURCHASE;
import static lotto.constant.ErrorMessage.NOT_MULTIPLES_OF_ONE_THOUSAND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoPurchaseAmountTest {
    @Test
    void createLottoPurchaseAmount() {
        String inputPurchaseAmount = "5000";
        LottoPurchaseAmount purchaseAmount = LottoPurchaseAmount.from(inputPurchaseAmount);

        assertThat(purchaseAmount)
                .isInstanceOf(LottoPurchaseAmount.class);
    }

    @Test
    void throw_exception_unless_number() {
        String inputPurchaseAmount = "가나다";
        assertThatThrownBy(() -> LottoPurchaseAmount.from(inputPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CONTAINING_OTHER_THAN_NUMBER.getMessage());
    }

    @Test
    void throw_exception_unless_under_maximum_purchase_amount() {
        String inputPurchaseAmount = "110000";
        assertThatThrownBy(() -> LottoPurchaseAmount.from(inputPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEEDING_MAXIMUM_PURCHASE.getMessage());
    }

    @Test
    void throw_exception_unless_multiples_of_thousand() {
        String inputPurchaseAmount = "99999";
        assertThatThrownBy(() -> LottoPurchaseAmount.from(inputPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_MULTIPLES_OF_ONE_THOUSAND.getMessage());
    }

    @Test
    public void getLottoPurchaseQuantity() {
        String inputPurchaseAmount = "5000";
        LottoPurchaseAmount amount = LottoPurchaseAmount.from(inputPurchaseAmount);
        amount.getLottoPurchaseQuantity();

        assertThat(amount.getLottoPurchaseQuantity())
                .isEqualTo(new LottoPurchaseQuantity(5));
    }
}