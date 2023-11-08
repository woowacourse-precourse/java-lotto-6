package lotto.Enum;

public enum Winning {
    FIFTH("3개 일치 ", 5000),
    FOURTH("4개 일치 ", 50000),
    THIRD("5개 일치 ", 1500000),
    SECOND("5개 일치, 보너스 볼 일치 ", 30000000),
    FIRST("6개 일치 ", 2000000000)
    ;
    private final String message;
    private final Integer amount;

    Winning(String message, Integer amount) {
        this.message = message;
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public Integer getAmount() {
        return amount;
    }
}
