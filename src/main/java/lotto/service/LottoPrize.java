package lotto.service;

import java.text.DecimalFormat;

public enum LottoPrize {
    NOTHING_MATCH(0,0L,"일치하는게 없음"),
    FIFTH_PRIZE(3, 5_000L, "3개 일치 (5,000원)"),
    FOURTH_PRIZE(4, 50_000L, "4개 일치 (50,000원)"),
    THIRD_PRIZE(5, 1_500_000L, "5개 일치 (1,500,000원)"),
    SECOND_PRIZE(5, 30_000_000L, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST_PRIZE(6, 2_000_000_000L, "6개 일치 (2,000,000,000원)");

    private final int matchCount;
    private final long prizeAmount;
    private final String format;

    LottoPrize(int matchCount, long prizeAmount, String format) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.format = format;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

    public String getFormattedPrizeAmount() {
        DecimalFormat df = new DecimalFormat("#,###,###");
        return df.format(prizeAmount);
    }

    public String getFormat() {
        return format;
    }
}
