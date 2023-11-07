package lotto;

import lotto.constants.ErrorMessage;
import lotto.domain.InputHandler;
import lotto.domain.User;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        start();
    }

    public static void start() {
        User user = InputHandler.askPayment();
    }
}