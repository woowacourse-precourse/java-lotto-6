package lotto.constants;

public enum WinningPrize {
    THREEMATCH(5000),
    FOURMATCH(50000),
    FIVEMATCH(1500000),
    FIVEMATCHBONUS(30000000),
    SIXMATCH(2000000000);

    private int prize;

    WinningPrize(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}
