package lotto.controller;

import lotto.domain.PurchaseBudget;
import lotto.domain.PurchaseQuantity;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void play() {
        PurchaseBudget purchaseBudget = InputView.getPurchaseBudget();

        PurchaseQuantity quantity = purchaseBudget.createQuantity();
        OutputView.announcePurchaseQuantity(quantity);
    }
}
