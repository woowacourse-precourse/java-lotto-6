package lotto.winning;

public enum Prize {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000);

    private final int prize;

    Prize(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return this.prize;
    }
}
