package lotto.controller;

import lotto.util.Validator;
import lotto.view.InputView;

public class GameController {
    InputView inputView = new InputView();
    Validator validator = new Validator();
    public void play() {
        int payment = buyLotto();
    }

    private int buyLotto() {
        try {
            return validator.validate(inputView.getPayment());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println();
            return buyLotto();
        }
    }
}
