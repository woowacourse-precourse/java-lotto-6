package lotto.model;

import java.util.Arrays;
import java.util.List;


public enum Ranking {
    FIRST(new int[]{6, 0}, 2_000_000_000),
    SECOND(new int[]{5, 1}, 30_000_000),
    THIRD(new int[]{5, 0}, 15_000_000),
    FORTH(new int[]{4, 0}, 50_000),
    FIFTH(new int[]{3, 0}, 5_000),
    EMPTY(null, 0);

    private int[] score;
    private int reward;

    Ranking(int[] score, int reward) {
        this.score = score;
        this.reward = reward;
    }

    public static Ranking getRank(int[] score) {
        return Arrays.stream(Ranking.values())
                .filter(rank -> Arrays.equals(rank.getScore(), score))
                .findFirst()
                .orElse(EMPTY);
    }

    public static long getCount(List<Ranking> rankings, Ranking rank) {
        return rankings.stream()
                .filter(ranking -> ranking.equals(rank))
                .count();
    }

    private int[] getScore() {
        return score;
    }

    public int getReward() {
        return reward;
    }
}

