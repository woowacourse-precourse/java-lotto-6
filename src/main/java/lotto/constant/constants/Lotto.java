package lotto.constant.constants;

public enum Lotto {
    PRICE(1000),
    MIN_NUMBER(1),
    MAX_NUMBER(45);

    private final Integer lotto;

    Lotto(Integer lotto) {
        this.lotto = lotto;
    }

    public Integer getLotto() {
        return this.lotto;
    }
}
