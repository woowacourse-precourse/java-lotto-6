package lotto.domain;

import lotto.global.constant.LottoRankAndPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultTest {

    @DisplayName("총 상금을 검사하는 기능 테스트")
    @Test
    public void testCalculateTotalPrize() {
        LottoResult lottoResult = new LottoResult(10000);

        lottoResult.accumulateLottoResult(LottoRankAndPrize.FIRST_RANK);
        lottoResult.accumulateLottoResult(LottoRankAndPrize.SECOND_RANK);
        lottoResult.accumulateLottoResult(LottoRankAndPrize.NO_RANK);

        int totalPrize = lottoResult.calculateTotalPrize();

        assertEquals(2030000000, totalPrize);
    }

    @DisplayName("총 수익률을 계산하는 기능 테스트")
    @Test
    public void testCalculateProfitPercentage() {
        LottoResult lottoResult = new LottoResult(8000);

        lottoResult.accumulateLottoResult(LottoRankAndPrize.FIFTH_RANK);
        double percentage = lottoResult.calculateProfitPercentage();

        assertEquals(62.5, percentage);
    }

    @DisplayName("수익을 계산하는 기능 테스트")
    @Test
    public void testCalculateProfit() {
        LottoResult lottoResult = new LottoResult(10000);

        lottoResult.accumulateLottoResult(LottoRankAndPrize.FIRST_RANK);
        lottoResult.accumulateLottoResult(LottoRankAndPrize.SECOND_RANK);
        lottoResult.accumulateLottoResult(LottoRankAndPrize.NO_RANK);

        long profit = 2030000000 - 10000;

        int calculatedProfit = lottoResult.calculateProfit();

        assertEquals(profit, calculatedProfit);
    }
}
