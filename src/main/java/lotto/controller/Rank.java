package lotto.controller;

import java.util.Arrays;

public enum Rank {
    FIFTH(5, 3, "5,000"),
    FOURTH(4, 4, "50,000"),
    THIRD(3, 5, "1,500,000"),
    SECOND(2, 5, "30,000,000"),
    First(1, 6, "2,000,000,000");

    private final int correctNum;
    private final String prize;
    private final int ranking;
    Rank(int ranking, int correctNum, String prize) {
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

    public String getPrize() {
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
