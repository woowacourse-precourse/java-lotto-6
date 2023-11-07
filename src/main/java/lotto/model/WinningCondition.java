package lotto.model;

public enum WinningCondition {
    NO_RANK(0, false, 0),
    RANK_5(3, false, 5000),
    RANK_4(4, false, 50000),
    RANK_3(5, false, 1500000),
    RANK_2(5, true, 30000000),
    RANK_1(6, false, 2000000000);

    private final int winningNumberCount;
    private final boolean containBonusNumber;
    private final int winningAmount;

    WinningCondition(int winningNumberCount, boolean containBonusNumber, int winningAmount) {
        this.winningNumberCount = winningNumberCount;
        this.containBonusNumber = containBonusNumber;
        this.winningAmount = winningAmount;
    }

    public int winningNumberCount() {
        return winningNumberCount;
    }

    public boolean containBonusNumber() {
        return containBonusNumber;
    }

    public int winningAmount() {
        return winningAmount;
    }

    public static WinningCondition valueOfLottoNumbers(int winningNumberCount, int bonusNumberCount) {
        WinningCondition result = NO_RANK;
        for (WinningCondition winningCondition : WinningCondition.values()) {
            if (meetCondition(winningCondition, winningNumberCount, bonusNumberCount)) {
                result = winningCondition;
            }
        }
        return result;
    }

    public static boolean meetCondition(WinningCondition winningCondition, int winningNumberCount, int bonusNumberCount) {
        if(winningCondition.containBonusNumber && bonusNumberCount != 1){
            return false;
        }
        return (winningNumberCount >= winningCondition.winningNumberCount);
    }
}
