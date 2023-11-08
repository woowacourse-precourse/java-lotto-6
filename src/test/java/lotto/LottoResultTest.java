package lotto;

import lotto.model.LottoResult;
import lotto.service.LottoPrizeMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultTest {

    @DisplayName("정상적으로 결과를 누적하고 수익을 계산해야 한다.")
    @Test
    void addResultTest() {
        LottoResult lottoResult = new LottoResult();
        LottoPrizeMessage prize = LottoPrizeMessage.FIRST_PRIZE;
        int count = 1;

        lottoResult.addResult(prize, count);

        assertEquals(lottoResult.getResultMap().get(prize), Integer.valueOf(count));
        assertEquals(lottoResult.getProfit(), count * prize.getPrizeAmount());
    }

    @DisplayName("상금에 대한 결과를 정상적으로 누적하고 수익을 계산해야 한다.")
    @Test
    void addResultWithDifferentPrizeTest() {
        LottoResult lottoResult = new LottoResult();
        LottoPrizeMessage prize1 = LottoPrizeMessage.FIRST_PRIZE;
        LottoPrizeMessage prize2 = LottoPrizeMessage.SECOND_PRIZE;
        LottoPrizeMessage prize3 = LottoPrizeMessage.THIRD_PRIZE;
        int count1 = 1;
        int count2 = 2;
        int count3 = 3;

        lottoResult.addResult(prize1, count1);
        lottoResult.addResult(prize2, count2);
        lottoResult.addResult(prize3, count3);

        assertEquals(lottoResult.getResultMap().get(prize1), count1);
        assertEquals(lottoResult.getResultMap().get(prize2), count2);
        assertEquals(lottoResult.getResultMap().get(prize3), count3);
        assertEquals(lottoResult.getProfit(),
                (count1 * prize1.getPrizeAmount()) +
                (count2 * prize2.getPrizeAmount()) +
                (count3 * prize3.getPrizeAmount())
        );

    }
}
