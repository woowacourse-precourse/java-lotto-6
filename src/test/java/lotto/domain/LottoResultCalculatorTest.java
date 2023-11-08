package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LottoResultCalculatorTest {

    @DisplayName("로또 당첨 결과를 만들고 정상적으로 데이터가 들어가있는지 확인한다.")
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