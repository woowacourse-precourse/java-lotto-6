package lotto.controller;

import lotto.model.Bonus;
import lotto.model.LottoMachine;
import lotto.model.LottoResultChecker;
import lotto.model.Statistics;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoMachine lottoMachine;
    private WinningLotto winningLotto;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playing() {
        purchaseLottoTickets();
        getLottoTickets();
        enterWinningNumbersAndBonusNumber();
        getLotteryStatistics();
    }

    private void purchaseLottoTickets() {
        int price = inputView.requestPrice();
        int tickets = outputView.printPurchases(price);
        lottoMachine = new LottoMachine(tickets);
    }

    private void getLottoTickets() {
        lottoMachine.issueTickets();
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
        float result = (revenue / lottoMachine.getLottoPrice()) * 100 ;

        outputView.printRateOfReturn(result);
    }
}
