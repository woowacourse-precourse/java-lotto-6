package lotto;

import java.util.List;

public class LottoGame {

    public void startGame() {
        ConsoleManager consoleManager = new ConsoleManager();
        ResultPrinter resultPrinter = new ResultPrinter();

        int amount = consoleManager.getPurchaseAmount();
        LottoShop lottoShop = new LottoShop();
        LottoTicket purchasedTickets = lottoShop.buyLottoTicket(amount);
        List<Lotto> lottos = purchasedTickets.getLottos();
        resultPrinter.printPurchasedLotto(lottos);

        List<Integer> winningNumbers = consoleManager.getWinningNumbers();
        int bonusNumber = consoleManager.getBonusNumber();


        ResultChecker resultChecker = new ResultChecker();
        WinningStats winningStats = resultChecker.checkResult(lottos, winningNumbers, bonusNumber);

        double totalEarningRate = new ProfitCalculator().calculateProfit(winningStats);

        resultPrinter.printResult(winningStats);
        resultPrinter.printTotalEarningRate(totalEarningRate);
    }
}
