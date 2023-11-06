package lotto.controller;

import lotto.domain.BuyPrice;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.constant.GeneralMessage.NOTIFY_BUY_COUNT;

public class SlotMachine {

    public static void run() {
        BuyPrice buyPrice = requestValidBuyPrice();
        OutputView.printGeneralMessage(NOTIFY_BUY_COUNT, buyPrice.getBuyCount());
    }

    private static BuyPrice requestValidBuyPrice() {
        BuyPrice buyPrice = null;
        boolean valid = false;
        while (!valid) {
            try {
                buyPrice = BuyPrice.from(InputView.askBuyPrice());
                valid = true;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
        return buyPrice;
    }
}
