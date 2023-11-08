package lotto.global;

public enum Constant {
    LOTTO_PRICE(1000),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    LOTTO_NUMBERS_COUNT(6),
    LOTTO_WORST_RANK(5),
    LOTTO_BEST_RANK(1),
    LOTTO_NO_WIN_RANK(0);

    private final Integer number;

    Constant(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
