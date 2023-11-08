package lotto;

public enum Prize {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(7, 30000000),    // todo
    SIX(6, 2000000000);

    private int numMatch, prize;

    Prize(int numMatch, int prize) {
        this.numMatch = numMatch;
        this.prize = prize;
    }

    public int numMatch() {
        return numMatch;
    }

    public int getPrize() {
        return prize;
    }
}
