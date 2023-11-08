package lotto;

import lotto.model.Lotto;
import lotto.model.UserLotto;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money = InputView.moneyInput();
        UserLotto userLotto = InputView.lottosInput(money);
        System.out.println(userLotto.toString());
        Lotto winLotto = InputView.winNumInput();
        System.out.println(winLotto.toString());

    }
}
