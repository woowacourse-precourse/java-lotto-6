package lotto.model;

import java.util.Arrays;

public enum RankReward {
    FIRST_REWARD(Rank.FIRST, 2_000_000_000),
    SECOND_REWARD(Rank.SECOND, 30_000_000),
    THIRD_REWARD(Rank.THIRD, 1_500_000),
    FOURTH_REWARD(Rank.FOURTH, 50_000),
    FIFTH_REWARD(Rank.FIFTH, 5000),
    NONE_REWARD(Rank.NONE, 0);

    private final Rank rank;
    private final int reward;

    RankReward(Rank rank, int reward) {
        this.rank = rank;
        this.reward = reward;
    }

    public static int getRewardOf(Rank rank) {
        RankReward rankReward = findBy(rank);
        return rankReward.reward;
    }

    private static RankReward findBy(Rank rank) {
        return Arrays.stream(values())
                .filter(rankReward -> rankReward.rank == rank)
                .findFirst()
                .orElse(NONE_REWARD);
    }
}
