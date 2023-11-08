package lotto.controller;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinningNumber;
import lotto.service.PurchaseService;
import lotto.service.ResultService;
import lotto.service.WinningNumberService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final PurchaseService purchaseService;
    private final WinningNumberService winningNumberService;
    private final ResultService resultService;
    private LottoTicket lottoTicket;
    private LottoWinningNumber lottoWinningNumber;
    private LottoResult lottoResult;

    public LottoGameController() {
        purchaseService = new PurchaseService();
        winningNumberService = new WinningNumberService();
        resultService = new ResultService();
    }

    public void runLottoGame() {
        buyLottoTicket();
        setWinningNumbers();
        calculateResults();
        printResults();
    }

    private void buyLottoTicket() {
        OutputView.printRequestPurchaseAmount();

        String PurchaseAmount = InputView.readLine();
        lottoTicket = purchaseService.buyLottoTicket(PurchaseAmount);

        OutputView.printPurchaseResult(lottoTicket);
    }

    private void setWinningNumbers() {
        OutputView.printRequestWinningNumber();
        String winningNumbers = InputView.readLine();
        winningNumberService.setWinningNumbers(winningNumbers);

        OutputView.printRequestBonusNumber();
        String bonusNumber = InputView.readLine();
        winningNumberService.setBonusNumbers(bonusNumber);

        lottoWinningNumber = winningNumberService.getLottoWinningNumber();
    }

    private void calculateResults() {
        lottoResult = resultService.calculateResults(lottoTicket, lottoWinningNumber);
    }

    private void printResults() {
        OutputView.printResponseWinningStats(lottoResult);
        OutputView.printResponseProfitRate(lottoResult, lottoTicket);
    }
}
