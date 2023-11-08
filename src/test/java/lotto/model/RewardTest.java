package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class RewardTest {

    @DisplayName("5등 1개 2등 1개 당첨된 경우 당첨금 계산")
    @Test
    void calculateReward() {
        Map<String, Long> winningResult = new HashMap<>();
        winningResult.put("5th", Long.valueOf(1));
        winningResult.put("2nd", Long.valueOf(1));

        Reward reward = new Reward();
        reward.calculate(winningResult);
        int totalReward = 5000 + 30000000;

        Assertions.assertThat(reward.getReward()).isEqualTo(totalReward);
    }

    @DisplayName("하나도 당첨 안된 경우 당첨금 계산")
    @Test
    void calculateNone() {
        Map<String, Long> winningResult = new HashMap<>();

        Reward reward = new Reward();
        reward.calculate(winningResult);
        int totalReward = 0;

        Assertions.assertThat(reward.getReward()).isEqualTo(totalReward);
    }
}
