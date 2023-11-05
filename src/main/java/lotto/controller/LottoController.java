package lotto.controller;

import lotto.domain.wrapper.Money;
import lotto.handler.InputHandler;
import lotto.handler.OutputHandler;

public class LottoController {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public LottoController(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        Money money = loadTicket();
    }

    private Money loadTicket() {
        outputHandler.printInputMoneyMessage();
        String money = inputHandler.inputValue();

        return Money.create(money);
    }
}
