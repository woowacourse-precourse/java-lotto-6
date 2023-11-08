package lotto.domain;

public enum LottoRank {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    public int matchCount;
    public boolean isMatchBonus;
    public int prize;

    LottoRank(int matchCount, boolean isMatchBonus, int prize){
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonus;
        this.prize = prize;
    }
}
