package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        lottoService = new LottoService();
    }

    public void runLottoGame() {
        buyLottoTicket();
        setWinningNumbers();
        printResults();
    }

    private void buyLottoTicket() {
        // 구입 금액 입력
        OutputView.printRequestPurchaseAmount();
        lottoService.calculateLottoEntryCount(InputView.readLine());
        // 로또 구매 결과 출력
        OutputView.printResponsePurchaseAmount(1);
        // TODO: 구매 로또 번호 출력
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
