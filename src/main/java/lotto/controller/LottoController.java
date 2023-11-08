package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.dto.PurchaseAmount;
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
        PurchaseAmount purchaseAmount = pay();
        List<Lotto> issuedLotto = issueLotto(purchaseAmount);
        WinningLotto winningLotto = getWinningLotto();
        WinningResult winningResult = getWinningResult(issuedLotto, winningLotto);
        getProfitRate(purchaseAmount, winningResult);
    }

    private PurchaseAmount pay() {
        try {
            return PurchaseAmount.from(inputView.printAskPurchase());
        } catch (IllegalArgumentException e) {
            outputView.printErrorCode(e.getMessage());
            return pay();
        }
    }

    private List<Lotto> issueLotto(PurchaseAmount purchaseAmount) {
        try {
            List<Lotto> issuedTickets = lottoService.issueMultipleLotto(purchaseAmount);
            outputView.printLottoTickets(issuedTickets);
            return issuedTickets;
        } catch (IllegalArgumentException e) {
            outputView.printErrorCode(e.getMessage());
            return issueLotto(purchaseAmount);
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

    private WinningResult getWinningResult(List<Lotto> issuedLotto, WinningLotto winningLotto) {
        WinningResult winningResult = lottoService.getWinningResult(issuedLotto, winningLotto);
        outputView.printWinningResult(winningResult);
        return winningResult;
    }

    private void getProfitRate(PurchaseAmount purchaseAmount, WinningResult winningResult) {
        double profitRate = lottoService.calculateProfit(purchaseAmount, winningResult);
        outputView.printProfitRate(profitRate);
    }
}
