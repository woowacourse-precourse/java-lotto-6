package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoProcess;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;
    private final LottoProcess lottoProcess;

    public LottoController(OutputView outputView, InputView inputView, LottoProcess lottoProcess) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.lottoProcess = lottoProcess;
    }

    public void run() {
        int purchaseAmount = inputView.getPurchaseAmount();

        List<Lotto> purchaseLotto = getPurchaseLotto(purchaseAmount);
        WinningLotto winningLotto = getWinningLotto();

        outputView.showPrizeResult(purchaseLotto, winningLotto, purchaseAmount);
    }

    private List<Lotto> getPurchaseLotto(int purchaseAmount) {
        List<Lotto> purchaseLotto = lottoProcess.purchaseLotto(purchaseAmount);
        outputView.showPurchasedLottos(purchaseLotto);
        return purchaseLotto;
    }

    private WinningLotto getWinningLotto() {
        Lotto winningNumbers = inputView.getWinningNumbers();
        int bonusNumber = inputView.getBonusNumber();

        return new WinningLotto(winningNumbers, bonusNumber);
    }
}
