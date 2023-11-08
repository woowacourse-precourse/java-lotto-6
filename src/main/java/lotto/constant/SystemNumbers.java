package lotto.constant;

public enum SystemNumbers {
    NUMBER_OF_WINNING_NUMBERS(6),
    MINIMUM_OF_NUMBER_RANGE(1),
    MAXIMUM_OF_NUMBER_RANGE(45),
    TICKET_PRICE(1000),
    PERCENTAGE(100);

    private final int number;

    SystemNumbers(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
