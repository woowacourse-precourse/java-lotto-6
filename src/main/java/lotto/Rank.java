package lotto;

import java.util.Arrays;

public enum Rank {
    BLANK,
    FIFTH("3개 일치", 3, 5_000),
    FOURTH("4개 일치", 4, 50_000),
    THIRD("5개 일치", 5, 1_500_000),
    SECOND("5개 일치, 보너스 볼 일치", 5, 30_000_000),
    FIRST("6개 일치", 6, 2_000_000_000);

    private String description;
    private int matches;
    private int amount;

    Rank() {}
    Rank(final String description, final int matches, final int amount) {
        this.description = description;
        this.matches = matches;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public static Rank from(final int matches, final boolean bonusMatched) {
        if (matches == 5) {
            return selectBy(bonusMatched);
        }
        return findRank(matches);
    }

    private static Rank selectBy(final boolean bonusMatched) {
        if (bonusMatched) {
            return SECOND;
        }
        return THIRD;
    }

    private static Rank findRank(final int matches) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matches == matches)
                .findFirst()
                .orElse(BLANK);
    }

    public int amountOf(final int times) {
        return amount * times;
    }
}
