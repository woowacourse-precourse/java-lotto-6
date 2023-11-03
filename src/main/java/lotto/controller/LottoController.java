package lotto.controller;

import lotto.model.User;
import lotto.view.InputView;

public class LottoController {

    public void run() {
        int amount = InputView.inputAmount();
        User user = User.from(amount);
    }
}
