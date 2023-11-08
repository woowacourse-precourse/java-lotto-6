package lotto;

import lotto.utils.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculationTest {

    private Calculation calculation;
    private WinningNumber winningNumber;

    @BeforeEach
    void setUp() {
        calculation = new Calculation();
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        winningNumber = new WinningNumber(winningLotto, 45);
    }

    @Test
    @DisplayName("각 등수별로 적절하게 계산하는가?")
    void calculateRankCountTest() {
        Lotto firstRankLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto secondRankLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45));
        Lotto thirdRankLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9));
        Lotto fifthRankLotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        List<Lotto> lottos = Arrays.asList(firstRankLotto, secondRankLotto, thirdRankLotto, fifthRankLotto);

        assertEquals(1, calculation.calculateRankCount(lottos, winningNumber, Rank.FIRST));
        assertEquals(1, calculation.calculateRankCount(lottos, winningNumber, Rank.SECOND)); // 보너스 번호 없음
        assertEquals(1, calculation.calculateRankCount(lottos, winningNumber, Rank.THIRD));
        assertEquals(0, calculation.calculateRankCount(lottos, winningNumber, Rank.FOURTH)); // 매칭 번호 수 부족
        assertEquals(1, calculation.calculateRankCount(lottos, winningNumber, Rank.FIFTH));
    }

    @Test
    @DisplayName("수익률을 적절하게 계산하는가?")
    void calculateProfitRateTest() {
        // 가정: 5등 로또 1장 구매, 총 구매 금액은 1000원
        Lotto fifthRankLotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        List<Lotto> lottos = Arrays.asList(fifthRankLotto);
        Map<Rank, Integer> rankCounts = calculation.calculateAllRankCounts(lottos, winningNumber);
        int purchaseAmount = 1000;

        double profitRate = calculation.calculateProfitRate(rankCounts, purchaseAmount);

        double expectedProfit = (Rank.FIFTH.getPrize() / (double) purchaseAmount) * 100;
        assertEquals(expectedProfit, profitRate, "수익률 계산이 올바르지 않습니다.");
    }

    @Test
    @DisplayName("다양한 등수의 로또가 있을 때 수익률을 적절하게 계산하는가?")
    void calculateVariousRanksProfitRateTest() {
        Map<Rank, Integer> rankCounts = Map.of(
                Rank.FIRST, 1,
                Rank.SECOND, 1,
                Rank.THIRD, 1,
                Rank.FIFTH, 1
        );

        int purchaseAmount = 4000;
        double profitRate = calculation.calculateProfitRate(rankCounts, purchaseAmount);
        long totalPrize = rankCounts.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * (long)entry.getValue())
                .sum();
        double expectedProfitRate = (double)totalPrize / purchaseAmount * 100;

        assertEquals(expectedProfitRate, profitRate, "수익률 계산이 올바르지 않습니다.");
    }

}
