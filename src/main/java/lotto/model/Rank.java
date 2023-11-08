package lotto.model;

public enum Rank {
    FIRST(2000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    NONE(0, 0);

    private final int prize;
    private final int amount;

    Rank(int prize, int amount) {
        this.prize = prize;
        this.amount = amount;
    }

    public int getPrize() {
        return prize;
    }

    public int getAmount() {
        return amount;
    }

}
