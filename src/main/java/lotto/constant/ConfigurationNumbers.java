package lotto.constant;

public enum ConfigurationNumbers {
    PRICE(1000),
    MIN_NUMBER(1),
    MAX_NUMBER(45),
    LOTTO_LENGTH(6),
    NEGATIVE(-1);

    private int number;

    private ConfigurationNumbers(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
