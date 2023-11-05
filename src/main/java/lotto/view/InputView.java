package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String inputAmount() {
        OutputView.printInputAmountMessage();
        return Console.readLine();
    }

    public static final String inputWinningNumber() {
        OutputView.printInputWinningNumberMessage();
        return Console.readLine();
    }

    public static final String inputBonusNumber() {
        OutputView.printInputBonusNumberMessage();
        return Console.readLine();
    }
}
