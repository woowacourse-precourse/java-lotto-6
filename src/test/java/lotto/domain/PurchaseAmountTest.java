package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    @DisplayName("구입 금액이 0원이면 예외가 발생한다")
    @Test
    void createPurchaseAmountByZero() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseAmount(0L));
    }

    @DisplayName("구입 금액이 단위로 나누어 떨어지지 않으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(longs = {1L, 999L, 1001L, 9999L})
    void createPurchaseAmountByNotDivisibleAmount(long purchaseAmount) {

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new PurchaseAmount(purchaseAmount));
    }

    @DisplayName("로또 가격으로 구매 수량을 계산할 수 있다")
    @ParameterizedTest
    @CsvSource("""
            1000, 1
            2000, 2
            100000, 10
            """)
    void getQuantityByLottoPrice(long purchaseAmount, long expected) {

        PurchaseAmount createdPurchaseAmount = new PurchaseAmount(purchaseAmount);

        long actual = createdPurchaseAmount.getQuantity(1000);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
