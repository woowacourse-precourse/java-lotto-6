package lotto.domain;

public enum LottoRank {

    /*
        3개 일치 (5,000원) - 1개
        4개 일치 (50,000원) - 0개
        5개 일치 (1,500,000원) - 0개
        5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
        6개 일치 (2,000,000,000원) - 0개
    */
    NONE(0, 0, false, null),
    FIFTH(5000, 3, false, "3개 일치 (5,000원) - "),
    FOURTH(50000, 4, false, "4개 일치 (50,000원) - "),
    THIRD(1500000, 5, false, "5개 일치 (1,500,000원) - "),
    SECOND(30000000, 5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(2000000000, 6, false, "6개 일치 (2,000,000,000원) - ");
    private static final int FIVE = 5;
    private final long amount;
    private final int count;
    private final boolean hasBonus;
    private final String description;

    LottoRank(final long amount, final int count, final boolean hasBonus, final String description) {
        this.amount = amount;
        this.count = count;
        this.hasBonus = hasBonus;
        this.description = description;
    }

    public static LottoRank of(final int count, final boolean hasBonus) {
        if (count == FIVE) {
            return whenCountFive(hasBonus);
        }
        return determineRank(count);
    }

    private static LottoRank determineRank(final int count) {
        // count 값에 따라 LottoRank의 Count가 같은 등수를 return
        for (LottoRank rank : values()) {
            if (rank.getCount() == count && !rank.hasBonus) {
                return rank;
            }
        }
        return NONE;
    }

    private static LottoRank whenCountFive(final boolean hasBonus) {
        if (hasBonus) {
            return SECOND;
        }
        return THIRD;
    }

    public int getCount() {
        return count;
    }

    public long getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
