package lotto.controller;

import lotto.util.Constants;
import lotto.view.InputView;

import static lotto.view.OutputView.*;

public class GameController {

    public void start() {
        int ticketCount = buyLotto(InputView.getAmount());
    }

    private int buyLotto(int purchaseAmount) {
        int ticketCount = purchaseAmount / Constants.LOTTO_AMOUNT;
        printPurchaseAmount(ticketCount);

        return ticketCount;
    }
}
