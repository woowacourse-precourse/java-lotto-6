package lotto.domain;

import static lotto.error.ErrorMessage.INVALID_PURCHASE_AMOUNT_FORMAT;
import static lotto.error.ErrorMessage.NEGATIVE_PURCHASE_AMOUNT;
import static lotto.error.ErrorMessage.NOT_DIVIDED_PURCHASE_AMOUNT;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {
    @DisplayName("구매 금액 검증이 가능하다.")
    @Test
    void validatePurchaseAmountTest() {
        assertAll(
                () -> assertThatThrownBy(() -> PurchaseAmount.of("love"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(INVALID_PURCHASE_AMOUNT_FORMAT),
                () -> assertThatThrownBy(() -> PurchaseAmount.of("-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(NEGATIVE_PURCHASE_AMOUNT),
                () -> assertThatThrownBy(() -> PurchaseAmount.of("1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(NOT_DIVIDED_PURCHASE_AMOUNT),
                () -> assertThatCode(() -> PurchaseAmount.of("1000"))
                        .doesNotThrowAnyException()
        );
    }
}