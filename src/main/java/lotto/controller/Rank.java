package lotto.controller;

import java.util.Arrays;

public enum Rank {
    FIFTH(5, 3, 5000, "5,000"),
    FOURTH(4, 4, 50000, "50,000"),
    THIRD(3, 5, 1500000, "1,500,000"),
    SECOND(2, 5, 30000000, "30,000,000"),
    First(1, 6, 2000000000, "2,000,000,000");

    private final int ranking;
    private final int correctNum;
    private final int prize;
    private final String prizePrint;
    Rank(int ranking, int correctNum, int prize, String prizePrint) {
        this.ranking = ranking;
        this.correctNum = correctNum;
        this.prize = prize;
        this.prizePrint = prizePrint;
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

    public String getPrizePrint() {
        return prizePrint;
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
