package lotto;

import lotto.constant.GameConstant;
import lotto.domain.Reward;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RewardTest {

    @DisplayName("6개를 맞췄을 경우, 1등이 출력된다.")
    @Test
    void computeFirstReward(){
        Reward reward = Reward.computer(6, 0);
        Assertions.assertThat(reward.getMoney()).isEqualTo(GameConstant.FIRST_REWARD);
        Assertions.assertThat(reward.getRank()).isEqualTo(1);
    }

    @DisplayName("5개를 맞추고 보너스 숫자도 맞춘 경우, 2등이 출력된다.")
    @Test
    void computeSecondReward(){
        Reward reward = Reward.computer(5, 1);
        Assertions.assertThat(reward.getMoney()).isEqualTo(GameConstant.SECOND_REWARD);
        Assertions.assertThat(reward.getRank()).isEqualTo(2);
    }
    @DisplayName("5개를 맞췄을 경우, 3등이 출력된다.")
    @Test
    void computeThirdReward(){
        Reward reward = Reward.computer(5, 0);
        Assertions.assertThat(reward.getMoney()).isEqualTo(GameConstant.THIRD_REWARD);
        Assertions.assertThat(reward.getRank()).isEqualTo(3);
    }
    @DisplayName("4개를 맞췄을 경우, 4등이 출력된다.")
    @Test
    void computeFourthReward(){
        Reward reward = Reward.computer(4, 0);
        Assertions.assertThat(reward.getMoney()).isEqualTo(GameConstant.FOURTH_REWARD);
        Assertions.assertThat(reward.getRank()).isEqualTo(4);
    }
    @DisplayName("3개를 맞췄을 경우, 5등이 출력된다.")
    @Test
    void computeFifthReward(){
        Reward reward = Reward.computer(3, 0);
        Assertions.assertThat(reward.getMoney()).isEqualTo(GameConstant.FIFTH_REWARD);
        Assertions.assertThat(reward.getRank()).isEqualTo(5);
    }
}
