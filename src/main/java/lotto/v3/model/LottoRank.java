package lotto.v3.model;

public enum LottoRank {
    FIRST(6, 2_000_000_000L, false),
    SECOND(5, 30_000_000L, true), // 보너스 번호 일치 가정
    THIRD(5, 1_500_000L, false),
    FOURTH(4, 50_000L, false),
    FIFTH(3, 5_000L, false);;

    private final int matchCount;
    private final long prizeMoney;
    private final boolean bonusMatch;

    LottoRank(int matchCount, long prizeMoney, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public static LottoRank valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount < FIFTH.matchCount) {
            throw new IllegalArgumentException("[ERROR] 일치하는 로또 순위가 없습니다.");
        }

        if (matchCount == SECOND.matchCount && bonusMatch) {
            return SECOND;
        }

        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && !rank.bonusMatch) {
                return rank;
            }
        }

        throw new IllegalArgumentException("[ERROR] 일치하는 로또 순위가 없습니다.");
    }
}

