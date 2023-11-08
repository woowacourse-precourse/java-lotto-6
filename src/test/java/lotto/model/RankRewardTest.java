package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankRewardTest {

    @Test
    @DisplayName("등수별 금액 테스트")
    void rankRewardTest() {
        Rank[] ranks = Rank.values();
        int[] rewards = {2_000_000_000, 30_000_000, 1_500_000, 50_000, 5000, 0};
        for (int i = 0; i < ranks.length; i++) {
            //given
            Rank rank = ranks[i];

            // when
            int reward = RankReward.getRewardOf(rank);

            // then
            assertThat(reward).isEqualTo(rewards[i]);
        }
    }
}