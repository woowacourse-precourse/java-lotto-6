package lotto;

import lotto.InputView;
import lotto.OutputView;
import lotto.Person;

public class Application {
    public static void main(String[] args) {
        Person me = new Person(new InputView(), new OutputView());
        me.buyLotto();
    }
}
