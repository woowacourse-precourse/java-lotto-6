package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputAmount() {
        OutputView.printInputAmountMessage();
        return Console.readLine();
    }

    public static String inputWinningNumber() {
        OutputView.printInputWinningNumberMessage();
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        OutputView.printInputBonusNumberMessage();
        return Console.readLine();
    }
}
