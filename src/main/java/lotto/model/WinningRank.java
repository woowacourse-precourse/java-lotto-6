package lotto.model;

public enum WinningRank {
    FIRST(6, false, "1등", 2000000000),   // 1등: 6개 일치
    SECOND(5, true, "2등", 30000000),   // 2등: 5개 + 보너스 번호 일치
    THIRD(5, false, "3등", 1500000),   // 3등: 5개 일치
    FOURTH(4, false, "4등", 50000),  // 4등: 4개 일치
    FIFTH(3, false, "5등", 5000),   // 5등: 3개 일치

    NONE(0, false, "꼴등", 0);    // 꽝: 일치하는 번호 없음

    private final int matchCount;
    private final boolean hasBonus;
    private final String describe;
    private final long prize;

    WinningRank(int matchCount, boolean hasBonus, String describe, int prize) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.describe = describe;
        this.prize = prize;
    }

    public String getDescribe() {
        return describe;
    }

    public long getPrize() {
        return prize;
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
