package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.Integer.parseInt;

public class InputView {
    public InputView() {}

    public static String requestPayMoney() {
        return Console.readLine();
    }

    public static String requestWinningNumber() {
        return Console.readLine();
    }

    public static String requestBonusNumber() {
        return Console.readLine();
    }
}
