package lotto.constant;

public enum LottoConstant {
    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45),
    LOTTO_SIZE(6),
    LOTTO_PRICE(1000);

    private final int value;

    LottoConstant(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
