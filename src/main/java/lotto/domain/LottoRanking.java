package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoRanking {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NOTHING(0, false, 0);

    private static final int VALUE_TO_DETERMINE_SECOND_OR_THIRD = 5;

    private final int numberOfMatches;
    private final boolean hasBonusNumber;
    private final int prizeMoney;

    LottoRanking(int numberOfMatches, boolean hasBonusNumber, int prizeMoney) {
        this.numberOfMatches = numberOfMatches;
        this.hasBonusNumber = hasBonusNumber;
        this.prizeMoney = prizeMoney;
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

    public static List<LottoRanking> findOrder() {
        return List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
