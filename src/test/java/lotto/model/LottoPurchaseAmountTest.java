package lotto.model;

import static lotto.constant.ErrorMessage.CONTAINING_OTHER_THAN_NUMBER;
import static lotto.constant.ErrorMessage.EXCEEDING_MAXIMUM_PURCHASE;
import static lotto.constant.ErrorMessage.NOT_MULTIPLES_OF_ONE_THOUSAND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.stub.LottoPurchaseAmountStub;
import org.junit.jupiter.api.Test;

class LottoPurchaseAmountTest extends LottoPurchaseAmountStub {
    @Test
    void createLottoPurchaseAmount() {
        LottoPurchaseAmount purchaseAmount = LottoPurchaseAmount.from(INPUT_PURCHASE_AMOUNT);

        assertThat(purchaseAmount)
                .isInstanceOf(LottoPurchaseAmount.class);
    }

    @Test
    void throw_exception_unless_number() {
        assertThatThrownBy(() -> LottoPurchaseAmount.from(INPUT_PURCHASE_AMOUNT1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CONTAINING_OTHER_THAN_NUMBER.getMessage());
    }

    @Test
    void throw_exception_unless_under_maximum_purchase_amount() {
        assertThatThrownBy(() -> LottoPurchaseAmount.from(INPUT_PURCHASE_AMOUNT2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(EXCEEDING_MAXIMUM_PURCHASE.getMessage());
    }

    @Test
    void throw_exception_unless_multiples_of_thousand() {
        assertThatThrownBy(() -> LottoPurchaseAmount.from(INPUT_PURCHASE_AMOUNT3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NOT_MULTIPLES_OF_ONE_THOUSAND.getMessage());
    }

    @Test
    public void getLottoPurchaseQuantity() {
        LottoPurchaseAmount amount = LottoPurchaseAmount.from(INPUT_PURCHASE_AMOUNT4);
        amount.getLottoPurchaseQuantity();

        assertThat(amount.getLottoPurchaseQuantity())
                .isEqualTo(new LottoPurchaseQuantity(PURCHASE_QUANTITY));
    }
}