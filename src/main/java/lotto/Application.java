package lotto;

import java.util.Map;
import view.Input;
import view.Output;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = Input.getPurchaseAmount();
        Lotteries lotteries = new Lotteries(purchaseAmount);
        Output.printIssuedLotto(lotteries.getLotteries());
        Lotto winningNumbers = Input.getWinningNumbers();
        int bonusNumber = Input.getBonusNumber(winningNumbers);
        Map<WinningRanking, Integer> winningStatistics = lotteries.getWinningStatistics(winningNumbers, bonusNumber);
        Output.printWinningStatistics(winningStatistics);
        String rateOfReturn = Output.getRateOfReturn(winningStatistics, purchaseAmount);
        Output.printRateOfReturn(rateOfReturn);
    }
}
