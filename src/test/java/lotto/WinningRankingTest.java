package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningRankingTest {

    @DisplayName("당첨번호가 5개 일치하고 보너스 볼이 일치하면 2등이다.")
    @Test
    void getWinningRanking_Second() {
        // given
        int countOfMatch = WinningRanking.SECOND.getCountOfMatch();
        boolean matchOfBonusNumber = true;

        // when
        WinningRanking winningRanking = WinningRanking.getWinningRanking(countOfMatch, matchOfBonusNumber);

        // then
        assertThat(winningRanking).isEqualTo(WinningRanking.SECOND);
    }

    @DisplayName("당첨번호가 5개 일치하고 보너스 볼이 일치하지 않으면 3등이다.")
    @Test
    void getWinningRanking_Third() {
        // given
        int countOfMatch = WinningRanking.SECOND.getCountOfMatch();
        boolean matchOfBonusNumber = false;

        // when
        WinningRanking winningRanking = WinningRanking.getWinningRanking(countOfMatch, matchOfBonusNumber);

        // then
        assertThat(winningRanking).isEqualTo(WinningRanking.THIRD);
    }
}
