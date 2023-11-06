package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.parser.Parser;
import lotto.util.Generator;
import lotto.view.InputView;

public class Game {
    public static void start() {
        String purchaseAmount = InputView.requestPurchaseAmount();
        int ticketAmount = Parser.parsePurchaseAmount(purchaseAmount);
        List<Lotto> ticket = Generator.publishTicket(ticketAmount);

    }
}
