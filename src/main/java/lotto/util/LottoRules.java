package lotto.util;

public enum LottoRules {
    PRICE_PER_LOTTO(1000),
    START_NUMBER(1),
    END_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    BONUS_NUMBER_COUNT(1);


    private final int value;
    LottoRules(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

}
