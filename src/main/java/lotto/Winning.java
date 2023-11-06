package lotto;

public enum Winning {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    FAIL( 0);

    private final int amount;

    Winning(int amount ) {
        this.amount = amount;
    }
}
