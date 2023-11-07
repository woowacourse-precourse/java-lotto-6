package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {
    private GameResult gameResult;

    @BeforeEach
    void setUp() {
        gameResult = new GameResult();
    }

    @DisplayName("일치하는 숫자가 3개 미만이면 당첨 등급은 NO_WINS 이다.")
    @Test
    void setRankingsForNoWins() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10));
        boolean hasBonusNumber = false;

        gameResult.setRankingNumbers(winningLotto, lotto, hasBonusNumber);

        assertThat(gameResult.getRankings()).containsExactly(Ranking.NO_WINS);
    }

    @DisplayName("5개의 번호가 일치하고 보너스 번호가 있으면 당첨 등급은 FIVE_PLUS_BONUS 이다.")
    @Test
    void setRankingsForFivePlusBonus() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        boolean hasBonusNumber = true;

        gameResult.setRankingNumbers(winningLotto, lotto, hasBonusNumber);

        assertThat(gameResult.getRankings()).containsExactly(Ranking.FIVE_PLUS_BONUS);
    }

    @DisplayName("5개의 번호가 일치하고 보너스 번호가 없으면 당첨 등급은 FIVE_WINS 이다.")
    @Test
    void setRankingsForFiveWins() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        boolean hasBonusNumber = false;

        gameResult.setRankingNumbers(winningLotto, lotto, hasBonusNumber);

        assertThat(gameResult.getRankings()).containsExactly(Ranking.FIVE_WINS);
    }
}
