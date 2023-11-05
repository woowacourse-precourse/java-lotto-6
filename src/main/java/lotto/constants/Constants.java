package lotto.constants;

public enum Constants {
    LOTTO_PRICE(1000),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    Lotto_Size(6),
    PERCENTAGE(100);

    private final int constants;

    Constants(int constants) {
        this.constants = constants;
    }

    public int getConstants() {
        return constants;
    }
}
