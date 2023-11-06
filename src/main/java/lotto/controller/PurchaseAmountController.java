package lotto.controller;

import lotto.domain.PurchaseCounter;
import lotto.domain.db.PurchaseAmount;
import lotto.view.InputAboutPurchaseAmount;
import lotto.view.OutputAboutPurchaseAmount;

public class PurchaseAmountController {
    public static int amountControl() {
        OutputAboutPurchaseAmount.printInputPurchaseAmoubnt();
        PurchaseAmount newAmount = new PurchaseAmount(InputAboutPurchaseAmount.readAmount());
        int lottoCount = new PurchaseCounter().counter(newAmount.getAmount());
        OutputAboutPurchaseAmount.printResultPurchase(lottoCount);

        return lottoCount;
    }
}
