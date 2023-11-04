package lotto.constant;


public enum LottoNumber {
    START_NUMBER(1),
    LOTTO_PRICE(1000),
    END_NUMBER(45),
    LOTTO_COUNT(6);
    private final int number;

    LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }


}
