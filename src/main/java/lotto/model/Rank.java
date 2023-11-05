package lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

    public static List<Rank> getReverseOrderValues() {
        return Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    public static Rank findBy(int difference, boolean containsBonusNumber) {
        return Arrays.stream(values())
                .filter(rank -> filter(rank, difference, containsBonusNumber))
                .findFirst()
                .orElse(Rank.NONE);
    }

    private static boolean filter(Rank rank, int difference, boolean containsBonusNumber) {
        return isDifferenceSame(rank, difference)
                && isContainsBonusNumberSame(rank, containsBonusNumber);
    }

    private static boolean isDifferenceSame(Rank rank, int difference) {
        return rank.difference == difference;
    }

    private static boolean isContainsBonusNumberSame(Rank rank, boolean containsBonusNumber) {
        return rank.containsBonusNumber == containsBonusNumber;
    }
}
