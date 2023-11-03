package lotto.controller;

import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    private final Output output = new Output();
    private final Input input = new Input();

    public void run() {
        output.showMoneyInputMessage();
        input.readMoney();
    }
}
