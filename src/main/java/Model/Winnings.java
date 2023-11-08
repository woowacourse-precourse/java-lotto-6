package Model;

public enum Winnings {
    FIRST_PRIZE_MONEY(2000000000),
    SECOND_PRIZE_MONEY(30000000),
    THIRD_PRIZE_MONEY(1500000),
    FOURTH_PRIZE_MONEY(50000),
    FIFTH_PRIZE_MONEY(5000);

    private final int value;

    Winnings(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
