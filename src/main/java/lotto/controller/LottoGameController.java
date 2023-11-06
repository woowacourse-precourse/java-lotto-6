package lotto.controller;

import lotto.model.domain.Bonus;
import lotto.model.domain.LottoMachine;
import lotto.model.domain.LottoResultChecker;
import lotto.model.domain.Purchase;
import lotto.model.domain.Statistics;
import lotto.model.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoMachine lottoMachine;
    private WinningLotto winningLotto;
    private Purchase purchase;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playing() {
        purchase = purchaseLottoTickets();
        getLottoTickets();
        enterWinningNumbersAndBonusNumber();
        getLotteryStatistics();
    }

    private Purchase purchaseLottoTickets() {
        purchase = new Purchase();
        while(purchase.getInputUntilValid()) {
            try {
                String price = inputView.requestPrice();
                purchase.setOrderInfo(price);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return purchase;
    }

    private void getLottoTickets() {
        lottoMachine = new LottoMachine(purchase.getTicketCount());
        outputView.printPurchases(purchase.getTicketCount());
        outputView.printIssuedLotto(lottoMachine.getIssuedLotto());
    }

    private void enterWinningNumbersAndBonusNumber() {
        String winningNumbers = inputView.requestWinningNumber();
        winningLotto = new WinningLotto(winningNumbers);
        int bonusNumber = inputView.requestBonusNumber();
        winningLotto.addBonus(new Bonus(bonusNumber));
    }

    private void getLotteryStatistics() {
        LottoResultChecker resultChecker = new LottoResultChecker(lottoMachine.getIssuedLotto(), winningLotto);
        Statistics statistics = new Statistics();
        statistics.makeResultBoard();
        statistics.createData(resultChecker.checkResult());

        outputView.printLotteryStatistics();
        outputView.printStatisticsResult(statistics.getResults());

        float revenue = statistics.getRateOfReturn();
        float result = (revenue / purchase.getPrice()) * 100 ;

        outputView.printRateOfReturn(result);
    }
}
