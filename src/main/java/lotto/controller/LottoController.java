package lotto.controller;

import lotto.view.InputView;

public class LottoController {
    private InputController input;
    private int bonusNum;
    public LottoController() {
        input = new InputController(new InputView());
        input.setCost();
        bonusNum = input.setBonusNum();
        input.setLottoNum();
    }
    public void run(){


    }
}
