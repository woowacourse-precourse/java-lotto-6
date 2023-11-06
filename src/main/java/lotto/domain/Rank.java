package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    NO_RANK(0, 0, "꽝");

    private final int matchCount;
    private final int prize;
    private final String message;

    Rank(int matchCount, int prize, String message) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.message = message;
    }

    public static Rank findByMatchCountAndBonus(int matchCount, boolean matchBonus) {
        if (matchCount < 3) {
            return NO_RANK;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 5 && !matchBonus) {
            return THIRD;
        }
        if (matchCount == 5) {
            return SECOND;
        }
        return FIRST;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
