package lotto.controller;

import lotto.domain.Price;
import lotto.view.InputPurchaseAmountView;

public class LottoController {

    private Price getLottoPrice(){
        InputPurchaseAmountView inputPurchaseAmountView = new InputPurchaseAmountView();
        int purchaseAmount = inputPurchaseAmountView.inputAmountView();
        return new Price(purchaseAmount);
    }
}
