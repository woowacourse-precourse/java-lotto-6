package lotto;

import lotto.controller.Person;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Person me = new Person(new InputView(), new OutputView());
        me.buyLotto();
    }
}
