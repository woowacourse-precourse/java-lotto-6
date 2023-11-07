package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    LOSING_TICKET(0, 0, " 0"),
    FIFTH(3, 5000, " (5,000원)"),
    FOURTH(4, 50000, " (50,000원)"),
    THIRD(5, 1500000, " (1,500,000원)"),
    SECOND(5, 30000000, ", 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, 2000000000, " (2,000,000,000원)");

    private final int matchCount;
    private final int amount;
    private final String stringAmount;

    Rank(int place, int amount, String stringAmount) {
        this.matchCount = place;
        this.amount = amount;
        this.stringAmount = stringAmount;
    }

    public static Rank find(int matchCount, boolean isBonus) {
        if (matchCount == 5 && isBonus) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(LOSING_TICKET);
    }

    public static List<Rank> getWithoutLosingTicket() {
        return Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(LOSING_TICKET))
                .toList();
    }

    public long calculatePrize(int count) {
        return (long) amount * count;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getAmount() {
        return amount;
    }

    public String getStringAmount() {
        return stringAmount;
    }
}
