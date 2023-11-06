package lotto.module.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static lotto.global.exception.LottoException.*;

class PurchaseAmountTest {

    @Test
    void 최소_구매_금액_미만_익셉션_및_메시지_테스트() {
        // given
        int invalidMinimumPurchase = 999;

        // when
        // then
        Assertions.assertThatThrownBy(() -> PurchaseAmount.newInstance(invalidMinimumPurchase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MINIMUM_PURCHASE_AMOUNT_NOT_MET_VALIDATION.getDefaultMessage());
    }

    @Test
    void 최대_구매_금액_초과_익셉션_및_메시지_테스트() {
        // given
        int invalidMaximumPurchase = 1_000_001_000;

        // when
        // then
        Assertions.assertThatThrownBy(() -> PurchaseAmount.newInstance(invalidMaximumPurchase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MAXIMUM_PURCHASE_AMOUNT_NOT_MET_VALIDATION.getDefaultMessage());
    }

    @Test
    void 구매_금액_단위_익셉션_및_메시지_테스트() {
        // given
        int invalidPurchaseUnit = 1200;

        // when
        // then
        Assertions.assertThatThrownBy(() -> PurchaseAmount.newInstance(invalidPurchaseUnit))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_PURCHASE_AMOUNT_UNIT_VALIDATION.getDefaultMessage());
    }

}