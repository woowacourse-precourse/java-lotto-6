package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @Test
    @DisplayName("최소 한 장의 로또 구입 단위로 객체가 생성된다")
    void createPurchaseAmountClass() {
        // given
        int purchaseAmountValue = PurchaseAmount.LOTTO_PRICE;

        // when
        PurchaseAmount purchaseAmount = PurchaseAmount.from(purchaseAmountValue);

        // then
        assertThat(purchaseAmount).isNotNull();
    }

    @Test
    @DisplayName("입력 값이 최소 한 장의 로또 구입 단위보다 작은 경우 예외를 발생")
    void throwExceptionIfLessThanPriceOfSingleLotto() {
        // given
        int purchaseAmountValue = PurchaseAmount.LOTTO_PRICE - 1;

        // when
        // then
        assertThatThrownBy(() -> PurchaseAmount.from(purchaseAmountValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PurchaseAmount.PURCHASABILITY_EXCEPTION);
    }

    @Test
    @DisplayName("입력 값이 한 장의 로또 구입 단위로 나누어 떨어지지 않을 경우 예외를 발생")
    void throwExceptionIfNotMultiplePriceOfSingleLotto() {
        // given
        int purchaseAmountValue = PurchaseAmount.LOTTO_PRICE + 1;

        // when
        // then
        assertThatThrownBy(() -> PurchaseAmount.from(purchaseAmountValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PurchaseAmount.LOTTO_PRICE_UNITS_EXCEPTION);
    }
}