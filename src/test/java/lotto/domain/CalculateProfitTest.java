package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculateProfitTest {

    private static final int FIFTH_PRIZE_COUNT = 10;
    private static final int FOURTH_PRIZE_COUNT = 3;
    private static final int SECOND_PRIZE_COUNT = 2;
    private static final long TOTAL_TICKETS_FOR_TEST_ONE = 3000;
    private static final long TOTAL_TICKETS_FOR_TEST_TWO = 1000;
    private static final long TOTAL_TICKETS_FOR_TEST_THREE = 100000;
    private static final BigDecimal EXPECTED_RATIO_TEST_ONE = new BigDecimal("2006.7");
    private static final BigDecimal EXPECTED_RATIO_TEST_TWO = BigDecimal.valueOf(0.0);
    private static final BigDecimal EXPECTED_RATIO_TEST_THREE = new BigDecimal("2168.0");

    private LinkedHashMap<LottoRank, Integer> winnerCount;

    @BeforeEach
    void setUp() {
        winnerCount = new LinkedHashMap<>();
    }

    @DisplayName("정확한 수익률을 계산하여야 한다.")
    @Test
    void calculateYieldCorrectly() {

        winnerCount.put(LottoRank.FIFTH, FIFTH_PRIZE_COUNT);
        winnerCount.put(LottoRank.FOURTH, FOURTH_PRIZE_COUNT);
        winnerCount.put(LottoRank.SECOND, SECOND_PRIZE_COUNT);
        CalculateProfit calculateProfit = new CalculateProfit(winnerCount, TOTAL_TICKETS_FOR_TEST_ONE);

        BigDecimal yield = calculateProfit.calculateRatio();

        assertThat(yield).isEqualTo(EXPECTED_RATIO_TEST_ONE);
    }

    @DisplayName("당첨되지 않았을 경우 수익률은 0이어야 한다.")
    @Test
    void calculateRatioWithNoWinners() {
        CalculateProfit calculateProfit = new CalculateProfit(winnerCount, TOTAL_TICKETS_FOR_TEST_TWO);

        BigDecimal ratio = calculateProfit.calculateRatio();

        assertThat(ratio).isEqualTo(EXPECTED_RATIO_TEST_TWO);
    }

    @DisplayName("모든 등수에 당첨되는 경우도 계산이 가능해야 한다.")
    @Test
    void calculateYieldWithAllRanks() {
        winnerCount.put(LottoRank.FIFTH, 100);
        winnerCount.put(LottoRank.FOURTH, 50);
        winnerCount.put(LottoRank.THIRD, 10);
        winnerCount.put(LottoRank.SECOND, 5);
        winnerCount.put(LottoRank.FIRST, 1);
        CalculateProfit calculateProfit = new CalculateProfit(winnerCount, TOTAL_TICKETS_FOR_TEST_THREE);

        BigDecimal yield = calculateProfit.calculateRatio();

        assertThat(yield).isEqualTo(EXPECTED_RATIO_TEST_THREE);
    }
}