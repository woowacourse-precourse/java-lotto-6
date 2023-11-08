package lotto.constants;

public enum Lottoes {
    END_NUMBER(45),
    START_NUMBER(1),
    MAX_NUMBER(6);

    private final Integer value;

    Lottoes(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
