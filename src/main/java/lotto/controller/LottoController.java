package lotto.controller;

import lotto.domain.Buyer;
import lotto.domain.LottoSystem;
import lotto.domain.WinningLotto;
import lotto.dto.PurchasedLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final LottoSystem lottoSystem = new LottoSystem(new Buyer(), new WinningLotto());

    public void start() {
        repeatExecutionOnFailure(this::buyLotto);
        repeatExecutionOnFailure(this::generateWinningLotto);
    }

    private void buyLotto() {
        int purchaseAmount = InputView.enterLottoPurchaseAmount();
        lottoSystem.buyLotto(purchaseAmount);

        PurchasedLotto purchasedLotto = lottoSystem.getPurchasedLotto();
        OutputView.printPurchasedLotto(purchasedLotto);
    }

    private void generateWinningLotto() {
        List<Integer> winningLottoNumbers = InputView.enterWinningLottoNumbers();
        lottoSystem.generateWinningLotto(winningLottoNumbers);
    }

    private void repeatExecutionOnFailure(Runnable runnable) {
        do {
            try {
                runnable.run();
                break;
            } catch (IllegalArgumentException exception) {
                exception.printStackTrace(System.out);
            }
        } while (true);
    }
}
