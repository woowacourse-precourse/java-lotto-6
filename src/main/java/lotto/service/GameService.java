package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputValidator;
import lotto.view.OutputView;

public class GameService {

    static int lottoCnt;

    public static void startGame() {
        OutputView.printPurchaseAmountMessage();
        lottoCnt = InputValidator.checkPurchaseAmountInput(Integer.parseInt(Console.readLine()));
        System.out.println(lottoCnt);
    }

}
