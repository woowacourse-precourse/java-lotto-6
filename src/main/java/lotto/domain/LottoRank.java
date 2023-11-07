package lotto.domain;

public enum LottoRank {
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5),
    NONE(-1);

    private final int rank;

    LottoRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public static LottoRank valueOf(int hitCount, boolean bonusMatch) {
        if (hitCount == 6) return FIRST;
        if (hitCount == 5 && bonusMatch) return SECOND;
        if (hitCount == 5) return THIRD;
        if (hitCount == 4) return FOURTH;
        if (hitCount == 3) return FIFTH;
        return NONE;
    }
}
