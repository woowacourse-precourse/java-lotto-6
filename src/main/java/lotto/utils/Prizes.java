package lotto.utils;

import java.util.HashMap;
import java.util.Map;

public enum Prizes {

    First(6), Second(777), Third(5), Fourth(4), Fifth(3);

    private final int matchCount;

    Prizes(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getmatchCount() {
        return matchCount;
    }

    public static Prizes findByMatchCount(int matchCount) {
        for (Prizes prize : values()) {
            if (matchCount == prize.getmatchCount()) {
                return prize;
            }
        }
        return null;
    }
}

