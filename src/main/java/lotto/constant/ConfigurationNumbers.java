package lotto.constant;

public enum ConfigurationNumbers {
    PRICE(1000),
    NEGATIVE(-1);

    private int number;

    private ConfigurationNumbers(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
