package constant;

public enum ConstantNumber {
    LOTTO_SIZE(6),
    LOTTO_PRICE(1000),
    MIN_NUMBER(1),
    MAX_NUMBER(45);


    private final int number;

    ConstantNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
