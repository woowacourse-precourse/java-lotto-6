package lotto.controller;

import lotto.domain.Buyer;
import lotto.service.LottoService;
import lotto.domain.WinningLotto;
import lotto.dto.WinningResult;
import lotto.dto.PurchasedLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final LottoService lottoService = new LottoService(new Buyer(), new WinningLotto());

    public void start() {
        buyLotto();
        generateWinningLotto();
        inputBonusNumber();
        printWinningStatistics();
    }

    private void buyLotto() {
        repeatExecutionOnFailure(() -> {
            int purchaseAmount = InputView.enterLottoPurchaseAmount();
            lottoService.buyLotto(purchaseAmount);

            PurchasedLotto purchasedLotto = lottoService.getPurchasedLotto();
            OutputView.printPurchasedLotto(purchasedLotto);
        });
    }

    private void generateWinningLotto() {
        repeatExecutionOnFailure(() -> {
            List<Integer> winningLottoNumbers = InputView.enterWinningLottoNumbers();
            lottoService.generateWinningLotto(winningLottoNumbers);
        });
    }

    private void inputBonusNumber() {
        repeatExecutionOnFailure(() -> {
            int bonusNumber = InputView.enterBonusNumber();
            lottoService.inputBonusNumber(bonusNumber);
        });
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

    private void printWinningStatistics() {
        WinningResult winningResult = lottoService.getWinningResult();
        OutputView.printWinningResult(winningResult);
    }
}
