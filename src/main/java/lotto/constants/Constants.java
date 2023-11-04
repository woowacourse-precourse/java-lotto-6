package lotto.constants;

public enum Constants {
    SAME_3(5000),
    SAME_4(50000),
    SAME_5(1500000),
    SAME_5_BONUS(30000000),
    SAME_6(2000000000),
    LOTTO_PRICE(1000),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    NUMBER_COUNT(6),
    PERCENTAGE(100);

    private final int constants;

    Constants(int constants) {
        this.constants = constants;
    }

    public int getConstants() {
        return constants;
    }
}
