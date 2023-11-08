package lotto.domain;

public enum LottoRank {
    FIRST(2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(50_000, "4개 일치 (50,000원) - "),
    FIFTH(5_000, "3개 일치 (5,000원) - "),
    NONE(0, "");

    private final int prizeAmount;
    private final String message;

    LottoRank(int prizeAmount, String message) {
        this.prizeAmount = prizeAmount;
        this.message = message;
    }

    public static LottoRank valueOf(int hitCount, boolean bonusMatch) {
        if (hitCount == 6) return FIRST;
        if (hitCount == 5 && bonusMatch) return SECOND;
        if (hitCount == 5) return THIRD;
        if (hitCount == 4) return FOURTH;
        if (hitCount == 3) return FIFTH;
        return NONE;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public String getMessage() {
        return message;
    }
}
