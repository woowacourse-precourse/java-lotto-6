package lotto.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.InputView.*;

public class InputController {

    public static String inputMoney() {
        printInputMoneyPhrase();
        return readLine();
    }

}
