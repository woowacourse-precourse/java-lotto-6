package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.constant.NumberConstant.FIRST_PRIZE;
import static org.assertj.core.api.Assertions.*;

class WinningResultTest {

    @DisplayName("당첨 번호와 일치하는 숫자의 갯수와 보너스 번호 일치 여부로 순위를 계산한다.")
    @Test
    void winRank() {
        // given
        WinningResult winningResult1 = WinningResult.create();
        WinningResult winningResult2 = WinningResult.create();
        WinningResult winningResult3 = WinningResult.create();
        WinningResult winningResult4 = WinningResult.create();
        WinningResult winningResult5 = WinningResult.create();

        // when
        winningResult1.winRank(6, false);
        winningResult2.winRank(5, true);
        winningResult3.winRank(5, false);
        winningResult4.winRank(4, false);
        winningResult5.winRank(3, false);

        // then
        assertThat(winningResult1.getRank1()).isEqualTo(1);
        assertThat(winningResult2.getRank2()).isEqualTo(1);
        assertThat(winningResult3.getRank3()).isEqualTo(1);
        assertThat(winningResult4.getRank4()).isEqualTo(1);
        assertThat(winningResult5.getRank5()).isEqualTo(1);
    }

    @DisplayName("당첨금과 구입 금액으로부터 수익률을 계산한다.")
    @Test
    void calculateEarningsRate() {
        // given
        LottoGame lottoGame = LottoGame.createLottoGame(10000);
        WinningResult winningResult = WinningResult.create();
        winningResult.winRank(6, false);

        // when
        double earningsRate = winningResult.calculateEarningsRate(lottoGame);

        // then
        assertThat(earningsRate).isEqualTo((double) FIRST_PRIZE / 10000 * 100);
    }
}