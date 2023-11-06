package lotto.message;

public enum LottoResult {
    FIRST(2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(50_000, "4개 일치 (50,000원)"),
    FIFTH(5_000, "3개 일치 (5,000원)"),
    NONE(0, "꽝");
    private final int prize;
    private final String message;

    LottoResult(int prize, String message) {
        this.prize = prize;
        this.message = message;
    }

    public static LottoResult of(int matchCount, boolean isBonusNumberMatched) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && isBonusNumberMatched) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
