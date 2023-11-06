package lotto.util.constants;

public enum DomainConstants {
    LOTTO_PRICE(1000),
    RANDOM_START_NUMBER(1),
    RANDOM_END_NUMBER(45),
    RANDOM_COUNT_NUMBER(6);

    private final int number;

    DomainConstants(int number) {
        this.number = number;
    }

    public int getConstants() {
        return number;
    }
}
