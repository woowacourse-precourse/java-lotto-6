package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Score;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    @DisplayName("1등, 2등, 당첨실패 테스트")
    void getLottoResultsByEndingMatch() {
        //given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(List.of(10, 11, 12, 13, 14, 15));
        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3);
        GameResult gameResult = new GameResult(lottos, winningLotto);

        //when
        Map<Score, Integer> lottoResults = gameResult.getLottoResults();

        //then
        assertThat(lottoResults.get(Score.FIRST)).isEqualTo(1);
        assertThat(lottoResults.get(Score.SECOND)).isEqualTo(1);
        assertThat(lottoResults.get(Score.MISS)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률은 당첨 총 금액을 구입 금액으로 나눠서 구한다.")
    void calculateRateOfReturnTest() {
        //given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Money money = new Money(3000);
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 11, 12, 13));
        Lotto lotto3 = new Lotto(List.of(10, 11, 12, 13, 14, 15));
        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3);
        GameResult gameResult = new GameResult(lottos, winningLotto);
        double expectedRate = ((double) 10000 / 3000 * 100);
        //when
        double rateOfReturn = gameResult.calculateRateOfReturn(money);

        //then
        assertThat(rateOfReturn).isEqualTo(expectedRate);
    }

}