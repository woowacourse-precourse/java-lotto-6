package lotto.controller;

import java.util.Arrays;

public enum Rank {
    FIFTH(5, 3, 5000),
    FOURTH(4, 4, 50000),
    THIRD(3, 5, 1500000),
    SECOND(2, 5, 3000000),
    First(1, 6, 2000000000);

    private final int correctNum;
    private final int prize;
    private final int ranking;
    Rank(int ranking, int correctNum, int prize) {
        this.ranking = ranking;
        this.correctNum = correctNum;
        this.prize = prize;
    }

    public int getRanking() {
        return ranking;
    }

    public int getCorrectNum() {
        return correctNum;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank getRank(int num) {
        for (Rank value : values()) {
            if (value.correctNum == num) {
                return value;
            }
        }
        return null;
    }


}
