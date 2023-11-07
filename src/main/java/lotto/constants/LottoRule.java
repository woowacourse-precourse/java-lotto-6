package lotto.constants;

public enum LottoRule {
    LOTTO_PRICE(1000),
    LOTTO_MAX_NUMBER(45),
    LOTTO_MIN_NUMBER(1),
    LOTTO_NUMBER_COUNT(6);

    private final int number;

    LottoRule(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
