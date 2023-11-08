package lotto.domain;

public enum LottoRank {
    FIRST_PLACE("1등", 6, 0, 2000000000),
    SECOND_PLACE("2등", 5, 1, 30000000),
    THIRD_PLACE("3등", 5, 0, 1500000),
    FOURTH_PLACE("4등", 4, 0, 50000),
    FIFTH_PLACE("5등", 3, 0, 5000);

    private final String rank;
    private final int matchingCount;
    private final int bonusCount;
    private final long prize;

    LottoRank(String rank, int matchingCount, int bonusCount, long prize) {
        this.rank = rank;
        this.matchingCount = matchingCount;
        this.bonusCount = bonusCount;
        this.prize = prize;
    }

    public String getRank() {
        return rank;
    }

    public static int getMatchingCountByRank(String rank) {
        for (LottoRank lottoRank : values()) {
            if (lottoRank.getRank().equals(rank)) {
                return lottoRank.matchingCount;
            }
        }
        return 0;
    }

    public static long getPrizeByRank(String rank) {
        for (LottoRank lottoRank : values()) {
            if (lottoRank.getRank().equals(rank)) {
                return lottoRank.prize;
            }
        }
        return 0;
    }

    public static LottoRank findByMatchCount(int count, int bonusCount) {
        for (LottoRank lottoRank : values()) {
            if (lottoRank.matchingCount == count && lottoRank.bonusCount == bonusCount) {
                return lottoRank;
            }
        }
        return null;
    }
}