package lotto.constants;

import java.util.Arrays;

public enum Rank {
    THREE_MATCH(5, 3, 5_000L, "5,000원", false),
    FOUR_MATCH(4, 4, 50_000L, "50,000원", false),
    FIVE_MATCH(3, 5, 1_500_000L, "1,500,000원", false),
    FIVE_AND_BONUS_MATCH(2, 5, 30_000_000L, "30,000,000원", true),
    SIX_MATCH(1, 6, 2_000_000_000L, "2,000,000,000원", false),
    NO_RANK(0, 0, 0L, "", false);

    private final int rank;
    private final int matchCount;
    private final long amount;
    private final String amountMessage;
    private final boolean needToMatchedWithBonusNumber;

    Rank(int rank, int matchCount, long amount, String amountMessage, boolean needToMatchedWithBonusNumber) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.amount = amount;
        this.amountMessage = amountMessage;
        this.needToMatchedWithBonusNumber = needToMatchedWithBonusNumber;
    }

    public static Rank getRankByMatchCount(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchCount() == matchCount)
                .findFirst()
                .orElse(NO_RANK);
    }

    public int getRank() {
        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getAmount() {
        return amount;
    }

    public String getAmountMessage() {
        return amountMessage;
    }

    public boolean getNeedToMatchedWithBonusNumber() {
        return needToMatchedWithBonusNumber;
    }
}
