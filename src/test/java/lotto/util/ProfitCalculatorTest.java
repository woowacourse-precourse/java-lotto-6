package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ProfitCalculatorTest {

    @Test
    @DisplayName("총 상금이 0일 때 수익률이 0%인지 확인")
    void shouldReturnZeroWhenPrizeIsZero() {
        // 준비
        int totalCost = 1000;
        long totalPrize = 0;

        // 실행
        float returnRate = ProfitCalculator.calculateLottoReturnRate(totalCost, totalPrize);

        // 검증
        assertThat(returnRate).isZero();
    }

    @Test
    @DisplayName("수익률을 올바르게 계산하는지 확인")
    void shouldCalculateReturnRateCorrectly() {
        // 준비
        int totalCost = 1000;
        long totalPrize = 500; // 50% 수익률

        // 실행
        float returnRate = ProfitCalculator.calculateLottoReturnRate(totalCost, totalPrize);

        // 검증
        assertThat(returnRate).isEqualTo(50.0f);
    }

    @Test
    @DisplayName("큰 숫자도 올바르게 처리하는지 확인")
    void shouldHandleLargeNumbersCorrectly() {
        // 준비
        int totalCost = Integer.MAX_VALUE;
        long totalPrize = Long.MAX_VALUE;

        // 실행
        float returnRate = ProfitCalculator.calculateLottoReturnRate(totalCost, totalPrize);

        // 검증
        assertThat(returnRate).isPositive();
    }

    @Test
    @DisplayName("필요할 때 반올림이 올바르게 되는지 확인")
    void shouldRoundHalfUpCorrectly() {
        // 준비
        int totalCost = 1000;
        long totalPrize = 1234; // 반올림 전 123.4%

        // 실행
        float returnRate = ProfitCalculator.calculateLottoReturnRate(totalCost, totalPrize);

        // 검증
        assertThat(returnRate).isEqualTo(123.4f); // 소수 둘째 자리에서 반올림
    }

    @Test
    @DisplayName("수익률이 음수가 아닌지 확인")
    void shouldNotReturnNegativeReturnRate() {
        // 준비
        int totalCost = 1000;
        long totalPrize = -500;

        // 실행
        float returnRate = ProfitCalculator.calculateLottoReturnRate(totalCost, totalPrize);

        // 검증
        assertThat(returnRate).isNotNegative();
    }

    @Test
    @DisplayName("총 비용이 0일 때 ArithmeticException이 발생하는지 확인")
    void shouldThrowExceptionWhenTotalCostIsZero() {
        // 준비
        int totalCost = 0;
        long totalPrize = 500;

        // 실행 & 검증
        assertThatThrownBy(() -> ProfitCalculator.calculateLottoReturnRate(totalCost, totalPrize))
                .isInstanceOf(ArithmeticException.class);
    }
}

