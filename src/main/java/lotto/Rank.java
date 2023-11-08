package lotto;

public enum Rank {

    FIRST(6, false,  2_000_000_000),
    SECOND(5, true,30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    OTHER(0, false, 0);

    Rank(int matchedCnt, boolean hasBonusNumber, int prize){
        this.matchedCnt = matchedCnt;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public int matchedCnt;
    public boolean hasBonusNumber;
    public int prize;

}


