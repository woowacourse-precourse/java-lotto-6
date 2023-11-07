package lotto.constant;

public enum ConstantNumber {
    PROPER_LOTTO_LENGTH(6),
    THOUSAND(1000);

    private final int number;

    private ConstantNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
