package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(6, "(2,000,000,000원)"),
    SECOND(5, "(30,0000,0000원)"),
    THIRD(5, "(1,500,000원)"),
    FOURTH(4, "(50,000원)"),
    FIFTH(3, "(5,000원)"),
    NOTHING(0, null);

    private final int collectCount;
    private final String prize;
    Rank(int collectCount, String prize) {
        this.collectCount = collectCount;
        this.prize = prize;
    }


    public String getPrize() {
        return prize;
    }

}
