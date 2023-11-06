package lotto.model;

public enum LottoResult {
    UNDER_THREE(0, "2개 이하 일치"),
    THREE_MATCHES(5000, "3개 일치 (5,000원)"),
    FOUR_MATCHES(50000, "4개 일치 (50,000원)"),
    FIVE_MATCHES(1500000, "5개 일치 (1,500,000원)"),
    FIVE_PLUS_BONUS(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCHES(2000000000, "6개 일치 (2,000,000,000원)");
    private final int prizeAmount;
    private final String message;

    LottoResult(int prizeAmount, String message) {
        this.prizeAmount = prizeAmount;
        this.message = message;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public String getMessage() {
        return message;
    }

    public static LottoResult getResultByNumberOfBall(int countBall) {
        if (countBall == 3) {
            return THREE_MATCHES;
        }
        if (countBall == 4) {
            return FOUR_MATCHES;
        }
        if (countBall == 5) {
            return FIVE_MATCHES;
        }
        if (countBall == 6) {
            return SIX_MATCHES;
        }
        if (countBall == 7) {
            return FIVE_PLUS_BONUS;
        }
        return UNDER_THREE;
    }
}
