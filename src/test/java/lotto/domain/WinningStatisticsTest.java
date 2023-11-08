package lotto.domain;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WinningStatisticsTest {
    private WinningStatistics winningStatistics;

    @BeforeEach
    void setUp() {
        LottoAnswer lottoAnswer = new LottoAnswer("1,2,3,4,5,6", 7);
        List<Lotto> lottoStore = List.of(
                new Lotto(List.of(5, 6, 7, 8, 9, 10)),
                new Lotto(List.of(5, 6, 7, 8, 9, 10)),
                new Lotto(List.of(4, 5, 6, 7, 8, 9)),
                new Lotto(List.of(3, 4, 5, 6, 7, 8)),
                new Lotto(List.of(2, 3, 4, 5, 6, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );

        this.winningStatistics = new WinningStatistics(new LottoStore(lottoStore), lottoAnswer);
    }

    @Test
    @DisplayName("당첨된 등수가 몇 개인지 확인 하는 테스트")
    void testGetMatchingResult() {
        Map<LottoPrize, Integer> result = winningStatistics.getMatchingResult();
        assertEquals(1,result.getOrDefault(LottoPrize.FIRST,0));
        assertEquals(1,result.getOrDefault(LottoPrize.SECOND,0));
        assertEquals(1,result.getOrDefault(LottoPrize.THIRD,0));
        assertEquals(1,result.getOrDefault(LottoPrize.FOURTH,0));
        assertEquals(2,result.getOrDefault(LottoPrize.FIFTH,0));
    }

    @Test
    @DisplayName("수익률 확인 테스트")
    void getReturnRate() {
        Money money = new Money("6000");
        double returnRate = winningStatistics.getReturnRate(money);
        long totalPrize = winningStatistics.getTotalPrize();

        double expectedValue = Math.round(((double) totalPrize/ money.getAmount()) * 100 * 10.0)/10.0;
        assertEquals(expectedValue , returnRate);
    }

    @Test
    @DisplayName("당첨된 총 금액 확인 테스트")
    void getTotalPrize() {
        long totalPrize = winningStatistics.getTotalPrize();
        assertEquals(2_031_560_000L, totalPrize);
    }
}