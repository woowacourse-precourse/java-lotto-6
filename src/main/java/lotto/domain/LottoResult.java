package lotto.domain;

public enum LottoResult {
    FIRST(2000000000, "6개 일치"),
    SECOND(30000000, "5개 일치, 보너스 볼 일치"),
    THIRD(1500000, "5개 일치"),
    FOURTH(50000, "4개 일치"),
    FIFTH(5000, "3개 일치"),
    NONE(0, "0개 일치");

    private final long moneyAmount;
    private final String description;

    LottoResult(long moneyAmount, String description) {
        this.moneyAmount = moneyAmount;
        this.description = description;
    }

    public long getMoneyAmount() {
        return this.moneyAmount;
    }

    public String getDescription() {
        return this.description;
    }
}
