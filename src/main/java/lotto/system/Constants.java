package lotto.system;

public enum Constants {
    MONEY_UNIT(1000),
    START_NUMBER(1),
    END_NUMBER(45),
    LOTTO_SIZE(6);

    private final int constants;
    Constants(int constants) {
        this.constants = constants;
    }

    public int getConstants() {
        return this.constants;
    }

}
