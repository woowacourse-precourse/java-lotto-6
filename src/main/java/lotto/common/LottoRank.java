package lotto.common;

import java.util.Arrays;

public enum LottoRank {
    FIRST_RANK(6, false),

    SECOND_RANK(5, true),

    THIRD_RANK(5, false),

    FOURTH_RANK(4, false),

    FIFTH_RANK(3, false),

    NO_RANK(0, false);

    private final int matchedNumber;
    private final boolean bonus;

    LottoRank(int matchedNumber, boolean bonus) {
        this.matchedNumber = matchedNumber;
        this.bonus = bonus;
    }

    public static LottoRank getRankByMatchedNumbers(int matchedNumber, boolean hasBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matchedNumber == matchedNumber && rank.bonus == hasBonus)
                .findFirst()
                .orElse(NO_RANK);
    }
}
