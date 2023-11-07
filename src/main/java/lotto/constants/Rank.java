package lotto.constants;

import java.util.Arrays;

public enum Rank {
    THREE_MATCH(5, 3, 5_000L, "5,000원"),
    FOUR_MATCH(4, 4, 50_000L, "50,000원"),
    FIVE_MATCH(3, 5, 1_500_000L, "1,500,000원"),
    FIVE_AND_BONUS_MATCH(2, 5, 30_000_000L, "30,000,000원"),
    SIX_MATCH(1, 6, 2_000_000_000L, "2,000,000,000원"),
    NO_RANK(0, 0, 0L, "");

    private final int number;
    private final int matchCount;
    private final long winnings;
    private final String amountMessage;

    Rank(int number, int matchCount, long winnings, String amountMessage) {
        this.number = number;
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

    public int getNumber() {
        return number;
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
