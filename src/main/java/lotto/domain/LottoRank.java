package lotto.domain;

public enum LottoRank {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    NONE(0);

    private final int prizeAmount;

    LottoRank(int prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public static LottoRank valueOf(int hitCount, boolean bonusMatch) {
        if (hitCount == 6) return FIRST;
        if (hitCount == 5 && bonusMatch) return SECOND;
        if (hitCount == 5) return THIRD;
        if (hitCount == 4) return FOURTH;
        if (hitCount == 3) return FIFTH;
        return NONE;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
