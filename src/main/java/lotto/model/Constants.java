package lotto.model;

public enum Constants {
    LOTTO_LENGTH(6),
    LOTTO_UNIT(1000),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45);

    public int constants;

    Constants(int constants) {
        this.constants = constants;
    }

    public int getConstants() {
        return constants;
    }
}
