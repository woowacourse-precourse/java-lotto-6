package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000_000_000, false),
    SECOND(5, 30_000_000, false),
    THIRD(5, 1_500_000, true),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int count;
    private final int prize;

    private final boolean includeBonusNumber;


    Rank(int count, int prize, boolean includeBonusNumber) {
        this.count = count;
        this.prize = prize;
        this.includeBonusNumber = includeBonusNumber;
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }

    public boolean getIncludeBonusNumber() {
        return includeBonusNumber;
    }

    public static Rank checkRank(int count, boolean includeBonusNumber) {
        Rank result = NONE;
        for(var rank : Rank.values()) {
            if(checkResultAndBonusNumber(rank, count, includeBonusNumber))
                result = rank;
        }
        return result;
    }

    private static boolean checkResultAndBonusNumber(Rank rank, int count, boolean includeBonusNumber) {
        if (count == SECOND.count) {
            return rank.includeBonusNumber == includeBonusNumber;
        }
        return rank.count == count;
    }
}
