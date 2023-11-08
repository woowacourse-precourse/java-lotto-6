package lotto.controller;

import static lotto.view.constants.OutputMessage.PURCHASE_MESSAGE;

import lotto.domain.PurchaseAmount;
import lotto.domain.PurchasedLotto;
import lotto.view.OutputView;

public class LottoPurchaseService {

    public PurchasedLotto createPurchasedLotto(PurchaseAmount purchaseAmount) {
        return purchaseAmount.purchaseLotto();
    }

    public void printPurchasedLottoCount(int count) {
        String purchaseMessage = String.format(PURCHASE_MESSAGE.getMessage(), count);

        OutputView.printNewLine();
        OutputView.printMessage(purchaseMessage);
    }

    public void printPurchasedLotto(PurchasedLotto purchasedLotto) {
        purchasedLotto.getLottos()
                .forEach(lotto -> OutputView.printNumbers(lotto.getLotto()));
        OutputView.printNewLine();
    }

}
