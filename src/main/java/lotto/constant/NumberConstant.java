package lotto.constant;

public enum NumberConstant {
    DEFAULT_VALUE(0),
    LOTTO_RANGE(6),
    DOUBLE_LOTTO_RANGE(12),
    MAX_NUMBER(45),
    MIN_NUMBER(1),
    LOTTO_PRICE(1000),
    RANK_RANGE(5),
    RATE_FORMAT_NUMBER(10),
    DASH_COUNT(3);

    private final int value;

    NumberConstant(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
