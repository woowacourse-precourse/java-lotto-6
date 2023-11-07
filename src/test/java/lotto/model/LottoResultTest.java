package lotto.model;

import static lotto.model.LottoRank.FOUR_MATCH;
import static lotto.model.LottoRank.LESS_THREE_MATCH;
import static lotto.model.LottoRank.THREE_MATCH;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 당첨_등수의_당첨_개수를_증가시킨다() {
        final LottoResult lottoResult = new LottoResult();

        lottoResult.increaseRankCount(THREE_MATCH);
        lottoResult.increaseRankCount(FOUR_MATCH);

        final String outputString = lottoResult.toOutputString();
        assertThat(outputString).contains("3개 일치 (5,000원) - 1개");
        assertThat(outputString).contains("4개 일치 (50,000원) - 1개");
        assertThat(outputString).contains("5개 일치 (1,500,000원) - 0개");
        assertThat(outputString).contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개");
        assertThat(outputString).contains("6개 일치 (2,000,000,000원) - 0개");
    }

    @Test
    void 구매금액을_받아_수익률을_계산한다() {
        final LottoResult lottoResult = new LottoResult();
        lottoResult.increaseRankCount(THREE_MATCH);
        lottoResult.increaseRankCount(LESS_THREE_MATCH);

        final double earningsRate = lottoResult.getEarningsRate();

        assertThat(String.format("%.1f", earningsRate)).isEqualTo("250.0");
    }

}