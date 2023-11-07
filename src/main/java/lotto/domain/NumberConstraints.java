package lotto.domain;

enum NumberConstraints {
    LOTTO_PER_PRICE(1000),
    LOTTO_PER_NUMBER(6),
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45);

    final private int value;

    public int value() {
        return value;
    }

    NumberConstraints(int value) {
        this.value = value;
    }
}
