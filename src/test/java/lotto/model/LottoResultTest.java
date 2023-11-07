package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LottoResultTest {

    @Test
    @DisplayName("로또 결과를 정상적으로 추가하고 조회한다")
    void addResultAndGetCount() {
        LottoResult lottoResult = new LottoResult(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7));

        lottoResult.addResult(3, false);
        lottoResult.addResult(4, false);
        lottoResult.addResult(5, false);
        lottoResult.addResult(5, true);
        lottoResult.addResult(6, false);

        assertEquals(1, lottoResult.getCount(Rank.FIFTH));
        assertEquals(1, lottoResult.getCount(Rank.FOURTH));
        assertEquals(1, lottoResult.getCount(Rank.THIRD));
        assertEquals(1, lottoResult.getCount(Rank.SECOND));
        assertEquals(1, lottoResult.getCount(Rank.FIRST));
    }

    @Test
    @DisplayName("로또 결과의 수익률을 계산한다")
    void calculateWinningRate() {
        LottoResult lottoResult = new LottoResult(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7));
        lottoResult.addResult(3, false);
        lottoResult.addResult(4, false);
        lottoResult.addResult(5, false);
        lottoResult.addResult(5, true);
        lottoResult.addResult(6, false);

        int purchaseAmount = 5000;
        double expectedWinningRate = 40631000.0;
        assertEquals(expectedWinningRate, lottoResult.calculateWinningRate(purchaseAmount));
    }
}
