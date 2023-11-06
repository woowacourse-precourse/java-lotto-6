package lotto.constant;

public enum LottoNumber {
    FIRST__RANGE(1)
    , LAST__RANGE(45)
    , LOTTO__SIZE(6)
    , PURCHASE__PRICE(1000)
    ;
    
    private final int number;
    
    LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
