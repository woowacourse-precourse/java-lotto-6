package lotto.controller;

import lotto.domain.BuyPrice;
import lotto.domain.Tickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class SlotMachine {

    public static void run() {
        BuyPrice price = requestValidBuyPrice();
        int count = price.getBuyCount();
        Tickets lottos = Tickets.generate(count);
        OutputView.printBuyLottos(count, lottos.toString());
    }

    private static BuyPrice requestValidBuyPrice() {
        while (true) {
            try {
                return BuyPrice.from(InputView.askBuyPrice());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
