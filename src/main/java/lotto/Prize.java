package lotto;

import java.util.Arrays;

public enum Prize {
    NONE(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);




    private final int matchCount;
    private final int prizeMoney;


    Prize(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Prize valueOf(int matchCount) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
    public int getMatchCount(){
        return matchCount;
    }
}

