package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.enums.Score;
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

}