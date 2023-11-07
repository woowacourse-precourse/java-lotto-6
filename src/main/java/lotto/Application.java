package lotto;

import lotto.constants.ErrorMessage;
import lotto.constants.StaticMessage;
import lotto.domain.InputHandler;
import lotto.domain.Lotto;
import lotto.domain.User;

import static lotto.constants.StaticMessage.*;
import static lotto.domain.InputHandler.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        start();
    }

    public static void start() {
        User user = new User(askNumber(INPUT_PAYMENT));


//        askWinningNumbers();
        inputController(askWinningNumbers());
    }
}