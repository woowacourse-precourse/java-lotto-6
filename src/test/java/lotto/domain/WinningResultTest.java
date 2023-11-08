package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningResultTest {
    @DisplayName("당첨 결과를 증가시키면 당첨 결과가 올바르게 증가된다.")
    @Test
    void incrementPrizeCount() {
        WinningResult winningResult = new WinningResult(10000);
        winningResult.incrementPrizeCount(Prize.FIRST);
        assertThat(winningResult.searchWinningCountForPrize(Prize.FIRST)).isEqualTo(1);
    }

    @DisplayName("수익률을 계산하면 수익률이 올바르게 계산된다.")
    @Test
    void getEarningRate() {
        WinningResult winningResult = new WinningResult(10000);
        winningResult.incrementPrizeCount(Prize.FIRST);
        assertThat(winningResult.getEarningRate()).isEqualTo(20000000.0);
    }
}