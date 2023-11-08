package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static lotto.domain.Reward.FIRST_PLACE;
import static lotto.domain.Reward.FOURTH_PLACE;
import static lotto.domain.Reward.LAST_PLACE;
import static lotto.domain.Reward.NONE;
import static lotto.domain.Reward.SECOND_PLACE;
import static lotto.domain.Reward.THIRD_PLACE;
import static lotto.domain.Reward.getFromMatchingResult;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RewardTest {
    @DisplayName("보너스 번호 일치 여부와 당첨 개수과 일치하는 보상을 가져온다.")
    @Test
    public void getRewardFromBonusNumberMatchedAndMatchingCount() throws Exception {
        final Reward first = getFromMatchingResult(false, 6);
        final Reward second = getFromMatchingResult(true, 5);
        final Reward third = getFromMatchingResult(false, 5);
        final Reward fourth = getFromMatchingResult(true, 4);
        final Reward last = getFromMatchingResult(true, 3);
        final Reward none = getFromMatchingResult(false, 2);

        assertAll(
                () -> assertThat(first).isEqualTo(FIRST_PLACE),
                () -> assertThat(second).isEqualTo(SECOND_PLACE),
                () -> assertThat(third).isEqualTo(THIRD_PLACE),
                () -> assertThat(fourth).isEqualTo(FOURTH_PLACE),
                () -> assertThat(last).isEqualTo(LAST_PLACE),
                () -> assertThat(none).isEqualTo(NONE)
        );
    }

    @DisplayName("당첨금이 있는 보상 값들을 반환한다.")
    @Test
    public void getRewardsWhereExistAmount() throws Exception {
        final List<Reward> winningRewards = Reward.getWinningRewards();
        assertAll(
                () -> assertThat(winningRewards).contains(FIRST_PLACE),
                () -> assertThat(winningRewards).contains(SECOND_PLACE),
                () -> assertThat(winningRewards).contains(THIRD_PLACE),
                () -> assertThat(winningRewards).contains(FOURTH_PLACE),
                () -> assertThat(winningRewards).contains(LAST_PLACE),
                () -> assertThat(winningRewards).doesNotContain(NONE)
        );
    }
}