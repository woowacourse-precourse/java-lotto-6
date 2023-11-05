package lotto.lottocompany;

import java.util.List;

public class RewardHistory {

    private final List<Reward> history;

    private RewardHistory(List<Reward> history) {
        this.history = history;
    }

    public List<Reward> getHistory() {
        return List.copyOf(history);
    }

    public static RewardHistory create(List<Reward> rewards) {
        return new RewardHistory(rewards);
    }

    public void addReward(List<Reward> rewards) {
        history.addAll(rewards);
    }
}
