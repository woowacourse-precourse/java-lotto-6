package lotto.common;

import java.util.Arrays;

public enum LottoRank {
    FIRST_RANK(6, false, 200000000, "6개 일치 (2,000,000,000원)"),

    SECOND_RANK(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),

    THIRD_RANK(5, false, 1500000, "5개 일치 (1,500,000원)"),

    FOURTH_RANK(4, false, 50000, "4개 일치 (50,000원)"),

    FIFTH_RANK(3, false, 5000, "3개 일치 (5,000원)"),

    NO_RANK(0, false, 0, "0개 일치 (0원)");

    private final int matchedNumber;
    private final boolean bonus;
    private final int prize;
    private final String description;

    LottoRank(int matchedNumber, boolean bonus, int prize, String description) {
        this.matchedNumber = matchedNumber;
        this.bonus = bonus;
        this.prize = prize;
        this.description = description;
    }

    public static LottoRank getRankByMatchedNumbers(int matchedNumber, boolean hasBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matchedNumber == matchedNumber && rank.bonus == hasBonus)
                .findFirst()
                .orElse(NO_RANK);
    }

    public static LottoRank[] getSortedValues() {
        LottoRank[] ranks = values();
        Arrays.sort(ranks);
        return ranks;
    }

    public String getDescription() {
        return description;
    }
}
