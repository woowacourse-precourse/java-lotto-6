package lotto.model.domain.exception;

public enum LottoGameConstants {

    MIN_NUMBER(1),
    MAX_NUMBER(45),
    NUMBERS_PER_LOTTO(6),
    PRICE_PER_LOTTO(1000)
    ;

    private final int value;

    LottoGameConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
