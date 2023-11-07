package lotto.domain.constant;

public enum LottoNumberConstant {
    LOTTO_SIZE(6),
    LOTTO_NUMBER_MIN_SIZE(1),
    LOTTO_NUMBER_MAX_SIZE(45),
    LOTTO_PRICE(1000),
    ;
    private final int number;

    LottoNumberConstant(int number) {
        this.number = number;
    }


    public int getNumber() {
        return number;
    }

    public boolean isEqualTo(int input) {
        return this.number == input;
    }

    public boolean isNotEqualTo(int input) {
        return !isEqualTo(input);
    }

    public boolean isLessThan(int input) {
        return this.number < input;
    }

    public boolean isGreaterThan(long input) {
        return this.number > input;
    }

    public long divide(long input) {
        return input / number;
    }

}
