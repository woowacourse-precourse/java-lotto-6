package lotto.system;

public enum Constants {
    LOTTO_SIZE(6),
    MONEY_UNIT(1000),
    START_NUMBER(1),
    END_NUMBER(45),
    YIELD_PRECISION(1);

    public int constants;

    Constants(int constants) {
        this.constants = constants;
    }

    public int getConstants() {
        return constants;
    }
}
