package lotto.domain;

import java.util.Arrays;

public enum LottoRanking {
    FIRST(6, false),
    SECOND(5, true),
    THIRD(5, false),
    FOURTH(4, false),
    FIFTH(3, false),
    NOTHING(0, false);

    private static final int VALUE_TO_DETERMINE_SECOND_OR_THIRD = 5;

    private final int numberOfMatches;
    private final boolean hasBonusNumber;

    LottoRanking(int numberOfMatches, boolean hasBonusNumber) {
        this.numberOfMatches = numberOfMatches;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static LottoRanking of(int numberOfMatches, boolean hasBonusNumber) {
        if (numberOfMatches != VALUE_TO_DETERMINE_SECOND_OR_THIRD) {
            return findRanking(numberOfMatches, false);
        }
        return findRanking(numberOfMatches, hasBonusNumber);
    }

    private static LottoRanking findRanking(int numberOfMatches, boolean hasBonusNumber) {
        return Arrays.stream(values())
                .filter(lottoRanking -> lottoRanking.isMatch(numberOfMatches, hasBonusNumber))
                .findFirst()
                .orElse(NOTHING);
    }

    private boolean isMatch(int numberOfMatches, boolean hasBonusNumber) {
        return this.numberOfMatches == numberOfMatches && this.hasBonusNumber == hasBonusNumber;
    }
}
