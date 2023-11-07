package lotto.model;

public enum LottoMetaData {
    PRICE(1000),
    LOWER(1),
    UPPER(45),
    SIZE(6),
    MINIMAL_NEED_CORRECT_NUMBER(3),
    ;

    private final int value;

    LottoMetaData(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
