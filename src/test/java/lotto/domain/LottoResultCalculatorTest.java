package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LottoResultCalculatorTest {

    @Test
    void createLottoResult() {
        LottoResultCalculator resultCalculator = new LottoResultCalculator();
        LottoTickets lottoTickets = new LottoTickets(10000);
        LottoWinningNumbers winningNumbers = new LottoWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoBonusNumber bonusNumber = new LottoBonusNumber(7, List.of(1, 2, 3, 4, 5, 6));

        Map<LottoRankInfo, Integer> lottoResult = resultCalculator.generateLottoResult(lottoTickets, winningNumbers, bonusNumber);

        assertThat(lottoResult.containsKey(LottoRankInfo.FIRST)).isTrue();
        assertThat(lottoResult.containsKey(LottoRankInfo.SECOND)).isTrue();
        assertThat(lottoResult.containsKey(LottoRankInfo.THIRD)).isTrue();
        assertThat(lottoResult.containsKey(LottoRankInfo.FOURTH)).isTrue();
        assertThat(lottoResult.containsKey(LottoRankInfo.FIFTH)).isTrue();
        assertThat(lottoResult.containsKey(LottoRankInfo.NO_WIN)).isTrue();

        int lottoCount = 0;
        for (LottoRankInfo rankInfo : lottoResult.keySet()) {
            lottoCount += lottoResult.get(rankInfo);
        }
        assertThat(lottoCount).isEqualTo(10);
    }
}