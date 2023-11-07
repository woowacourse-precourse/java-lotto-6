package lotto;

public enum Rank {
    FIRST(6,2_000_000_000),
    SECOND(5,30_000_000),
    THIRD(5,1_500_000),
    FOURTH(4,50_000),
    FIFTH(3,5_000),
    MISS(0,0);

    private final int numberOfMatch;
    private final int winningMoney;

    Rank(int numberOfMatch,int winningMoney){
        this.numberOfMatch = numberOfMatch;
        this.winningMoney = winningMoney;
    }
}
