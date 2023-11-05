package lotto.controller;

import lotto.domain.Computer;
import lotto.domain.Lottos;
import lotto.domain.User;
import lotto.view.InputView;

public class LottoController {

    User user;
    Computer computer;
    InputView inputView = new InputView();

    public void run() {
        user = new User(inputView.purchaseAmountMoney());
        computer = new Computer();
        computer.drawRandomNumber(user, new Lottos());
    }
}
