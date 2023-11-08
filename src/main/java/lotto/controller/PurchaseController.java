package lotto.controller;

import lotto.model.Purchase;
import lotto.view.InputView;
import lotto.view.OutputView;

public class PurchaseController {
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    public Integer getPurchaseNumber() {
        Purchase purchase = getPurchase();

        outputView.printNewLine();
        return purchase.getNumberOfPurchases();
    }

    private Purchase getPurchase() {
        try {
            outputView.printInputPurchaseMoneySentence();
            Integer money = inputView.inputNumber();
            Purchase purchase = new Purchase(money);
            return purchase;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchase();
        }
    }
}
