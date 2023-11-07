package lotto.model;

public enum WinningCondition {
    NO_RANK(0, 0, 0),
    RANK_5(3, 0, 5000),
    RANK_4(4, 0, 50000),
    RANK_3(5, 0, 1500000),
    RANK_2(5, 1, 30000000),
    RANK_1(6, 0, 2000000000);

    private final int winningNumberCount;
    private final int bonusNumberCount;
    private final int winningAmount;

    WinningCondition(int winningNumberCount, int bonusNumberCount, int winningAmount) {
        this.winningNumberCount = winningNumberCount;
        this.bonusNumberCount = bonusNumberCount;
        this.winningAmount = winningAmount;
    }

    public int winningNumberCount() {
        return winningNumberCount;
    }

    public int bonusNumberCount() {
        return bonusNumberCount;
    }

    public int winningAmount() {
        return winningAmount;
    }

    public static WinningCondition valueOfLottoNumbers(int winningNumberCount, int bonusNumberCount) {
        WinningCondition result = NO_RANK;
        for (WinningCondition winningCondition : WinningCondition.values()) {
            if (meetCondition(winningCondition, winningNumberCount, bonusNumberCount)) {
                result = winningCondition;
                continue;
            }
            break;
        }
        return result;
    }

    public static boolean meetCondition(WinningCondition winningCondition, int winningNumberCount, int bonusNumberCount) {
        return (winningNumberCount >= winningCondition.winningNumberCount &&
                bonusNumberCount >= winningCondition.bonusNumberCount);
    }
}
