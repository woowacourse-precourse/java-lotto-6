package lotto.constants;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, 5_000L, "5,000원"),
    FOURTH(4, 50_000L, "50,000원"),
    THIRD(5, 1_500_000L, "1,500,000원"),
    SECOND(5, 30_000_000L, "30,000,000원"),
    FIRST(6, 2_000_000_000L, "2,000,000,000원"),
    NO_RANK(0, 0L, "");

    private final int matchCount;
    private final long winnings;
    private final String amountMessage;

    Rank(int matchCount, long winnings, String amountMessage) {
        this.matchCount = matchCount;
        this.winnings = winnings;
        this.amountMessage = amountMessage;
    }

    public static Rank getRankBy(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchCount() == matchCount)
                .findFirst()
                .orElse(NO_RANK);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getWinnings() {
        return winnings;
    }

    public String getAmountMessage() {
        return amountMessage;
    }
}
