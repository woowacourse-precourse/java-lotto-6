package lottomachine;

public enum LottoPrize {
    FIRST(6, 2_000_000_000, false, 1),
    SECOND(5, 30_000_000, true, 2),
    THIRD(5, 1_500_000, false, 3),
    FOURTH(4, 50_000, false, 4),
    FIFTH(3, 5_000, false, 5);


    private final int matchCount;
    private final int prizeMoney;
    private final boolean bonusMatch;
    private final int rank; // 등수를 나타내는 필드 추가

    private LottoPrize(int matchCount, int prizeMoney, int rank) {
        this(matchCount, prizeMoney, false, rank);
    }

    LottoPrize(int matchCount, int prizeMoney, boolean bonusMatch, int rank) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.bonusMatch = bonusMatch;
        this.rank = rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }


    public int getRank() { // 등수를 반환하는 메소드
        return rank;
    }

    public static LottoPrize valueOf(int matchCount, boolean bonusMatch) {
        for (LottoPrize prize : LottoPrize.values()) {
            if (prize.getMatchCount() == matchCount && (!prize.isBonusMatch() || bonusMatch)) {
                return prize;
            }
        }
        return null;
    }
}
