package lotto;

import lotto.domain.Lotto;
import lotto.domain.OutputHandler;
import lotto.domain.User;

import static lotto.constants.StaticMessage.*;
import static lotto.domain.InputHandler.*;
import static lotto.domain.Lotto.*;
import static lotto.domain.Lotto.checkWinOrNot;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        start();
    }

    public static void start() {
        User user = new User(askNumber(INPUT_PAYMENT));
        OutputHandler.printUserLottos(user.lottos);
        setWinningNumbers();
        checkWinOrNot(user);
        OutputHandler.printResultHistory(user);
    }
}