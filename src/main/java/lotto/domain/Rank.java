package lotto.domain;

import java.lang.reflect.Array;
import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NO_MATCH(0, 0);

    private int correctCount;
    private int money;

    Rank(final int correctCount, final int money) {
        this.correctCount = correctCount;
        this.money = money;
    }

    public static Rank determineRank(final int correctCount, final boolean hasBonumNumber) {
        if (correctCount == 5 && hasBonumNumber) {
            return Rank.SECOND;
        }
        if (correctCount == 5 && !hasBonumNumber) {
            return Rank.THIRD;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.checkCorrectCountEquality(correctCount))
                .findFirst()
                .orElse(NO_MATCH);
    }

    private boolean checkCorrectCountEquality(final int correctCount) {
        return this.correctCount == correctCount;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getMoney() {
        return money;
    }
}
