package lotto.dto;

public class WinningCountDto {
    private int matchThreeWinningCount;
    private int matchFourWinningCount;
    private int matchFiveWinningCount;
    private int matchFiveWinningAndBonusCount;
    private int matchSixWinningCount;

    public WinningCountDto(int matchThreeWinningCount, int matchFourWinningCount,int matchFiveWinningCount,int matchFiveWinningAndBonusCount,int matchSixWinningCount){
        this.matchThreeWinningCount = matchThreeWinningCount;
        this.matchFourWinningCount = matchFourWinningCount;
        this.matchFiveWinningCount = matchFiveWinningCount;
        this.matchFiveWinningAndBonusCount = matchFiveWinningAndBonusCount;
        this.matchSixWinningCount = matchSixWinningCount;
    }

    public int getMatchThreeWinningCount(){
        return matchThreeWinningCount;
    }

    public int getMatchFourWinningCount(){
        return matchFourWinningCount;
    }

    public int getMatchFiveWinningCount(){
        return matchFiveWinningCount;
    }

    public int getMatchFiveWinningAndBonusCount(){
        return matchFiveWinningAndBonusCount;
    }

    public int getMatchSixWinningCount(){
        return matchSixWinningCount;
    }
}
