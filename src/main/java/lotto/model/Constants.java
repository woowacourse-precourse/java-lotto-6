package lotto.model;

public enum Constants {
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    PURCHASE_UNIT(1000);

    private int value;

    Constants(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
