package lotto.winning;

public enum PrizeIndex {
    COUNT(0),
    PRIZE(1),
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private final int number;

    PrizeIndex(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
