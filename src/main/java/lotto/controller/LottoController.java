package lotto.controller;

import lotto.domain.PurchaseBudget;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void play() {
        PurchaseBudget purchaseBudget = InputView.getPurchaseBudget();
        OutputView.announceIssuedLottos(purchaseBudget.createQuantity());
    }
}
