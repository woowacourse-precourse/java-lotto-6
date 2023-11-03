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

        List<Lotto> purchaseLotto = lottoProcess.purchaseLotto(purchaseAmount);

        outputView.showPurchasedLottos(purchaseLotto);

        Lotto winningNumbers = inputView.getWinningNumbers();

        int bonusNumber = inputView.getBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        outputView.showPrizeResult(purchaseLotto, winningLotto, purchaseAmount);
    }
}
