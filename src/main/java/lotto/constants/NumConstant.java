package lotto.constants;

public enum NumConstant {
    MIN_VALUE(1),MAX_VALUE(45),PRICE(1000),DIGIT(6);
    private int value;

    NumConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
