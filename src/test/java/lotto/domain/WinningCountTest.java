package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningCountTest {
    @DisplayName("로또 번호가 일치하는 개수에 따라 당첨 횟수를 저장할 수 있다.")
    @Test
    void addWinningCount() {
        // given
        WinningCount winningCount = new WinningCount();

        // when
        addWinningsToWinningCount(winningCount);

        // then
        assertThat(winningCount.getCount(3)).isEqualTo(3);
        assertThat(winningCount.getCount(4)).isEqualTo(1);
        assertThat(winningCount.getCount(5)).isEqualTo(1);
        assertThat(winningCount.getCount(6)).isEqualTo(2);
        assertThat(winningCount.getCount(7)).isEqualTo(2);
    }

    private void addWinningsToWinningCount(WinningCount winningCount) {
        winningCount.addWinningCount(Winning.FIVE);
        winningCount.addWinningCount(Winning.THREE);
        winningCount.addWinningCount(Winning.SIX);
        winningCount.addWinningCount(Winning.FOUR);
        winningCount.addWinningCount(Winning.FIVE_BONUS);
        winningCount.addWinningCount(Winning.THREE);
        winningCount.addWinningCount(Winning.SIX);
        winningCount.addWinningCount(Winning.THREE);
        winningCount.addWinningCount(Winning.FIVE_BONUS);
    }
}