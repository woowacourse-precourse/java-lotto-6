package lotto.message;

public enum LottoResult {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    NONE(0);
    private final int prize;

    LottoResult(int prize) {
        this.prize = prize;
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
}
