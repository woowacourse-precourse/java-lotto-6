package lotto.controller;

import lotto.domain.wrapper.Money;
import lotto.handler.InputHandler;

public class LottoController {

    private final InputHandler inputHandler;

    public LottoController(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void run() {
        Money money = loadTicket();
    }

    private Money loadTicket() {
        String money = inputHandler.inputValue();

        return Money.create(money);
    }
}
