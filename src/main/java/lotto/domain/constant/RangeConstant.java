package lotto.domain.constant;

public enum RangeConstant {
    START_NUM(1), END_NUM(45), SIZE_NUM(6),
    MAX_MONEY(Integer.MAX_VALUE), MIN_MONEY(0);


    private final int number;

    RangeConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
