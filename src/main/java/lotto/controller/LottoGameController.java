package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.service.PurchaseService;
import lotto.service.WinningNumberService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final PurchaseService purchaseService;
    private final WinningNumberService winningNumberService;
    private LottoTicket lottoTicket;

    public LottoGameController() {
        purchaseService = new PurchaseService();
        winningNumberService = new WinningNumberService();
    }

    public void runLottoGame() {
        buyLottoTicket();
        setWinningNumbers();
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
        // 보너스 번호
        OutputView.printRequestBonusNumber();
        String bonusNumber = InputView.readLine();
        winningNumberService.setBonusNumbers(bonusNumber);
    }

    private void printResults() {

        // 당첨 통계 출력
        OutputView.printResponseWinningStats();
        OutputView.printResponseProfitRate();
    }
}
