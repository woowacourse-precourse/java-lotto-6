package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.dto.WinningLotto;
import lotto.dto.WinningResult;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView,
                           OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        buyLotto();
        WinningLotto winningLotto = getWinningLotto();
        getLottoResult(winningLotto);
        getProfitRate();
    }

    private void buyLotto() {
        try {
            String money = inputView.printAskPurchase();
            List<Lotto> lottoTickets = lottoService.buyMultipleLotto(money);
            outputView.printLottoTickets(lottoTickets);
        } catch (IllegalArgumentException e) {
            outputView.printErrorCode(e.getMessage());
            buyLotto();
        }
    }

    private WinningLotto getWinningLotto() {
        try {
            Lotto winningNumber = new Lotto(inputView.askWinningNumbers());
            LottoNumber bonusNumber = LottoNumber.from(inputView.askBonusNumber());
            return lottoService.getWinningLotto(winningNumber, bonusNumber);
        } catch (IllegalArgumentException e) {
            outputView.printErrorCode(e.getMessage());
            return getWinningLotto();
        }
    }

    private void getLottoResult(WinningLotto winningLotto) {
        WinningResult lottoResult = lottoService.getLottoResult(winningLotto);
        outputView.printWinningResult(lottoResult);
    }

    private void getProfitRate() {
        double profitRate = lottoService.calculateProfit();
        outputView.printProfitRate(profitRate);
    }
}
