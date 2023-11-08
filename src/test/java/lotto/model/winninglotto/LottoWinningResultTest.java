package lotto.model.winninglotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.EnumMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinningResultTest {

    @Test
    @DisplayName("LottoWinningResult는 로또 당첨 순위와 당첨 갯수를 가지고 있다")
    void getLottoProfitRateTest2() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> thirdRankingNumbers = List.of(1, 2, 3, 8, 9, 10);

        WinningLotto winningLotto = WinningLotto.createWinningLotto(winningNumbers, 7);
        Lotto firstRankingLotto = Lotto.issueChooseNumbersLotto(winningNumbers);
        Lotto thirdRankingLotto = Lotto.issueChooseNumbersLotto(thirdRankingNumbers);

        EnumMap<LottoRanking, Integer> lottoResult = winningLotto
            .getLottoResult(List.of(firstRankingLotto, thirdRankingLotto))
            .getLottoResult();

        assertAll(
            () -> assertThat(lottoResult.get(LottoRanking.FIRST)).isEqualTo(1),
            () -> assertThat(lottoResult.get(LottoRanking.SECOND)).isNull(),
            () -> assertThat(lottoResult.get(LottoRanking.THIRD)).isNull(),
            () -> assertThat(lottoResult.get(LottoRanking.FOURTH)).isNull(),
            () -> assertThat(lottoResult.get(LottoRanking.FIFTH)).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("LottoWinningResult를 통해 수익률을 계산할 수 있다")
    void getLottoProfitRateTest() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);

        WinningLotto winningLotto = WinningLotto.createWinningLotto(lottoNumbers, 7);
        Lotto lotto = Lotto.issueChooseNumbersLotto(lottoNumbers);

        LottoWinningResult lottoResult = winningLotto.getLottoResult(List.of(lotto));

        double lottoProfitRate = lottoResult.getLottoProfitRate(
            LottoRanking.FIRST.getWinningAmount());
        assertThat(lottoProfitRate).isEqualTo(100);
    }
}
