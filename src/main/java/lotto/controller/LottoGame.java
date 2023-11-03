package lotto.controller;

import lotto.controller.validator.PurchasePriceValidator;
import lotto.view.InputView;

public class LottoGame {

    public void run() {
        String purchasePrice = getPurchasePrice();
        System.out.println("입력한 값" + purchasePrice);


    }

    private String getPurchasePrice() {
        String inputPurchasePrice;
        do {
            inputPurchasePrice = InputView.inputPurchasePrice();
        } while (!PurchasePriceValidator.validatePurchasePrice(inputPurchasePrice));
        return inputPurchasePrice;
    }
}
