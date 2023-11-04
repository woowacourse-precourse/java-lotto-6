package lotto.constant;

public enum LottoNumber {
    FIRST_NUMBER(1),
    LAST_NUMBER(45),
    MAX_COUNT(6),
    PURCHASE_AMOUNT_COND(1000);

    private final int number;

    LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
