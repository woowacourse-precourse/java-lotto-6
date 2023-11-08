package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningPrizeTest {
    @DisplayName("1등 당첨")
    @Test
    void getFirstPrizeWinnigPrize() {
        WinningPrize winningPrize = WinningPrize.valueOf(6, false);
        assertThat(winningPrize).isSameAs(WinningPrize.FIRST_PRIZE);
    }

    @DisplayName("2등 당첨")
    @Test
    void getSecondPrizeWinnigPrize() {
        WinningPrize winningPrize = WinningPrize.valueOf(5, true);
        assertThat(winningPrize).isSameAs(WinningPrize.SECOND_PRIZE);
    }

    @DisplayName("3등 당첨")
    @Test
    void getThirdPrizeWinningPrize() {
        WinningPrize winningPrize = WinningPrize.valueOf(5, false);
        assertThat(winningPrize).isSameAs(WinningPrize.THIRD_PRIZE);
    }

    @DisplayName("4등 당첨")
    @Test
    void getFourthPrizeWinningPrizeWhenIsBonusFalse() {
        WinningPrize winningPrize = WinningPrize.valueOf(4, false);
        assertThat(winningPrize).isSameAs(WinningPrize.FOURTH_PRIZE);
    }

    @DisplayName("보너스 번호를 맞춰도, 4등 당첨")
    @Test
    void getFourthPrizeWinningPrizeWhenIsBonusTrue() {
        WinningPrize winningPrize = WinningPrize.valueOf(4, true);
        assertThat(winningPrize).isSameAs(WinningPrize.FOURTH_PRIZE);
    }

    @DisplayName("5등 당첨")
    @Test
    void getFifthPrizeWinningPrizeWhenIsBonusFalse() {
        WinningPrize winningPrize = WinningPrize.valueOf(3, false);
        assertThat(winningPrize).isSameAs(WinningPrize.FIFTH_PRIZE);
    }

    @DisplayName("보너스 번호를 맞춰도, 5등 당첨")
    @Test
    void getFifthPrizeWinningPrizeWhenIsBonusTrue() {
        WinningPrize winningPrize = WinningPrize.valueOf(3, true);
        assertThat(winningPrize).isSameAs(WinningPrize.FIFTH_PRIZE);
    }

    @DisplayName("미당첨")
    @Test
    void getEmptyWinningPrizeWhenIsBonusFalse() {
        WinningPrize winningPrize = WinningPrize.valueOf(2, false);
        assertThat(winningPrize).isSameAs(WinningPrize.EMPTY_PRIZE);
    }

    @DisplayName("보너스 번호를 맞춰도, 미당첨")
    @Test
    void getEmptyWinningPrizeWhenIsBonusTrue() {
        WinningPrize winningPrize = WinningPrize.valueOf(2, true);
        assertThat(winningPrize).isSameAs(WinningPrize.EMPTY_PRIZE);
    }
}