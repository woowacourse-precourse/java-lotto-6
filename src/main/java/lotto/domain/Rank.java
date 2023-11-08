package lotto.domain;

public enum Rank {
    First(6, false, 2_000_000_000),
    Second(5, true, 30_000_000),
    Third(5, false, 1_500_000),
    Fourth(4, false, 50_000),
    Fifth(3, false, 5_000);

    public final int matchCount;
    public final boolean isMatchBonusNumber;
    public final int reward;

    Rank(int matchCount, boolean isMatchBonusNumber, int reward) {
        this.matchCount = matchCount;
        this.isMatchBonusNumber = isMatchBonusNumber;
        this.reward = reward;
    }

}
