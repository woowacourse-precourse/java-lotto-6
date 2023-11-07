package lotto;

import java.util.List;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmountInput();
        List<Lotto> lotteries = LottoGenerator.generateLotteries(purchaseAmount);
        OutputView.printPurchasedLotteryNumbers(lotteries);
        List<Integer> winningNumbers = InputView.getWinningNumbers();
    }
}
