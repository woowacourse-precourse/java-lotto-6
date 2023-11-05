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
        winnerCount.put(LottoRank.FIRST, 1);
        long totalTickets = 3000;
        ProfitMeter profitMeter = new ProfitMeter(winnerCount, totalTickets);

        // When
        BigDecimal yield = profitMeter.calculateYield();

        // Then
        assertThat(yield).isEqualTo(new BigDecimal("66668.3"));
    }

}

