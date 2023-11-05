package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void play() {
        buyLotto();
        getWinningLotto();
        getLottoResult();
        printLottoResult();
    }

    private void buyLotto() {
        String money = inputView.printAskPurchase();
        List<Lotto> lottoTickets = lottoService.buyLottoTickets(money);
        outputView.printLottoTickets(lottoTickets);
    }

    private void getWinningLotto() {
        String winningNumber = inputView.askWinningNumbers();
        String bonusNumber = inputView.askBonusNumber();

        lottoService.getWinningLotto(winningNumber, bonusNumber);
    }

    private void getLottoResult() {
        //TODO: 당첨 통계 계산 및 정보 전달
        lottoService.getLottoResult();

    }

    private void printLottoResult() {
        //TODO: view를 통해 당첨 개수 & 총 수익률 출력

    }
}
