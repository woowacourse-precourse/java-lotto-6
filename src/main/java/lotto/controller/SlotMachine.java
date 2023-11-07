package lotto.controller;

import lotto.domain.BuyPrice;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Tickets;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.function.Supplier;

public class SlotMachine {

    public static void run() {
        BuyPrice price = requestUntilValidated(() -> BuyPrice.from(InputView.askBuyPrice()));
        int count = price.getBuyCount();
        Tickets tickets = Tickets.generate(count);
        OutputView.printBuyLottos(count, tickets.toString());

        Lotto winning = requestUntilValidated(() -> Lotto.from(InputView.askWinningNumbers()));
        LottoNumber bonus = requestUntilValidated(() -> LottoNumber.from(InputView.askBonusNumber()));
    }

    private static <T> T requestUntilValidated(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
