package lotto;

public enum WinningRank {
    NON(0, 0, ""),
    FIFTH(3, 5000, "3개 일치 (5,000원)"),
    FOURTH(4, 50000, "4개 일치 (50,000원)"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)");


    private int matchCount;
    private int prize;
    private String description;
    private int bonusPrize;

    WinningRank(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
        this.bonusPrize = prize;
    }

    public int calculatePrize(int count, boolean isBonusNumberMatch) {
        if (matchCount == 5 && count == 5) {
            if (isBonusNumberMatch) {
                return bonusPrize;
            }
        }
        return prize * count;
    }

    public String getDescription() {
        return description;
    }

    public static WinningRank getWinningRank(int commonNumbersCount, boolean isBonusNumberMatch) {
        for (WinningRank rank : values()) {
            if (rank.matchCount == commonNumbersCount) {
                if (rank.matchCount == 5) {
                    if (isBonusNumberMatch && rank == SECOND) {
                        return rank;
                    }
                } else {
                    return rank;
                }
            }
        }
        return NON;
    }
}