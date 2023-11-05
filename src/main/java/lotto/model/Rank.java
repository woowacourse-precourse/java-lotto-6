package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(0, false),
    SECOND(1, true),
    THIRD(1, false),
    FOURTH(2, false),
    FIFTH(3, false),
    NONE(4, false);

    private final int difference;
    private final boolean containsBonusNumber;

    Rank(int difference, boolean containsBonusNumber) {
        this.difference = difference;
        this.containsBonusNumber = containsBonusNumber;
    }

    public static Rank findBy(int difference, boolean containsBonusNumber) {
        return Arrays.stream(values())
                .filter(rank -> rank.difference == difference)
                .filter(rank -> rank.containsBonusNumber == containsBonusNumber)
                .findFirst()
                .orElse(Rank.NONE);
    }
}
