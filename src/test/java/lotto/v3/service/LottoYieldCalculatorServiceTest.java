//package lotto.v3.service;
//
//import lotto.v3.model.LottoRank;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import java.util.EnumMap;
//import java.util.Map;
//
//import static lotto.v3.util.LottoConstants.LOTTO_PRICE;
//import static org.assertj.core.api.Assertions.assertThat;
//
//class LottoYieldCalculatorServiceTest {
//
//    @Test
//    @DisplayName("당첨 횟수를 주어졌을 때 수익률 계산하면 올바른 수익률 백분율을 반환한다")
//    void calculateYield_WithGivenMatchCounts_ThenReturnsCorrectYieldPercentage() {
//        // Given
//        Map<LottoRank, Integer> matchCounts = new EnumMap<>(LottoRank.class);
//        matchCounts.put(LottoRank.FIRST, 1); // 1 * 2_000_000_000
//        matchCounts.put(LottoRank.SECOND, 1); // 1 * 30_000_000
//        matchCounts.put(LottoRank.THIRD, 1); // 1 * 1_500_000
//        matchCounts.put(LottoRank.FOURTH, 1); // 1 * 50_000
//        matchCounts.put(LottoRank.FIFTH, 1); // 1 * 5_000
//        int purchasedTickets = 5; // 총 구매한 티켓 수
//        long expectedTotalSpent = purchasedTickets * LOTTO_PRICE.getValue();
//
//        LottoYieldCalculatorService yieldCalculatorService = new LottoYieldCalculatorService();
//
//        // When
//        double actualYield = yieldCalculatorService.calculateYield(matchCounts);
//
//        // Then
//        long expectedTotalReward = 2_000_000_000L + 30_000_000L + 1_500_000L + 50_000L + 5_000L;
//        double expectedYield = (double) expectedTotalReward / expectedTotalSpent * 100.0;
//
//        assertThat(actualYield)
//                .as("수익률 계산")
//                .isEqualTo(expectedYield);
//    }
//}
