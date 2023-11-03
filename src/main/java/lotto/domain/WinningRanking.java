package lotto.domain;

public enum WinningRanking {

    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    NOTHING(0, 0);

    private final long price;
    private final int countOfMatch;
    private final boolean isBonusMatched;

    WinningRanking(long price, int countOfMatch, boolean isBonusMatched) {
        this.price = price;
        this.countOfMatch = countOfMatch;
        this.isBonusMatched = isBonusMatched;
    }

    WinningRanking(long price, int countOfMatch) {
        this(price, countOfMatch, false);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public boolean isBonusMatched() {
        return isBonusMatched;
    }

    public long getPrice() {
        return price;
    }
}
