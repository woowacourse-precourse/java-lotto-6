package lotto;

import java.util.Objects;

public enum LottoRank {
    FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, false, 1500000, "5개 일치 (1,500,000원)"),
    FOURTH(4, false, 50000, "4개 일치 (50,000원)"),
    FIFTH(3, false, 5000, "3개 일치 (5,000원)"),
    NONE(0, false, 0, "");

    private final Integer matchedNumbersCount;
    private final boolean isBonusNumberMatched;
    private final Integer prizeMoney;
    private final String maseege;

    LottoRank(Integer matchedNumbersCount, boolean isBonusNumberMatched, Integer prizeMoney, String maseege) {
        this.matchedNumbersCount = matchedNumbersCount;
        this.isBonusNumberMatched = isBonusNumberMatched;
        this.prizeMoney = prizeMoney;
        this.maseege = maseege;
    }

    protected static LottoRank getRank(Integer matchedNumbersCount, boolean isBonusNumberMatched) {
        for (LottoRank rank : LottoRank.values()) {
            if (Objects.equals(rank.matchedNumbersCount, matchedNumbersCount) && (!rank.isBonusNumberMatched
                    || isBonusNumberMatched)) {
                return rank;
            }
        }
        return NONE;
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }

    public String getMaseege() {
        return maseege;
    }
}
