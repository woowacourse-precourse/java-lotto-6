package lotto;

import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money = InputView.moneyInput();

        System.out.println(money);
    }
}
