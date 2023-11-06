package lotto.domain.constant;

public enum LottoConstant {

    MIN_NUMBER(1),
    MAX_NUMBER(45),
    NUMBER_COUNT(6);

    private final int number;

    LottoConstant(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
