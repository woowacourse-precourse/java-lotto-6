package lotto.winning;

public enum PrizeIndex {
    COUNT(0),
    PRIZE(1);

    private final int number;

    PrizeIndex(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
