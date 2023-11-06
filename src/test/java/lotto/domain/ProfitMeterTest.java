package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitMeterTest {

    private static final int FIFTH_PRIZE_COUNT = 10;
    private static final int FOURTH_PRIZE_COUNT = 3;
    private static final int SECOND_PRIZE_COUNT = 2;
    private static final long TOTAL_TICKETS_FOR_TEST_ONE = 3000;
    private static final long TOTAL_TICKETS_FOR_TEST_TWO = 1000;
    private static final long TOTAL_TICKETS_FOR_TEST_THREE = 100000;
    private static final BigDecimal EXPECTED_YIELD_TEST_ONE = new BigDecimal("2006.7");
    private static final BigDecimal EXPECTED_YIELD_TEST_TWO = BigDecimal.valueOf(0.0);
    private static final BigDecimal EXPECTED_YIELD_TEST_THREE = new BigDecimal("2168.0");

    private LinkedHashMap<LottoRank, Integer> winnerCount;

    @BeforeEach
    void setUp() {
        winnerCount = new LinkedHashMap<>();
    }

    @DisplayName("수익률을 올바르게 계산해야 한다")
    @Test
    void calculateYieldCorrectly() {
        // Given
        winnerCount.put(LottoRank.FIFTH, FIFTH_PRIZE_COUNT);
        winnerCount.put(LottoRank.FOURTH, FOURTH_PRIZE_COUNT);
        winnerCount.put(LottoRank.SECOND, SECOND_PRIZE_COUNT);
        ProfitMeter profitMeter = new ProfitMeter(winnerCount, TOTAL_TICKETS_FOR_TEST_ONE);

        // When
        BigDecimal yield = profitMeter.calculateYield();

        // Then
        assertThat(yield).isEqualTo(EXPECTED_YIELD_TEST_ONE);
    }

    @DisplayName("당첨되지 않았을 경우 수익률은 0이어야 한다")
    @Test
    void calculateYieldWithNoWinners() {
        // Given
        ProfitMeter profitMeter = new ProfitMeter(winnerCount, TOTAL_TICKETS_FOR_TEST_TWO);

        // When
        BigDecimal yield = profitMeter.calculateYield();

        // Then
        assertThat(yield).isEqualTo(EXPECTED_YIELD_TEST_TWO);
    }

    @DisplayName("모든 랭크에 당첨된 경우도 수익률을 계산할 수 있어야 한다")
    @Test
    void calculateYieldWithAllRanks() {
        // Given
        winnerCount.put(LottoRank.FIFTH, 100);
        winnerCount.put(LottoRank.FOURTH, 50);
        winnerCount.put(LottoRank.THIRD, 10);
        winnerCount.put(LottoRank.SECOND, 5);
        winnerCount.put(LottoRank.FIRST, 1);
        ProfitMeter profitMeter = new ProfitMeter(winnerCount, TOTAL_TICKETS_FOR_TEST_THREE);

        // When
        BigDecimal yield = profitMeter.calculateYield();

        // Then
        assertThat(yield).isEqualTo(EXPECTED_YIELD_TEST_THREE);
    }
}


