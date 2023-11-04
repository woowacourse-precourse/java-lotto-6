package lotto.domain;

enum NumberConstraints {
    LOTTO_PER_PRICE(1000);

    final private int value;

    public int value() {
        return value;
    }

    NumberConstraints(int value) {
        this.value = value;
    }
}
