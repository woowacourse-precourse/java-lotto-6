package lotto.controller;

import lotto.model.LottoBuyer;
import lotto.model.dto.BuyerLottoHistory;
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
        int purchaseAmount = askPurchaseAmount();
        LottoBuyer buyer = new LottoBuyer();
        buyer.buyLotto(purchaseAmount, new RandomLottoNumbersGenerator());
        logBuyHistory(buyer);
    }

    private static int askPurchaseAmount() {
        OutputView.printPurchaseAmountPrompt();
        return InputView.readPurchaseAmount();
    }

    private static void logBuyHistory(LottoBuyer lottoBuyer) {
        BuyerLottoHistory buyerLottoHistory = lottoBuyer.generateBuyerLottoHistory();
        OutputView.printBuyerLottoHistory(buyerLottoHistory);
    }
}
