package lotto.func;

public enum WinningRank {
    FIFTH(3, false, "3개 일치"),
    FOURTH(4, false, "4개 일치"),
    THIRD(5, false, "5개 일치"),
    SECOND(5, true, "5개 일치, 보너스 볼 일치"),
    FIRST(6, false, "6개 일치");

    private final int matchCount;
    private final boolean hasBonus;
    private final String description;

    WinningRank(int matchCount, boolean hasBonus, String description) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.description = description;
    }
    public static WinningRank calculateRank(int matchingNumbers, boolean hasBonus) {
        for (WinningRank rank : values()) {
            if (matchingNumbers == rank.matchCount && hasBonus == rank.hasBonus) {
                return rank;
            }
        }
        return null;
    }
    public String getDescription() {
        return description;
    }
}
