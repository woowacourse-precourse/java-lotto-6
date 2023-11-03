package lotto.controller;

import lotto.view.Output;

public class LottoController {

    private final Output output = new Output();

    public void run() {
        output.showMoneyInputMessage();
    }
}
