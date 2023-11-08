package lotto.message;

public enum NumberUsedLotto {
    MAX_LANGE(45),
    MIN_RANGE(1),
    NUMBERS_SIZE(6);

    private final int number;

    NumberUsedLotto(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
