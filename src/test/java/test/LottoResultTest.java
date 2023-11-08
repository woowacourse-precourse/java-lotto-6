package test;

import lotto.config.LottoPrize;
import lotto.model.LottoResult;
import lotto.util.Util;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {
    @Test
    void 로또결과_잘들어갔는지() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.setResult(LottoPrize.MATCH_1);
        lottoResult.setResult(LottoPrize.MATCH_5BONUS);
        lottoResult.setResult(LottoPrize.MATCH_5);
        lottoResult.setResult(LottoPrize.MATCH_5BONUS);
        lottoResult.setResult(LottoPrize.MATCH_6);
        lottoResult.setResult(LottoPrize.MATCH_6);
        assertThat(
                lottoResult.getLottoResult().get(LottoPrize.MATCH_5BONUS)
        ).isEqualTo(2);
        assertThat(
                lottoResult.getLottoResult().get(LottoPrize.MATCH_1)
        ).isEqualTo(1);
        assertThat(
                lottoResult.getLottoResult().get(LottoPrize.MATCH_5)
        ).isEqualTo(1);
        assertThat(
                lottoResult.getLottoResult().get(LottoPrize.MATCH_6)
        ).isEqualTo(2);
    }

    @Test
    void 총수익률_계산() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.setResult(LottoPrize.MATCH_1);
        lottoResult.setResult(LottoPrize.MATCH_5BONUS);
        lottoResult.setResult(LottoPrize.MATCH_5);
        lottoResult.setResult(LottoPrize.MATCH_5BONUS);
        lottoResult.setResult(LottoPrize.MATCH_6);
        lottoResult.setResult(LottoPrize.MATCH_6);
        assertThat(
                lottoResult.calculateProfit(5000) + ""
        ).isEqualTo(Util.round(
                (double) ((long) LottoPrize.MATCH_1.getPrizeMoney() +
                        LottoPrize.MATCH_5BONUS.getPrizeMoney() +
                        LottoPrize.MATCH_5.getPrizeMoney() +
                        LottoPrize.MATCH_5BONUS.getPrizeMoney() +
                        LottoPrize.MATCH_6.getPrizeMoney() +
                        LottoPrize.MATCH_6.getPrizeMoney())
                        / 5000) + ""
        );
    }
}
