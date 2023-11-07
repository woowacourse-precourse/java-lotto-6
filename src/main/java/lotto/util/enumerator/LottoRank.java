package lotto.util.enumerator;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2000000000L, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30000000L, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1500000L, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50000L, "4개 일치 (50,000원)"),
    FIFTH(3, 5000L, "3개 일치 (5,000원)"),
    NONE(0, 0L, "");

    private final int match;
    private final long amount;
    private final String content;

    LottoRank(int match, long amount, String content) {
        this.match = match;
        this.amount = amount;
        this.content = content;
    }

    public int getMatch() {
        return match;
    }

    public long getAmount() {
        return amount;
    }

    public String getContent() {
        return content;
    }

    public static LottoRank findLottoRankByMatch(int match) {
        return Arrays.stream(values())
                .filter(rank -> rank.getMatch() == match)
                .findFirst()
                .orElse(NONE);
    }
}
