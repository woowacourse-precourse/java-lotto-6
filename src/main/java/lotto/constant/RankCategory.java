package lotto.constant;

public enum RankCategory {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int matchingNumbers;
    private final int prize;
    private final boolean bonusStatus;

    RankCategory(int matchingNumbers, int prize, boolean bonusStatus) {
        this.matchingNumbers = matchingNumbers;
        this.prize = prize;
        this.bonusStatus = bonusStatus;
    }

    public static RankCategory of(int matchingNumbers, boolean bonusStatus) {
        if (matchingNumbers == RankCategory.SECOND.matchingNumbers) {
            return checkBonusStatus(bonusStatus);
        }
        for (RankCategory rankCategory : RankCategory.values()) {
            if (rankCategory.matchingNumbers == matchingNumbers) {
                return rankCategory;
            }
        }
        return NONE;
    }

    private static RankCategory checkBonusStatus(boolean bonusStatus) {
        if (bonusStatus) {
            return SECOND;
        }
        return THIRD;
    }
}
