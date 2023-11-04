package lotto.controller;

import lotto.view.validator.PurchasePriceValidator;
import lotto.view.InputView;

public class LottoGame {

    public void run() {
        String purchasePrice = InputView.inputPurchasePrice();
        System.out.println("입력한 값" + purchasePrice);


    }

}
