package lotto.model;

public enum LottoRank {

    NONE(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean needBonus;
    private final int winningAmount;

    private String displayFormat;

    LottoRank(int matchCount, boolean needBonus, int winningAmount) {
        this.matchCount = matchCount;
        this.needBonus = needBonus;
        this.winningAmount = winningAmount;

        this.displayFormat = "%d개 일치 (%,d원) - %d개";
        if (matchCount == 5 && needBonus) {
            this.displayFormat = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
        }
    }

    public static LottoRank valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            return SECOND;
        }
        for (LottoRank rank : LottoRank.values()) {
            if (rank.matchCount == matchCount && (!rank.needBonus)) {
                return rank;
            }
        }
        return NONE;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getDisplayFormat() {
        return displayFormat;
    }
}


