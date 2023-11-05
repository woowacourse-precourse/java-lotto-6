package lotto.controller;

import lotto.view.InputView;

public class LottoController {
    private InputController input;
    public LottoController() {
        input = new InputController(new InputView());

    }
    public void run(){

    }
}
