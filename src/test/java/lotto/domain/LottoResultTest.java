package lotto.domain;

import lotto.global.constant.LottoRankAndPrize;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultTest {

    @Test
    public void testCalculateTotalPrize() {
        LottoResult lottoResult = new LottoResult(10000);

        lottoResult.accumulateLottoResult(LottoRankAndPrize.FIRST_RANK);
        lottoResult.accumulateLottoResult(LottoRankAndPrize.SECOND_RANK);
        lottoResult.accumulateLottoResult(LottoRankAndPrize.NO_RANK);

        int totalPrize = lottoResult.calculateTotalPrize();

        assertEquals(2030000000, totalPrize);
    }

    @Test
    public void testCalculateProfitPercentage() {
        // 테스트할 LottoResult 객체 생성
        LottoResult lottoResult = new LottoResult(8000); // 예시로 로또 구매 가격을 10,000원으로 설정

        lottoResult.accumulateLottoResult(LottoRankAndPrize.FIFTH_RANK);
        double percentage = lottoResult.calculateProfitPercentage();

        // 예상되는 결과와 계산된 결과를 비교
        assertEquals(62.5, percentage);
    }

    @Test
    public void testCalculateProfit() {
        // 테스트할 LottoResult 객체 생성
        LottoResult lottoResult = new LottoResult(10000); // 예시로 로또 구매 가격을 10,000원으로 설정

        lottoResult.accumulateLottoResult(LottoRankAndPrize.FIRST_RANK);
        lottoResult.accumulateLottoResult(LottoRankAndPrize.SECOND_RANK);
        lottoResult.accumulateLottoResult(LottoRankAndPrize.NO_RANK);

        // 예상되는 총 수익을 설정
        long profit = 2030000000 - 10000; // 총 수익 = 총 상금 - 로또 구매 가격

        // calculateProfit 함수를 호출하여 수익을 계산
        int calculatedProfit = lottoResult.calculateProfit();

        // 예상되는 결과와 계산된 결과를 비교
        assertEquals(profit, calculatedProfit);
    }
}
