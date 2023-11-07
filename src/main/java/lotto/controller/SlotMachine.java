package lotto.controller;

import lotto.domain.BuyPrice;
import lotto.domain.LottoGroup;
import lotto.view.InputView;
import lotto.view.OutputView;

public class SlotMachine {

    public static void run() {
        BuyPrice buyPrice = requestValidBuyPrice();
        int count = buyPrice.getBuyCount();
        LottoGroup lottoGroup = LottoGroup.create(count);
        OutputView.printBuyLottos(count, lottoGroup.toString());
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
