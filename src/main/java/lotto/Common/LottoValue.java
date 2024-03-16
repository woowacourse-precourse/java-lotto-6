package lotto.Common;

public enum LottoValue {
    LOTTO_COUNT_NUMBER(6),
    LOTTO_ONE_TICKET_PRICE(1000),
    LOTTO_FIRST_NUMBER(1),
    LOTTO_FINAL_NUMBER(45);

    private final Integer value;
    LottoValue(Integer value) {
        this.value = value;

    }

    public static int getMultiplier(int matchingNumber){
        if( matchingNumber == 3) {
            return 5000;
        }
        if( matchingNumber == 4) {
            return 50000;
        }
        if( matchingNumber == 5) {
            return 1500000;
        }
        if( matchingNumber == 6) {
            return 2000000000;
        }
        if( matchingNumber == 7) {
            return 30000000;
        }
        return 0;
    }

    public Integer getValue() {
        return value;
    }
}
