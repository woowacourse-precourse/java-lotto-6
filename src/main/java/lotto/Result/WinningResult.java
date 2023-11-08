package lotto.Result;

public enum WinningResult {
    NO_WIN(0,false,0),
    FIFTH_WIN(3,false,5000),
    FOURTH_WIN(4,false,50000),
    THIRD_WIN(5,false,1500000),
    SECOND_WIN(5,true,30000000),
    FIRST_WIN(6,false,2000000000);

    private final int numberCount;
    private final boolean bonusCheck;
    private final int winningPrice;

    WinningResult(int numberCount, boolean bonusCheck, int winningPrice){
        this.numberCount=numberCount;
        this.bonusCheck=bonusCheck;
        this.winningPrice=winningPrice;
    }

    public int getNumberCount() {
        return numberCount;
    }

    public boolean getBonusCheck() {
        return bonusCheck;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public static WinningResult calcWinningResult(int numberCount, boolean bonusCheck) {
        WinningResult result = NO_WIN;
        bonusCheck = checkFifthWin(numberCount,bonusCheck);
        for (WinningResult winningResult : WinningResult.values()) {
            if(winningResult.getNumberCount() == numberCount ){
                result = winningResult;
            }
        }
        return result;
    }

    public static boolean checkFifthWin(int numberCount, boolean bonusCheck){
        if(numberCount == 5 && bonusCheck){
            return true;
        }
        return false;
    }

}