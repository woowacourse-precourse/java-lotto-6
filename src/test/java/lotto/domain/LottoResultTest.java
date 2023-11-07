package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.constant.Constants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;

class LottoResultTest {
    private final LottoResult lottoResult = new LottoResult();

    @DisplayName("당첨 등수의 개수를 증가시킨다.")
    @Test
    void increaseLottoRankCount() {
        lottoResult.increaseLottoRankCount(Rank.THREE_MATCH);
        Map<Rank, Integer> result = lottoResult.getResult();

        int rankCount = result.get(Rank.THREE_MATCH);

        assertThat(rankCount).isEqualTo(1);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculateProfitRate() {
        Payment payment = new Payment(Constants.LOTTO_PRICE);
        lottoResult.increaseLottoRankCount(Rank.THREE_MATCH);
        double profitRate = lottoResult.calculateProfitRate(payment);

        assertThat(profitRate).isEqualTo(
        (double) Rank.THREE_MATCH.getPrizeMoney()
                / Constants.LOTTO_PRICE
                * 100
        );
    }

    @DisplayName("수익률을 계산한다. - int 범위를 초과하는 큰 값")
    @Test
    void calculateProfitRateWhenBigNumber() {
        Payment payment = new Payment(Constants.LOTTO_PRICE);
        for (int i = 0; i < Constants.MAX_PURCHASE_QUANTITY; i++) {
            lottoResult.increaseLottoRankCount(Rank.SIX_MATCH);
        }

        double profitRate = lottoResult.calculateProfitRate(payment);

        assertThat(profitRate).isEqualTo(
        (double) Rank.SIX_MATCH.getPrizeMoney()
                * Constants.MAX_PURCHASE_QUANTITY
                / Constants.LOTTO_PRICE
                * 100
        );
    }
}