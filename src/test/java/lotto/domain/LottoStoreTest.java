package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;


class LottoStoreTest {

    @Test
    void getLottoResultsSummary() {
        LottoStore lottoStore = new LottoStore();

        int[] lottoResults = {0,0,0,0,0,1};
        double rateOfReturn = 62.5;

        String result = "당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 62.5%입니다.";

        assertThat(lottoStore.getLottoResultsSummary(lottoResults,rateOfReturn))
                .isEqualTo(result);

    }
}