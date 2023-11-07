package lotto.model;

import static lotto.Message.ErrorMessage.PURCHASE_AMOUNT_RANGE_ERROR_MESSAGE;
import static lotto.Message.ErrorMessage.PURCHASE_AMOUNT_UNIT_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {
    @DisplayName("model_PurchaseAmount_0이_입력_했을_때_예외_처리")
    @Test
    public void model_PurchaseAmount_0_input() {
        int inputPurchaseAmount = 0;

        assertThatThrownBy(() -> new PurchaseAmount(inputPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_AMOUNT_RANGE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("model_PurchaseAmount_1000000이_입력_했을_때_예외_처리")
    @Test
    public void model_PurchaseAmount_1000000_input() {
        int inputPurchaseAmount = 1000000;

        assertThatThrownBy(() -> new PurchaseAmount(inputPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_AMOUNT_RANGE_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("model_PurchaseAmount_2001이_입력_했을_때_예외_처리")
    @Test
    public void model_PurchaseAmount_2001_input() {
        int inputPurchaseAmount = 2001;

        assertThatThrownBy(() -> new PurchaseAmount(inputPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_AMOUNT_UNIT_ERROR_MESSAGE.getMessage());
    }

    @DisplayName("model_PurchaseAmount_2000이_입력_했을_때")
    @Test
    public void model_PurchaseAmount_2000_input() {
        int inputPurchaseAmount = 2000;
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputPurchaseAmount);

        assertThat(purchaseAmount.getPurchaseAmount()).isEqualTo(2000);
    }

    @DisplayName("model_PurchaseAmount_2000이_입력_했을_때_로또_수량")
    @Test
    public void model_PurchaseAmount_count_lottoQuantity() {
        int inputPurchaseAmount = 2000;
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputPurchaseAmount);

        assertThat(purchaseAmount.getLottoQuantity()).isEqualTo(2);
    }
}