package lotto.constant;

public enum WinningRanking {

    RANK1(1,6, 2_000_000_000),
    RANK2(2,5, 3_000_000_0),
    RANK3(3,5, 1_500_000),
    RANK4(4, 4, 50000),
    RANK5(5, 3, 5000);

    private final int ranking;
    private final int matchNumCnt;
    private final int winnings;

    WinningRanking(int ranking, int matchNumCnt, int winnings){
        this.ranking = ranking;
        this.matchNumCnt = matchNumCnt;
        this.winnings = winnings;
    }

    public int getMatchNumCnt(){
        return matchNumCnt;
    }

    public int getRanking() {
        return ranking;
    }

    public int getWinnings() {
        return winnings;
    }
}
