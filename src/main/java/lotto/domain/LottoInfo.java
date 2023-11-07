package lotto.domain;

public enum LottoInfo {
    NUMBER_COUNT(6),
    PRICE_UNIT(1000),
    MIN_NUMBER(1),
    MAX_NUMBER(45)
    ;

    private final Integer number;

    LottoInfo(Integer number) {
        this.number = number;
    }

    public Integer number() {
        return number;
    }
}
