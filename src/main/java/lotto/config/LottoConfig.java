package lotto.config;

public enum LottoConfig {

    LOTTO_LEAST_AMOUNT(1000),
    LOTTO_START_NUMBER(1),
    LOTTO_LAST_NUMBER(45),
    LOTTO_LENGTH(6);

    private final int value;

    LottoConfig(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

}
