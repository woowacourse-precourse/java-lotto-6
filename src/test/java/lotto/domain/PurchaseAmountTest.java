package lotto.domain;

import static lotto.error.ErrorMessage.INVALID_PURCHASE_AMOUNT_FORMAT;
import static lotto.error.ErrorMessage.NEGATIVE_PURCHASE_AMOUNT;
import static lotto.error.ErrorMessage.NOT_DIVIDED_PURCHASE_AMOUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {
    @DisplayName("구매 금액 생성 시 검증이 가능하다.")
    @Test
    void ofTest() {
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

    @DisplayName("금액에 알맞은 개수의 복권 개수를 반환할 수 있다.")
    @Test
    void getCountTest() {
        PurchaseAmount purchaseAmount = PurchaseAmount.of("8000");
        assertThat(purchaseAmount.getCount()).isEqualTo(8);
    }

    @DisplayName("수익률을 구할 수 있다.")
    @Test
    void rateOfReturnTest() {
        PurchaseAmount purchaseAmount = PurchaseAmount.of("8000");
        assertThat(purchaseAmount.rateOfReturn(800)).isEqualTo(10);
    }
}