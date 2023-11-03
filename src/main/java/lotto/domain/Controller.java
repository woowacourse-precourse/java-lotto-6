package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;

public class Controller {
    public void run() {
        /**
         * 돈 입력 받기
         * 돈 만큼 로또 발행하기
         */
        purchaseLotto(inputMoneyFromUser());

    }

    private int inputMoneyFromUser() {
        try {
            Money money = new Money(InputView.inputMoney());
            return money.getMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoneyFromUser();
        }
    }

    private void purchaseLotto(int money) {

    }
}
