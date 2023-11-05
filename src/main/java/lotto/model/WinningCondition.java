package lotto.model;

public class WinningCondition {
    public int winningNumberCount;
    public boolean containBonusNumber;
    public int winningAmount;

    public WinningCondition(int winningNumberCount, boolean containBonusNumber, int winningAmount){
        this.winningNumberCount = winningNumberCount;
        this.containBonusNumber = containBonusNumber;
        this.winningAmount = winningAmount;
    }
}
