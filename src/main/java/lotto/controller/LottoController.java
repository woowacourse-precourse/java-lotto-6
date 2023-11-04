package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.console.util.InputUtil;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<Lotto> lottos = buyLottos();
        displayPurchasedLottos(lottos);
        WinningLotto winningLotto = determineWinningLotto();
        WinningStatistics winningStatistics = calculateWinningStatistics(lottos, winningLotto);
        displayWinningStatistics(winningStatistics);
    }

    private List<Lotto> buyLottos() {
        return InputUtil.retryOnException(() -> {
            int purchaseAmount = inputView.readPurchaseAmount();
            LottoStore lottoStore = new LottoStore();
            return lottoStore.buyLottos(purchaseAmount);
        }, true);
    }

    private WinningLotto determineWinningLotto() {
        Lotto winningNumbers = InputUtil.retryOnException(() -> {
            List<Integer> winningNumbersInput = inputView.readWinningNumbers();
            return new Lotto(winningNumbersInput);
        });

        return InputUtil.retryOnException(() -> {
            int bonusNumber = inputView.readBonusNumber();
            return new WinningLotto(winningNumbers, bonusNumber);
        });
    }

    private WinningStatistics calculateWinningStatistics(List<Lotto> lottos, WinningLotto winningLotto) {
        WinningResult winningResult = new WinningResult(lottos, winningLotto);
        return new WinningStatistics(winningResult);
    }

    private void displayPurchasedLottos(List<Lotto> lottos) {
        outputView.displayPurchasedLottos(lottos);
    }

    private void displayWinningStatistics(WinningStatistics winningStatistics) {
        outputView.displayWinningStatistics(winningStatistics);
    }
}
