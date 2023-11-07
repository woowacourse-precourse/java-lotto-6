package lotto.domain;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원) - "),
    OTHER(0, false, 0, "꽝");

    private final int matchCount;
    private final boolean isBonus;
    private final int prize;
    private final String message;

    LottoRank(int matchCount, boolean isBonus, int prize, String message) {
        this.matchCount = matchCount;
        this.isBonus = isBonus;
        this.prize = prize;
        this.message = message;
    }

    public static LottoRank value(int matchCount, boolean isBonus) {
        for (LottoRank value : LottoRank.values()) {
            if (value.matchCount == matchCount && value.isBonus == isBonus) {
                return value;
            }
        }
        return OTHER;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
