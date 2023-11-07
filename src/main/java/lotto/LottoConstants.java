package lotto;

public enum LottoConstants {

    NUMBER_MIN(1),
    NUMBER_MAX(45),
    PRICE(1000),
    SIZE(6);


    private final int value;

    LottoConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}