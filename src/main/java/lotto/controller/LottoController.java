package lotto.controller;

import lotto.domain.Computer;
import lotto.domain.User;
import lotto.view.InputView;

public class LottoController {

    User user;
    InputView inputView = new InputView();

    public void run(){
        user = new User(inputView.purchaseAmountMoney());
    }
}
