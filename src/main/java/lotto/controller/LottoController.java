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
        buyLotto();
        generateWinningLotto();
    }

    private void buyLotto() {
        do {
            try {
                int purchaseAmount = InputView.enterLottoPurchaseAmount();
                lottoSystem.buyLotto(purchaseAmount);
                break;
            } catch (IllegalArgumentException exception) {
                exception.printStackTrace(System.out);
            }
        } while (true);

        PurchasedLotto purchasedLotto = lottoSystem.getPurchasedLotto();
        OutputView.printPurchasedLotto(purchasedLotto);
    }

    private void generateWinningLotto() {
        do {
            try {
                List<Integer> winningLottoNumbers = InputView.enterWinningLottoNumbers();
                lottoSystem.generateWinningLotto(winningLottoNumbers);
                break;
            } catch (IllegalArgumentException exception) {
                exception.printStackTrace(System.out);
            }
        } while (true);
    }
}
