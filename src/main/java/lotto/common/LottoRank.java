package lotto.common;

import java.util.Arrays;

public enum LottoRank {
    FIRST_RANK(6, false, 200000000),

    SECOND_RANK(5, true, 30000000),

    THIRD_RANK(5, false, 1500000),

    FOURTH_RANK(4, false, 50000),

    FIFTH_RANK(3, false, 5000),

    NO_RANK(0, false, 0);

    private final int matchedNumber;
    private final boolean bonus;
    private final int prize;

    LottoRank(int matchedNumber, boolean bonus, int prize) {
        this.matchedNumber = matchedNumber;
        this.bonus = bonus;
        this.prize = prize;
    }

    public static LottoRank getRankByMatchedNumbers(int matchedNumber, boolean hasBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matchedNumber == matchedNumber && rank.bonus == hasBonus)
                .findFirst()
                .orElse(NO_RANK);
    }

    public int getPrize() {
        return prize;
    }
}
