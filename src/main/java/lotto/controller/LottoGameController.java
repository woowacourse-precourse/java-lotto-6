package lotto.controller;

import java.util.function.Supplier;
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

        lottoTicket = errorHandler(() -> {
            String PurchaseAmount = InputView.readLine();
            return purchaseService.buyLottoTicket(PurchaseAmount);
        });

        OutputView.printPurchaseResult(lottoTicket);
    }

    private void setWinningNumbers() {
        OutputView.printRequestWinningNumber();
        errorHandler(() -> {
            String winningNumbers = InputView.readLine();
            winningNumberService.setWinningNumbers(winningNumbers);
            return null;
        });

        OutputView.printRequestBonusNumber();
        errorHandler(() -> {
            String bonusNumber = InputView.readLine();
            winningNumberService.setBonusNumbers(bonusNumber);
            return null;
        });

        lottoWinningNumber = winningNumberService.getLottoWinningNumber();
    }

    private void calculateResults() {
        lottoResult = resultService.calculateResults(lottoTicket, lottoWinningNumber);
    }

    private void printResults() {
        OutputView.printResponseWinningStats(lottoResult);
        OutputView.printResponseProfitRate(lottoResult, lottoTicket);
    }

    private <T> T errorHandler(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
