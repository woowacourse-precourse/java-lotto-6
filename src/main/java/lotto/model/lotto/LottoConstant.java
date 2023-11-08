package lotto.model.lotto;


public enum LottoConstant {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    LOTTO_SIZE(6),
    LOTTO_PRICE(1000);

    private int value;

    LottoConstant(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
