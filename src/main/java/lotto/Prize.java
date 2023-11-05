package lotto;

public enum Prize {
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    BONUS(30000000),
    SIX(2000000000);

    private final int prize;

    Prize(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

}

