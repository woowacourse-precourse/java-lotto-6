package lotto.enums;

public enum LottoNumber {
    FIRST(1)
    , LAST(45)
    , LENGTH(6)
    , LEAST_PURCHASE_AMOUNT(1000);

    private final int number;
    LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber(){
        return number;
    }
}
