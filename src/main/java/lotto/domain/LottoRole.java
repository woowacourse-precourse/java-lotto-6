package lotto.domain;

public enum LottoRole {
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    LOTTO_SIZE(6),
    LOTTO_PRICE(1000);

    private final int number;

    LottoRole(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
