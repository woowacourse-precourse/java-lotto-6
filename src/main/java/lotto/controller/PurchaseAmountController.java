package lotto.controller;

import lotto.constant.Phrases;
import lotto.domain.PurchaseCounter;
import lotto.domain.db.PurchaseAmount;
import lotto.view.InputAboutPurchaseAmount;
import lotto.view.OutputAboutException;
import lotto.view.OutputAboutPurchaseAmount;

public class PurchaseAmountController {
    public static int amountControl() {
        String amount = "";
        PurchaseAmount newAmount;
        int lottoCount;

        while (true) {
            try {
                OutputAboutPurchaseAmount.printInputPurchaseAmoubnt();
                amount = InputAboutPurchaseAmount.readAmount();
                newAmount = new PurchaseAmount(amount);
                lottoCount = new PurchaseCounter().counter(newAmount.getAmount());
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputAboutException.printException(Phrases.numberDuplication);
            }
        }


        OutputAboutPurchaseAmount.printResultPurchase(lottoCount);

        return lottoCount;
    }
}
