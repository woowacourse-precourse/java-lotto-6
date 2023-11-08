package lotto.constant;

public enum LottoConstant {
    LOTTO_PRICE(1000),
    START_NUMBER(1),
    END_NUMBER(45),
    DIGITS(6);

    private int value;

    LottoConstant(int money) {
        this.value = money;
    }

    public int getValue() {
        return value;
    }
}
