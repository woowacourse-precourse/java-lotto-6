package lotto.controller;

import lotto.domain.Judge;
import lotto.domain.Money;
import lotto.domain.User;
import lotto.util.Input;

public class Controller {
    public void run() {
        Money money = Input.inputMoney();
        User user = new User(money.calculateGameCount());
        judge(money, user);
    }

    private void judge(Money money, User user) {
        Judge judge = new Judge(Input.inputAnswerLotto(), Input.inputBonusNumber(), user, money.getMoney());
        judge.checkWinning();
        judge.finalResult();
    }
}
