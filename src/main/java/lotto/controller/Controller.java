package lotto.controller;

import lotto.view.InputView;

public class Controller {
    InputView input = new InputView();

    public void startGame() {
        String amount = input.getUserBuyAmount();
    }

}
