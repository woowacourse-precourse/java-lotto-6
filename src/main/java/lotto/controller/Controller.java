package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.LottoOffice;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Controller {

    private Buyer buyer;
    private LottoOffice lottoOffice;

    public void run() {
        purchase();
        showLottoList();
        setLottoWinningNumbers();
        showResult();
    }

    private void purchase() {
        buyer = new Buyer(InputView.inputPurchaseAmount());
    }

    private void showLottoList() {
        OutputView.printLottoList(buyer.getLottoList(), buyer.getNumberOfLotto());
    }

    private void setLottoWinningNumbers() {
        List<Integer> winningNumbers = InputView.inputWinningNumber();
        int bonusNumber = InputView.inputBonusNumber(winningNumbers);
        lottoOffice = new LottoOffice(winningNumbers, bonusNumber);
    }

    private void showResult() {
        OutputView.printWinningStatistics(lottoOffice.getResult(buyer.getLottoList()), lottoOffice.getYield(buyer.getPurchaseAmount()));
    }
}
