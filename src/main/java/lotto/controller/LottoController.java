package lotto.controller;

import lotto.io.Input;
import lotto.io.Output;

public class LottoController {

    public void start() {
        Output output = new Output();
        output.printInputMoneyMessage();

        Input input = new Input();
        int money = input.getMoney();
    }
}
