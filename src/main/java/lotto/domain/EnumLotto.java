package lotto.domain;

public enum EnumLotto {
    LOTTO_PRICE(1000),
    LOTTO_LENGTH(6),
    START_NUMBER(1),
    END_NUMBER(45);

    private final int NUMBER;

    EnumLotto(int number) {
        this.NUMBER = number;
    }

    public int getNumber() {
        return NUMBER;
    }
}
