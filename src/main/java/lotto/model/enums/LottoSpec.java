package lotto.model.enums;

public enum LottoSpec {
    NUMBER_SIZE(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    PRICE(1000);

    private final int value;

    LottoSpec(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}