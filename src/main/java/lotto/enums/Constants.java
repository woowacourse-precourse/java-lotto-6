package lotto.enums;

public enum Constants {
    LOTTO_PRICE(1000),
    BOUNDARY("---"),
    ;

    private int number;
    private String string;

    Constants(int number) {
        this.number = number;
    }

    Constants(String string) {
        this.string = string;
    }

    public int getNumber() {
        return number;
    }

    public String getString() {
        return string;
    }
}
