package lotto.domain.constant;

public enum NumberConstant {
    ZERO(0),
    ONE(1),
    TEN(10),
    HUNDRED(100);

    private final int number;

    NumberConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}