package lotto.model;

public enum WinningRank {
    FIRST(6, false),   // 1등: 6개 일치
    SECOND(5, true),   // 2등: 5개 + 보너스 번호 일치
    THIRD(5, false),   // 3등: 5개 일치
    FOURTH(4, false),  // 4등: 4개 일치
    FIFTH(3, false),   // 5등: 3개 일치

    NONE(0, false);    // 꽝: 일치하는 번호 없음

    private final int matchCount;
    private final boolean hasBonus;

    WinningRank(int matchCount, boolean hasBonus) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean hasBonus() {
        return hasBonus;
    }

    public static WinningRank valueOf(int matchCount, boolean hasBonus) {
        for (WinningRank rank : WinningRank.values()) {
            if (rank.matchCount == matchCount && rank.hasBonus == hasBonus) {
                return rank;
            }
        }
        return NONE;
    }
}
