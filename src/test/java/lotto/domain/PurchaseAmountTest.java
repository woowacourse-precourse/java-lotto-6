package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
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

    @DisplayName("수익률을 구할 수 있다")
    @ParameterizedTest
    @MethodSource
    void getRateOfReturn(PurchaseAmount purchaseAmount, long totalPrize, BigDecimal expected) {

        BigDecimal actual = purchaseAmount.getRateOfReturn(totalPrize);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> getRateOfReturn() {
        return Stream.of(
                Arguments.of(new PurchaseAmount(10000), 5000, new BigDecimal("50.0")),
                Arguments.of(new PurchaseAmount(8000), 5000, new BigDecimal("62.5")),
                Arguments.of(new PurchaseAmount(1000), 200000000, new BigDecimal("20000000.0"))
        );
    }
}
