package lotto.controller;


import lotto.domain.UserAmount;
import lotto.view.InputView;

public class LottoController {

    public void run() {
        UserAmount userAmount = InputView.getUserAmount();
    }

}

