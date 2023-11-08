package lotto.controller;

import lotto.model.Purchase;
import lotto.view.InputView;
import lotto.view.OutputView;

public class PurchaseController {
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    public Integer getPurchaseNumber() {
        Integer money = inputMoney();
        Purchase purchase = new Purchase(money);

        outputView.printNewLine();
        return purchase.getNumberOfPurchases();
    }

    private Integer inputMoney() {
        try {
            outputView.printInputPurchaseMoneySentence();
            Integer money = inputView.inputNumber();
            return money;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoney();
        }
    }
}
