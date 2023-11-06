package lotto.model;

public enum Price {
    LOTTO(1000, "[ERROR] 구입 금액은 1,000원 단위로 이루어 져야 합니다.");

    private final int amount;
    private final String exceptionMessage;

    Price(int amount, String exceptionMessage) {
        this.amount = amount;
        this.exceptionMessage = exceptionMessage;
    }

    public int calculate(int money){
        if(money % amount != 0){
            throw new IllegalArgumentException(exceptionMessage);
        }
        return money / amount;
    }
}
