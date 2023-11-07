package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class RewardTest {

    @Test
    void calculate_5등_1개_2등_1개_당첨된_경우() {
        Map<String, Long> winningResult = new HashMap<>();
        winningResult.put("5th", Long.valueOf(1));
        winningResult.put("2nd", Long.valueOf(1));

        Reward reward = new Reward();
        reward.calculate(winningResult);
        int totalReward = 5000 + 30000000;

        Assertions.assertThat(reward.getReward()).isEqualTo(totalReward);
    }

    @Test
    void calculate_하나도_당첨_안된_경우() {
        Map<String, Long> winningResult = new HashMap<>();

        Reward reward = new Reward();
        reward.calculate(winningResult);
        int totalReward = 0;

        Assertions.assertThat(reward.getReward()).isEqualTo(totalReward);
    }
}
