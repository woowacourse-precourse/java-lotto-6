package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.TestConstant;
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

        assertThat(profitRate).isEqualTo(500);
    }
}
