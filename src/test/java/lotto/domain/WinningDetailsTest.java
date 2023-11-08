package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningDetailsTest {

    @DisplayName("5등, 4등 각각 한 번씩 당첨되면, 총 상금은 5등 상금과 4등 상금을 더한 값이다.")
    @Test
    void getTotalReward_Success_ByAdd() {
        // given
        WinningDetails winningDetails = new WinningDetails();
        winningDetails.addRank(Rank.FIFTH);
        winningDetails.addRank(Rank.FOURTH);

        // when
        long totalReward = winningDetails.getTotalReward();

        // then
        Assertions.assertThat(totalReward).isEqualTo(Rank.FIFTH.getReward() + Rank.FOURTH.getReward());
    }
}
