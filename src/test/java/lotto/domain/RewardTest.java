package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RewardTest {

    @DisplayName("로또 번호와 보너스 번호의 맞춘 개수에 따른 결과를 확인한다.")
    @Test
    void getRewardShouldReturnCorrectEnum() {
        assertEquals(Reward.LOSE, Reward.getReward(0, false));
        assertEquals(Reward.LOSE, Reward.getReward(2, true));
        assertEquals(Reward.FIFTH, Reward.getReward(3, false));
        assertEquals(Reward.FOURTH, Reward.getReward(4, false));
        assertEquals(Reward.THIRD, Reward.getReward(5, false));
        assertEquals(Reward.SECOND, Reward.getReward(5, true));
        assertEquals(Reward.FIRST, Reward.getReward(6, false));
    }

    @DisplayName("로또 당첨 등수에 따라 지정된 상금을 얻을 수 있는지 확인한다.")
    @Test
    void getMoneyShouldReturnCorrectAmount() {
        assertEquals(0, Reward.LOSE.getMoney());
        assertEquals(5_000, Reward.FIFTH.getMoney());
        assertEquals(50_000, Reward.FOURTH.getMoney());
        assertEquals(1_500_000, Reward.THIRD.getMoney());
        assertEquals(30_000_000, Reward.SECOND.getMoney());
        assertEquals(2_000_000_000, Reward.FIRST.getMoney());
    }

    @DisplayName("로또 번호를 맞춘 개수에 따른 등수가 맞는지 확인한다.")
    @Test
    void getMatchLottoNumberShouldReturnCorrectNumber() {
        assertEquals(3, Reward.FIFTH.getMatchLottoNumber());
        assertEquals(6, Reward.FIRST.getMatchLottoNumber());
    }
}
