package lotto.controller;

import lotto.domain.wrapper.Money;
import lotto.handler.InputHandler;
import lotto.handler.OutputHandler;
import lotto.service.LottoService;

public class LottoController {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final LottoService lottoService;

    public LottoController(InputHandler inputHandler, OutputHandler outputHandler, LottoService lottoService) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.lottoService = lottoService;
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
