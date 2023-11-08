package lotto;

public enum LottoRank {
    RANK_1(6, false, 2_000_000_000L),
    RANK_2(5, true, 30_000_000L),
    RANK_3(5, false, 1_500_000L),
    RANK_4(4, false, 50_000L),
    RANK_5(3, false, 5_000L),
    UNRANKED(0, false, 0L);

    private final int matchCount;
    private final boolean needBonusNumber;
    private final long prize;

    LottoRank(int matchCount, boolean needBonusNumber, long prize) {
        this.matchCount = matchCount;
        this.needBonusNumber = needBonusNumber;
        this.prize = prize;
    }

    public static LottoRank belongedToRank(int matchCount, boolean needBonusNumber) {
        for (LottoRank lottoRank : values()) {
            if (lottoRank.isMatchRank(matchCount, needBonusNumber)) {
                return lottoRank;
            }
        }
        return UNRANKED;
    }

    private boolean isMatchRank(int matchCount, boolean needBonusNumber) {
        return this.matchCount == matchCount && this.needBonusNumber == needBonusNumber;
    }
}
