package lotto.model;

import java.util.Arrays;

public enum Price {
    FIRST(6, "6개 일치 ", 2000000000),
    SECOND(5, "5개 일치, 보너스 볼 일치 ", 30000000),
    THIRD(5, "5개 일치 ", 1500000),
    FORTH(4, "4개 일치 ", 50000),
    FIFTH(3, "3개 일치 ", 5000);

    private final int score;
    private final String guideline;
    private final int reward;

    Price(int score, String guideline, int reward) {
        this.guideline = guideline;
        this.reward = reward;
        this.score = score;
    }

    public static Price findByScore(int score) {
        return Arrays.stream(Price.values())
            .filter(type -> type.getScore() == score)
            .findFirst()
            .orElse(null);
    }

    public int getScore() {
        return score;
    }

    public String getGuideline() {
        return this.guideline;
    }

    public int getReward() {
        return reward;
    }
}
