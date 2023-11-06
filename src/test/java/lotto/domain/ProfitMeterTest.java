package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitMeterTest {

    private LinkedHashMap<LottoRank, Integer> winnerCount;

    @BeforeEach
    void setUp() {
        winnerCount = new LinkedHashMap<>();
    }

    @DisplayName("수익률을 올바르게 계산해야 한다")
    @Test
    void calculateYieldCorrectly() {
        // Given
        winnerCount.put(LottoRank.FIFTH, 10);
        winnerCount.put(LottoRank.FOURTH, 3);
        winnerCount.put(LottoRank.SECOND, 2);
        long totalTickets = 3000;
        ProfitMeter profitMeter = new ProfitMeter(winnerCount, totalTickets);

        // When
        BigDecimal yield = profitMeter.calculateYield();

        // Then
        assertThat(yield).isEqualTo(new BigDecimal("2006.7"));
    }

    @DisplayName("당첨되지 않았을 경우 수익률은 0이어야 한다")
    @Test
    void calculateYieldWithNoWinners() {
        // Given
        long totalTickets = 1000;
        ProfitMeter profitMeter = new ProfitMeter(winnerCount, totalTickets);

        // When
        BigDecimal yield = profitMeter.calculateYield();

        // Then
        assertThat(yield.doubleValue()).isEqualTo(0.0);
    }

    @DisplayName("모든 랭크에 당첨된 경우도 수익률을 계산할 수 있어야 한다")
    @Test
    void calculateYieldWithAllRanks() {
        // Given
        winnerCount.put(LottoRank.FIFTH, 100); // 5,000 * 100 = 500,000
        winnerCount.put(LottoRank.FOURTH, 50); // 50,000 * 50 = 2,500,000
        winnerCount.put(LottoRank.THIRD, 10);  // 1,500,000 * 10 = 15,000,000
        winnerCount.put(LottoRank.SECOND, 5);  // 30,000,000 * 5 = 150,000,000
        winnerCount.put(LottoRank.FIRST, 1);   // 2,000,000,000 * 1 = 2,000,000,000
        long totalTickets = 100000;            // 100,000 * 1,000 = 100,000,000 (Total spent)
        ProfitMeter profitMeter = new ProfitMeter(winnerCount, totalTickets);

        // When
        BigDecimal yield = profitMeter.calculateYield();

        // Then
        BigDecimal expectedYield = new BigDecimal("2168.0"); // (2,167,500,000 / 100,000,000) * 100
        assertThat(yield).isEqualTo(expectedYield);
    }
}

