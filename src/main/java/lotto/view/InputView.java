package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView(){}

    public static String lottoPurchaseAmount() {
        return Console.readLine();
    }
    public static String winnerNumbers() {
        return Console.readLine();
    }
    public static String bonusNumber() {
        return Console.readLine();
    }
}
