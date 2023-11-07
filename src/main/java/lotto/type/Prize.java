package lotto.type;

import java.util.Arrays;

public enum Prize {
    FIFTH(3, 5000, "3개 일치 (5,000원)"),
    FIRTH(4, 50000, "4개 일치 (50,000원)"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)"),
    NONE(0, 0, " ");

    public static final int MIN_CORRECT = 3;

    Prize(int correctNum, int prize, String result) {
        this.correctNum = correctNum;
        this.prize = prize;
        this.result = result;
    }

    private final int correctNum;
    private final int prize;
    private final String result;

    public static Prize valueOf(int correctNum, boolean correctBonus) {
        if(correctNum < MIN_CORRECT) {
            return NONE;
        }
        if(correctBonus && correctNum == 5) {
            return SECOND;
        }
        for(Prize prize : values()) {
            if(prize.correctNum == correctNum) {
                return prize;
            }
        }
        throw new IllegalArgumentException();
    }
    public String getResult() {
        return result;
    }

    public int getPrize() {
        return prize;
    }
}
