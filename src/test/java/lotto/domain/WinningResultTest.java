package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.constant.NumberConstant.FIRST_PRIZE;
import static org.assertj.core.api.Assertions.*;

class WinningResultTest {

    @DisplayName("당첨금과 구입 금액으로부터 수익률을 계산한다.")
    @Test
    void calculateEarningsRate() {
        // given
        LottoGame lottoGame = LottoGame.createLottoGame(10000);
        WinningResult winningResult = new WinningResult();
        winningResult.winRank(6, false);

        // when
        double earningsRate = winningResult.calculateEarningsRate(lottoGame);

        // then
        assertThat(earningsRate).isEqualTo((double) FIRST_PRIZE / 10000 * 100);
    }
}