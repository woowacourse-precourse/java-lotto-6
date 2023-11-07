package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(1, 6,  "(2,000,000,000원)"),
    SECOND(2, 5,  "(30,0000,0000원)"),
    THIRD(3, 5, "(1,500,000원)"),
    FOURTH(4, 4,"(50,000원)"),
    FIFTH(5, 3, "(5,000원)"),
    NOTHING(6, 0,   null);

    private final int rank;
    private final int collectCount;
    private final String prize;
    Rank(int rank, int collectCount, String prize) {
        this.rank = rank;
        this.collectCount = collectCount;
        this.prize = prize;
    }

    public static Rank decideRank(int count, boolean isBonus) {
        if (isBonus && count == 5) {
            return Rank.SECOND;
        }

        return Arrays.stream(values())
                .filter(value -> value != Rank.SECOND)
                .filter(value -> value.collectCount == count)
                .findFirst()
                .orElse(NOTHING);
    }

    public String getPrize() {
        return prize;
    }

}
