package lotto.controller;

import lotto.domain.PurchaseBudget;
import lotto.domain.PurchaseQuantity;
import lotto.view.OutputView;

import static lotto.constants.InputMessage.DEMAND_INPUT_BUDGET;
import static lotto.constants.OutputMessage.ANNOUNCE_PURCHASE_QUANTITY_FORMAT;
import static lotto.util.InputUtils.readInt;
import static lotto.view.InputView.*;

public class LottoController {

    public void play() {
        PurchaseBudget purchaseBudget = getPurchaseBudget();

        PurchaseQuantity purchaseQuantity = new PurchaseQuantity(purchaseBudget.getBudget());
        OutputView.println(String.format(ANNOUNCE_PURCHASE_QUANTITY_FORMAT.getMessage(), purchaseQuantity));
    }

    private PurchaseBudget getPurchaseBudget() {
        try {
            println(DEMAND_INPUT_BUDGET.getMessage());
            return new PurchaseBudget(readInt());
        } catch (IllegalArgumentException e) {
            println(e.getMessage());
            return getPurchaseBudget();
        }
    }
}
