package lotto.constant;

public enum LottoFigure {
    START_NUMBER(1),
    END_NUMBER(45),
    LOTTO_NUMBER_COUNT(6);

    private final int number;

    LottoFigure(int number) {
        this.number = number;
    }

    public int get() {
        return number;
    }
}