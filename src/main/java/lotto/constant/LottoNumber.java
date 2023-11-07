package lotto.constant;

public enum LottoNumber {

    FIRST_RANGE(1)
    , LAST_RANGE(45)
    , LENGTH_CONDITION(6)
    , PURCHASE_CONDITION(1000)
    ;

    private final int number;

    LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
