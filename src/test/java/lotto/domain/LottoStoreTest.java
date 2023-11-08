package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.LottoStore;
import org.junit.jupiter.api.Test;


class LottoStoreTest {

    @Test
    void 금액에_따른_로또_발급_테스트() {
        int amount = 12000;
        int count = 12;

        assertThat(LottoStore.lottoIssuance(amount).size())
                .isEqualTo(count);
    }

    @Test
    void 로또_결과메시지_생성_테스트() {
        LottoStore lottoStore = new LottoStore();

        int[] lottoResults = {0, 0, 0, 0, 0, 1};
        double rateOfReturn = 62.5;

        String result = "당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개\n" +
                "총 수익률은 62.5%입니다.";

        assertThat(lottoStore.getLottoResultsSummary(lottoResults, rateOfReturn))
                .isEqualTo(result);
    }


}