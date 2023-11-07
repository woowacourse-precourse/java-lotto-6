package lotto.domain.lotteryresult;

public class LotteryResult{

    private final WinningNumbers winningNumbers;
    private final Bonus bonus;

    public LotteryResult(WinningNumbers winningNumbers, Bonus bonus){
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
    }

}
