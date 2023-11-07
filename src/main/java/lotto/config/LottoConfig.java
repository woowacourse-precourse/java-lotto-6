package lotto.config;

public enum LottoConfig {
    PRICE(1000),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    NUMBER_OF_NUMBERS(6);

    private final int number;

    LottoConfig(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
