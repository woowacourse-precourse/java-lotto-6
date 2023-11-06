package lotto.util;

public enum LottoConstants {
    PURCHASE_PRICE(1000),
    STARTNUMBER(1),
    ENDNUMBER(45),
    NUMBERS_COUNT(6),
    BONUS_NUMBER_COUNT(1);


    private final int value;
    LottoConstants(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

}
