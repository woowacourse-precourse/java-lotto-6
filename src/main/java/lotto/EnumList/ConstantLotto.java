package lotto.EnumList;

public enum ConstantLotto {
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    LOTTO_SIZE(6);

    private final int value;

    ConstantLotto(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
