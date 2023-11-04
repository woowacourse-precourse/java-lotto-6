package lotto.controller;

import lotto.domain.Money;
import lotto.view.InputView;

public class LottoGameController {
    private Money money;

    public void startGame() {
        money = Money.from(InputView.inputAmount());
    }
}
