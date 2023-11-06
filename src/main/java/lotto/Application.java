package lotto;

import lotto.Exceptions.ManageExceptions;
import lotto.view.Input;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        ManageExceptions manageExceptions = new ManageExceptions();

        input.getBonusNum();
    }
}
