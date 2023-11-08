package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("수익률 도메인에")
class EarningRateTest {

    @DisplayName("값 확인 요청시")
    @Nested
    class ToValue {

        @DisplayName("수익이 있는 경우 정상 값이 확인된다.")
        @Test
        void hasProfit() {
            // given
            final int useMoney = 1000;
            final PurchaseAmount purchaseAmount = new PurchaseAmount(useMoney);
            final Integer profit = 3000;
            final EarningRate earningRate = new EarningRate(profit, purchaseAmount);

            // when
            final Double result = earningRate.toValue();

            // given
            assertThat(result).isEqualTo(profit.doubleValue() / useMoney * 100);
        }

        @DisplayName("수익이 없는 경우 0이 확인된다.")
        @Test
        void zeroProfit() {
            // given
            final int useMoney = 1000;
            final PurchaseAmount purchaseAmount = new PurchaseAmount(useMoney);
            final int profit = 0;
            final EarningRate earningRate = new EarningRate(profit, purchaseAmount);

            // when
            final Double result = earningRate.toValue();

            // given
            assertThat(result).isZero();
        }
    }

    @DisplayName("생성시 음수의 이윤의 경우 예외를 던진다.")
    @Test
    void createValidation() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new EarningRate(-1000, new PurchaseAmount(1000)))
                .isInstanceOf(IllegalStateException.class);
    }
}
