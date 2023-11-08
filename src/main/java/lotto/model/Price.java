package lotto.model;

import java.util.Arrays;

public enum Price {
    FIRST(6, "6개 일치 ", 2000000000),
    SECOND(5, "5개 일치, 보너스 볼 일치 ", 30000000),
    THIRD(5, "5개 일치 ", 1500000),
    FORTH(4, "4개 일치 ", 50000),
    FIFTH(3, "3개 일치 ", 5000);

    private final int score;
    private final String printStr;
    private final int reward;

    Price(int score, String printStr, int reward) {
        this.printStr = printStr;
        this.reward = reward;
        this.score = score;
    }

    public static Price findByScore(int score) {
        for (Price price : Price.values()) {
            if (price.getScore() == score) {
                return price;
            }
        }
        return null;
    }

    public int getScore() {
        return score;
    }

    public String printStr() {
        return this.printStr;
    }

    public int getReward() {
        return reward;
    }
}