package lotto.enums;

public enum LottoPrize {
    FIRST(6, "1등", 2000000000, false),
    SECOND(5, "2등", 30000000, true), // 보너스 볼 필요 여부 추가
    THIRD(5, "3등", 1500000, false),
    FOURTH(4, "4등", 50000, false),
    FIFTH(3, "5등", 5000, false);

    private final int matchingNumberCount;
    private final String prizeRank;
    private final int prizeAmount;
    private final boolean bonusBallRequired;

    LottoPrize(int matchingNumberCount, String prizeRank, int prizeAmount, boolean bonusBallRequired) {
        this.matchingNumberCount = matchingNumberCount;
        this.prizeRank = prizeRank;
        this.prizeAmount = prizeAmount;
        this.bonusBallRequired = bonusBallRequired;
    }

    public int getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public String getPrizeRank() {
        return prizeRank;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public boolean isBonusBallRequired() {
        return bonusBallRequired;
    }
}
