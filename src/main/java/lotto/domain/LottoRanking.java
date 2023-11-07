package lotto.domain;

import java.util.Arrays;

public enum LottoRanking {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NO_MATCH(0, 0);

    LottoRanking(int matchingNumbers, int prizeAmount) {
        this.matchingNumber = matchingNumbers;
        this.prizeAmount = prizeAmount;
    }

    private int matchingNumber;
    private int prizeAmount;

    public static LottoRanking valueOf(int matchingNumber, boolean isBonusInclude) {
        if (SECOND.matchNumber(matchingNumber) && isBonusInclude) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(LottoRanking -> LottoRanking.matchNumber(matchingNumber)
                        && LottoRanking != SECOND)
                .findFirst()
                .orElse(NO_MATCH);
    }

    private boolean matchNumber(int matchingNumber) {
        return this.matchingNumber == matchingNumber;
    }
}
