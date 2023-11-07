package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.service.LottoPurchaseService;
import lotto.service.LottoWinningNumberService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoPurchaseService lottoPurchaseService;
    private final LottoWinningNumberService lottoWinningNumberService;
    private LottoTicket lottoTicket;

    public LottoController() {
        lottoPurchaseService = new LottoPurchaseService();
        lottoWinningNumberService = new LottoWinningNumberService();
    }

    public void runLottoGame() {
        buyLottoTicket();
        setWinningNumbers();
        printResults();
    }

    private void buyLottoTicket() {
        OutputView.printRequestPurchaseAmount();

        String input = InputView.readLine();
        lottoTicket = lottoPurchaseService.buyLottoTicket(input);

        OutputView.printPurchaseResult(lottoTicket);
    }

    private void setWinningNumbers() {

        // 당첨 번호 입력
        OutputView.printRequestWinningNumber();
        InputView.readLine();

        // 보너스 번호 입력
        OutputView.printRequestBonusNumber();
        InputView.readLine();
    }

    private void printResults() {

        // 당첨 통계 출력
        OutputView.printResponseWinningStats();
        OutputView.printResponseProfitRate();
    }
}
