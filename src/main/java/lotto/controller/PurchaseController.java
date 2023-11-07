package lotto.controller;

import lotto.model.Purchase;
import lotto.view.InputView;
import lotto.view.OutputView;

public class PurchaseController {
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    public Integer getPurchaseNumber() {
        outputView.printInputPurchaseMoneySentence();
        Integer money = inputView.inputNumber();
        Purchase purchase = new Purchase(money);

        outputView.printNewLine();
        return purchase.getNumberOfPurchases();
    }
}
