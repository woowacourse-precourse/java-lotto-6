package lotto.model;

import java.util.Arrays;


public enum Ranking {
    FIRST(new int[] {6, 0}, 2_000_000_000),
    SECOND(new int[] {5, 1}, 30_000_000),
    THIRD(new int[] {5, 0}, 1_5000_000),
    FORTH(new int[] {4, 0}, 50_000),
    FIFTH(new int[] {3, 0}, 5_000),
    EMPTY(null, 0);

    private int[] score;
    private int reward;

    Ranking(int[] score, int point) {
        this.score = score;
        this.reward = point;
    }

    public static Ranking getRank(int[] score) {
        return Arrays.stream(Ranking.values())
                .filter(rank -> rank.equals(score))
                .findFirst()
                .orElse(EMPTY);
    }
    public int getReward() {
        return reward;
    }
}

