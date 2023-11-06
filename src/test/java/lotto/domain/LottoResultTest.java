package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.TestConstant;
import lotto.constant.LottoConstraint;
import lotto.constant.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;


class LottoResultTest {
    private final LottoResult lottoResult = new LottoResult();

    @DisplayName("당첨 등수의 개수를 증가시킨다.")
    @Test
    void increaseLottoRankCount() {
        lottoResult.increaseLottoRankCount(LottoRank.THREE_MATCH);
        Map<LottoRank, Integer> result = lottoResult.getResult();

        int rankCount = result.get(LottoRank.THREE_MATCH);

        assertThat(rankCount).isEqualTo(1);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculateProfitRate() {
        Payment payment = new Payment(TestConstant.minPaymentAmount);
        lottoResult.increaseLottoRankCount(LottoRank.THREE_MATCH);
        double profitRate = lottoResult.calculateProfitRate(payment);

        assertThat(profitRate).isEqualTo(
        (double) LottoRank.THREE_MATCH.getPrizeMoney()
                / LottoConstraint.PRICE_PER_LOTTO.getValue()
                * 100
        );
    }

    @DisplayName("수익률을 계산한다. - int 범위를 초과하는 큰 값")
    @Test
    void calculateProfitRateWhenBigNumber() {
        Payment payment = new Payment(LottoConstraint.PRICE_PER_LOTTO.getValue());
        for (int i = 0; i < LottoConstraint.MAX_PURCHASE_QUANTITY.getValue(); i++) {
            lottoResult.increaseLottoRankCount(LottoRank.SIX_MATCH);
        }

        double profitRate = lottoResult.calculateProfitRate(payment);

        assertThat(profitRate).isEqualTo(
        (double) LottoRank.SIX_MATCH.getPrizeMoney()
                * LottoConstraint.MAX_PURCHASE_QUANTITY.getValue()
                / LottoConstraint.PRICE_PER_LOTTO.getValue()
                * 100
        );
    }
}
