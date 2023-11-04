package lotto.domain.validation;

public enum Number {
    ZERO(0);

    private final int numberToInteger;

    Number(int numberToInteger) {
        this.numberToInteger = numberToInteger;
    }

    public int getNumberToInteger() {
        return numberToInteger;
    }
}
