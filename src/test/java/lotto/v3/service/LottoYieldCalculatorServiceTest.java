package lotto.v3.service;

import lotto.v3.model.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.within;

class LottoYieldCalculatorServiceTest {

    @Test
    @DisplayName("당첨 수와 구매한 번호를 기반으로 정확한 수익률 계산")
    void testCalculateYield() {
        // Given
        LottoYieldCalculatorService yieldCalculator = new LottoYieldCalculatorService();
        Map<LottoRank, Integer> matchCounts = new EnumMap<>(LottoRank.class);

        matchCounts.put(LottoRank.FIRST, 1);
        matchCounts.put(LottoRank.THIRD, 5);
        int purchasedTickets = 300;


        // When
        double yield = yieldCalculator.calculateYield(matchCounts, purchasedTickets);

        // Then
        assertThat(yield).isEqualTo(669166.67, within(0.01));
    }
}