package lotto.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class RewardResult {
    private static final String REWARD_COUNT_RESULT_MESSAGE_FORMAT = "%s - %d개";
    private final EnumMap<Reward, Integer> rewardMap = new EnumMap<>(Reward.class);

    public RewardResult() {
        Arrays.stream(Reward.values()).forEach(reward -> rewardMap.put(reward, 0));
    }

    public void addReward(Reward reward) {
        if (reward != null) {
            rewardMap.put(reward, rewardMap.get(reward) + 1);
        }
    }

    public List<String> getRewardResultMessage() {
        return rewardMap.entrySet().stream()
                .map(entry ->
                        String.format(REWARD_COUNT_RESULT_MESSAGE_FORMAT,
                                entry.getKey().getDescription(),
                                entry.getValue())).toList();
    }

    public long getTotalRewardMoney() {
        return rewardMap.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getRewardMoney() * entry.getValue()).sum();
    }
}
