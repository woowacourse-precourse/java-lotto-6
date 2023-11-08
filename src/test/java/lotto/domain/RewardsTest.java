package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static lotto.domain.Reward.SECOND_PLACE;
import static lotto.domain.Reward.THIRD_PLACE;
import static org.assertj.core.api.Assertions.assertThat;

class RewardsTest {
    @DisplayName("총 당첨금을 반환한다.")
    @Test
    public void getTotalAmount() throws Exception {
        final Rewards rewards = new Rewards(List.of(SECOND_PLACE, THIRD_PLACE));
        final long actual = rewards.getTotalAmount();
        final long expect = SECOND_PLACE.getAmount() + THIRD_PLACE.getAmount();

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("특정 등수 당첨 개수를 반환한다")
    @Test
    public void getCountFromRank() throws Exception {
        final Rewards rewards = new Rewards(List.of(SECOND_PLACE, SECOND_PLACE));
        final int actual = rewards.getCountFromRank(SECOND_PLACE.getRank());
        final int expect = 2;

        assertThat(actual).isEqualTo(expect);
    }
}