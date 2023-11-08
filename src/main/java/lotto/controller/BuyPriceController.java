package lotto.controller;

import lotto.model.BuyPriceValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class BuyPriceController {
    OutputView outputView = new OutputView();

    public int setBuyPrice() {
        String buyPrice;
        while (true) {
            try {
                outputView.printInsertBuyPrice();
                buyPrice = InputView.insertBuyPrice();
                new BuyPriceValidator(buyPrice);
                return InputView.convertToInt(buyPrice);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
