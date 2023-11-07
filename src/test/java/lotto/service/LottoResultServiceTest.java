package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.List;
import lotto.LottoFixture;
import lotto.Rank;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultServiceTest {
    @DisplayName("당첨 내역을 구한다.")
    @Test
    void calculateRankList() {
        //given
        WinningNumbers winningNumbers = LottoFixture.standard();
        RankCounter rankCounter = new RankCounter();
        LottoResultService lottoResultService = new LottoResultService(winningNumbers, rankCounter);

        //when
        List<Lotto> lottos = LottoFixture.all();
        EnumMap<Rank, Integer> result = lottoResultService.rank(lottos);

        //then
        assertThat(result.values()).containsExactly(3, 1, 1, 1, 1, 1);
    }

    @DisplayName("수익률을 구한다.")
    @Test
    void calculateRateOfReturn() {
        //given
        WinningNumbers winningNumbers = LottoFixture.standard();
        List<Lotto> lottos = LottoFixture.all();
        RankCounter rankCounter = new RankCounter();
        LottoResultService lottoResultService = new LottoResultService(winningNumbers, rankCounter);

        EnumMap<Rank, Integer> result = lottoResultService.rank(lottos);

        //when
        int input = LottoFixture.numberOfFixture() * 1_000;
        double rateOfReturn = lottoResultService.getRateOfReturn(input, result);

        //then
        assertThat(rateOfReturn).isEqualTo((double) 2031555000 / 8000);
    }
}
