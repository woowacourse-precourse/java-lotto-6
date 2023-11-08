package lotto.domain;

public enum PrizeMoney {

    THREE(5000, "3개 일치 (5,000원)"),
    FOUR(50000, "4개 일치 (50,000원)"),
    FIVE(1500000, "5개 일치 (1,500,000원)"),
    FIVE_WITH_BONUS(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX(2000000000, "6개 일치 (2,000,000,000원)"),;

    private int prizeValue;
    private String message;

    PrizeMoney(int prizeValue, String message) {
        this.prizeValue = prizeValue;
        this.message = message;
    }

    public int getPrizeValue() {
        return prizeValue;
    }

    public String getMessage() {
        return message;
    }
}