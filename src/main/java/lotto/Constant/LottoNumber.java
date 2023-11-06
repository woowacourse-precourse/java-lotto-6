package lotto.Constant;

public enum LottoNumber {

    FIRST_NUMBER(1),
    LAST_NUMBER(45),
    NUMBER_COUNT(6),
    PURCHASE_LOTTO_PRICE(1000);

    private final int number;

    LottoNumber(int number){
        this.number = number;
    }

    public int getLottoNumber(){
        return number;
    }
}
