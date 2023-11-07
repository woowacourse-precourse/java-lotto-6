package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ResultStaticsTest {
    ResultStatics statics;
    Lottos lottos;
    LottoResult lottoResult;

    @DisplayName("총 수익률은 구매한 로또 금액과 당첨 금액을 나눈 후, 100을 곱한 값이다.")
    @Test
    void calculateEarningRate() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18))
        );
        lottoResult = new LottoResult(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 8);
        lottos = new Lottos(lottoList);
        statics = lottos.calculateResult(lottoResult);

        double earningRate = statics.getEarningRate();
        int phrasedMoney = statics.getPhrasedMoney();
        long totalEarning = statics.calculateTotalEarning();

        assertThat(earningRate)
                .isEqualTo(((double) totalEarning / phrasedMoney) * 100);
    }

    @DisplayName("5개가 일치하고, 보너스 번호가 포함된다면 2등 금액을 수령한다.")
    @Test
    void matchFiveNumberAndContainBonusNumber() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18))
        );
        lottoResult = new LottoResult(new Lotto(List.of(1, 2, 3, 4, 5, 9)), 6);
        lottos = new Lottos(lottoList);
        statics = lottos.calculateResult(lottoResult);

        assertThat(statics.getTotalEarning())
                .isEqualTo(LottoPrize.SECOND_PRIZE.getPrizeMoney());
    }

    @DisplayName("5개가 일치하고 보너스 번호가 포함되지 않는다면, 3등 금액을 수령한다.")
    @Test
    void matchFiveNumberAndNotContainBonusNumber() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18))
        );
        lottoResult = new LottoResult(new Lotto(List.of(1, 2, 3, 4, 5, 9)), 10);
        lottos = new Lottos(lottoList);
        statics = lottos.calculateResult(lottoResult);
        assertThat(statics.getTotalEarning())
                .isEqualTo(LottoPrize.THIRD_PRIZE.getPrizeMoney());
    }
}