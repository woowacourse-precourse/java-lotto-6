package lotto.domain;


public enum Ranking {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchNumber;
    private final boolean isBonusMatched;
    private final int prize;

    Ranking(int matchNumber, boolean isBonusMatched, int prize) {
        this.matchNumber = matchNumber;
        this.isBonusMatched = isBonusMatched;
        this.prize = prize;
    }


    public int getMatchNumber() {
        return matchNumber;
    }


    public int getPrize() {
        return prize;
    }
}
