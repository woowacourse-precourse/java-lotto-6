package lotto;

public enum WinningCondition {
    NO_RANK(0, false, 0),
    RANK_5(3, false, 5000),
    RANK_4(4, false, 50000),
    RANK_3(5, false, 1500000),
    RANK_2(5, true, 30000000),
    RANK_1(6, false, 2000000000);
    private final int matchCount;
    private final boolean containBonusNumber;
    private final int winningAmount;

    WinningCondition(int matchCount, boolean containBonusNumber, int winningAmount) {
        this.matchCount = matchCount;
        this.containBonusNumber = containBonusNumber;
        this.winningAmount = winningAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isContainBonusNumber() {
        return containBonusNumber;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

//    public static WinningCondition compareCount(int matchCount, int bonusNumberCount){
//        if (matchCount == RANK_1.matchCount){
//            return WinningCondition.RANK_1;
//        } else if (matchCount == RANK_2.matchCount && bonusNumberCount == 1){
//            return WinningCondition.RANK_2;
//        } else if (matchCount == RANK_3.matchCount){
//            return WinningCondition.RANK_3;
//        } else if (matchCount == RANK_4.matchCount){
//            return WinningCondition.RANK_4;
//        }
//        return WinningCondition.RANK_5;
//    }

    public static WinningCondition valueOfLottoNumbers(int matchCount, int bonusNumberCount){
        WinningCondition result = NO_RANK;
        for (WinningCondition winningCondition : WinningCondition.values()){
            if (meetCondition(winningCondition, matchCount, bonusNumberCount)){
                result = winningCondition;
            }
        }
        return result;
    }

    public static boolean meetCondition(WinningCondition winningCondition, int matchCount, int bonusNumberCount){
        if (winningCondition.isContainBonusNumber() && bonusNumberCount != 1){
            return false;
        }
        return (matchCount >= winningCondition.getMatchCount());
    }




}
