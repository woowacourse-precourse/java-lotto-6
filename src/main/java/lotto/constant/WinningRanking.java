package lotto.constant;

public enum WinningRanking {

    ONE(6, 2_000_000_000),
    TWO(5, 3_000_000_0),
    THREE(5, 1_500_000),
    FOUR(4, 50000),
    FIVE(3, 5000);

    private final int matchNumCnt;
    private final int winnings;

    WinningRanking(int matchNumCnt, int winnings){
        this.matchNumCnt = matchNumCnt;
        this.winnings = winnings;
    }

}
