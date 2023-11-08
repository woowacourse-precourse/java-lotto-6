package lotto.common.enums;

public enum LottoRank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int matchCount;
    private final int prize;
    private final boolean isBonusNumber;

    LottoRank(int matchCount, int prize, boolean isBonusNumber) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.isBonusNumber = isBonusNumber;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getIsBonusNumber() {
        return isBonusNumber;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 5 && matchBonus) {
            return SECOND;
        }
        for (LottoRank rank : values()) {
            if (rank.getMatchCount() == matchCount && !rank.getIsBonusNumber()) {
                return rank;
            }
        }
        return NONE;
    }
}