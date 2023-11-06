package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.WinningResult;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void play() {
        try {
            buyLotto();
            getWinningLotto();
            getLottoResult();
        } catch (IllegalArgumentException e) {
            outputView.printErrorCode(e.getMessage());
        }
    }

    private void buyLotto() {
        String money = inputView.printAskPurchase();
        List<Lotto> lottoTickets = lottoService.buyMultipleLotto(money);
        outputView.printLottoTickets(lottoTickets);
    }

    private void getWinningLotto() {
        String winningNumber = inputView.askWinningNumbers();
        String bonusNumber = inputView.askBonusNumber();

        lottoService.getWinningLotto(winningNumber, bonusNumber);
    }

    private void getLottoResult() {
        WinningResult lottoResult = lottoService.getLottoResult();
        outputView.printWinningResult(lottoResult);

        double profitRate = lottoService.calculateProfit();
        outputView.printProfitRate(profitRate);
    }
}
