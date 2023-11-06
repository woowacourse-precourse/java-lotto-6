package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 당첨_등수의_당첨_개수를_증가시킨다() {
        final LottoResult lottoResult = new LottoResult();

        lottoResult.increaseRankCount(LottoRank.THREE_MATCH);
        lottoResult.increaseRankCount(LottoRank.FOUR_MATCH);

        final String outputString = lottoResult.toOutputString();
        Assertions.assertThat(outputString).contains("3개 일치 (5,000원) - 1개");
        Assertions.assertThat(outputString).contains("4개 일치 (50,000원) - 1개");
        Assertions.assertThat(outputString).contains("5개 일치 (1,500,000원) - 0개");
        Assertions.assertThat(outputString).contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 0개");
        Assertions.assertThat(outputString).contains("6개 일치 (2,000,000,000원) - 0개");
    }

}