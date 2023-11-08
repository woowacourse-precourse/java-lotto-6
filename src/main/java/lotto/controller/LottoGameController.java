package lotto.controller;

import lotto.model.LottoBuyer;
import lotto.model.lottonumbersgenerator.RandomLottoNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    public static void play() {
        tryCatchTemplate(LottoGameController::buyAutoLotto);
    }

    private static void tryCatchTemplate(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            tryCatchTemplate(action);
        }
    }

    private static void buyAutoLotto() {
        LottoBuyer buyer = new LottoBuyer();
        int purchaseAmount = askPurchaseAmount();
        buyer.buyLotto(purchaseAmount, new RandomLottoNumbersGenerator());
    }

    private static int askPurchaseAmount() {
        OutputView.printPurchaseAmountPrompt();
        return InputView.readPurchaseAmount();
    }
}
