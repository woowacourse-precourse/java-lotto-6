package lotto.domain;

import java.util.List;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(final List<Reward> rewards) {
        this.rewards = rewards;
    }

    public long getTotalAmount() {
        return rewards.stream()
                .map(Reward::getAmount)
                .mapToLong(l -> l)
                .sum();
    }

    public int getCountFromRank(final int rank) {
        return (int) rewards.stream()
                .filter(r -> r.getRank() == rank)
                .count();
    }
}
