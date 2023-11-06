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
    private Bonus bonus;
    private Purchase purchase;

    public LottoGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playing() {
        purchase = purchaseLottoTickets();
        getLottoTickets();
        getWinningNumbers();
        getBonusNumber();
        getLotteryStatistics();
    }

    private void getLottoTickets() {
        lottoMachine = new LottoMachine(purchase.getTicketCount());
        outputView.printPurchases(purchase.getTicketCount());
        outputView.printIssuedLotto(lottoMachine.getIssuedLotto());
    }

    private Purchase purchaseLottoTickets() {
        Purchase purchase = new Purchase();
        purchase.getInput(
            inputView::requestPrice, // requestPrice() 메서드를 호출하고 결과를 반환하는 람다 표현식
            (validator, price) -> purchase.setOrderInfo(price)
        );
        return purchase;
    }

    private void getWinningNumbers() {
        winningLotto = new WinningLotto();
        winningLotto.getInput(
            inputView::requestWinningNumber, // requestPrice() 메서드를 호출하고 결과를 반환하는 람다 표현식
            (validator, numbers) -> winningLotto.setWinningNumber(numbers)
        );
    }

    private void getBonusNumber() {
        bonus = new Bonus();
        bonus.getInput(
            inputView::requestBonusNumber, // requestPrice() 메서드를 호출하고 결과를 반환하는 람다 표현식
            (validator, number) -> bonus.setBonusNumber(winningLotto.getNumbers(), number)
        );
    }

    private void getLotteryStatistics() {
        LottoResultChecker resultChecker = new LottoResultChecker(lottoMachine.getIssuedLotto(), winningLotto, bonus);
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
