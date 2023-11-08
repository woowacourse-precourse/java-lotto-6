package lotto;

import java.util.List;

public class LottoGame {

    public void startGame() {
        ConsoleManager consoleManager = new ConsoleManager();
        ResultPrinter resultPrinter = new ResultPrinter();
        LottoShop lottoShop = new LottoShop();
        ResultChecker resultChecker = new ResultChecker();

        int amount = consoleManager.getPurchaseAmount(); // 구매 수량 사용자가 입력
        LottoTicket purchasedTickets = lottoShop.buyLottoTicket(amount); // 입력한 수량 만큼 로또 구매
        List<Lotto> lottos = purchasedTickets.getLottos(); // 로또 티켓 가져오기
        resultPrinter.printPurchasedLotto(lottos); // 구입한 로또 티켓 출력

        List<Integer> winningNumbers = consoleManager.getWinningNumbers(); // 당첨 번호 사용자 입력
        int bonusNumber = consoleManager.getBonusNumber();


        WinningStats winningStats = resultChecker.checkResult(lottos, winningNumbers, bonusNumber);

        double totalEarningRate = new ProfitCalculator().calculateProfit(winningStats);

        resultPrinter.printResult(winningStats);
        resultPrinter.printTotalEarningRate(totalEarningRate);
    }
}
