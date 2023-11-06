package lotto.model;

import java.util.Arrays;

public enum LottoRank {
    NONE(0, false, 0, "0개 일치 (0원)"),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원)"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원)");

    private static final String DASH_SYMBOL = " - ";
    private static final String COUNT_EXPRESSION = "%d개";
    private final int matchCount;
    private final boolean bonusNumberExists;
    private final int prize;
    private final String message;

    LottoRank(int matchCount, boolean bonusNumberExists, int prize, String message) {
        this.matchCount = matchCount;
        this.bonusNumberExists = bonusNumberExists;
        this.prize = prize;
        this.message = message + DASH_SYMBOL + COUNT_EXPRESSION;
    }

    public static LottoRank findRankByMatchCount(int matchCount, boolean bonusNumberExists) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchCount == matchCount)
                .filter(lottoRank -> lottoRank.bonusNumberExists == bonusNumberExists)
                .findAny()
                .orElse(NONE);
    }

    public static int calculatePrizeByCount(LottoRank rank, int count) {
        return rank.prize * count;
    }

    public String getMessage() {
        return message;
    }
}
