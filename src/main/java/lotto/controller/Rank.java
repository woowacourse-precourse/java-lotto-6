package lotto.controller;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 3000000),
    First(6, 2000000000);

    private final int correctNum;
    private final int prize;
    Rank(int correctNum, int prize) {
        this.correctNum = correctNum;
        this.prize = prize;
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
