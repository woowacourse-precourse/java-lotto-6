package lotto.domain;

public enum LottoRank {

    /*
        3개 일치 (5,000원) - 1개
        4개 일치 (50,000원) - 0개
        5개 일치 (1,500,000원) - 0개
        5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
        6개 일치 (2,000,000,000원) - 0개
    */
    FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FOURTH(50000, 4, false),
    FIFTH(5000, 3, false),
    NONE(0, 0, false);
    private static final int FIVE = 5;
    private final long amount;
    private final int count;
    private final boolean hasBonus;

    LottoRank(final long amount, final int count, final boolean hasBonus) {
        this.amount = amount;
        this.count = count;
        this.hasBonus = hasBonus;
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

}
