package lotto.controller;

import lotto.view.Input;
import lotto.view.Output;

public class Controller {

    private final Input input;
    private final Output output;

    public Controller(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void lottoGame() {
        int insertedMoney = input.insertMoney();
    }

}
