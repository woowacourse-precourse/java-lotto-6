package lotto.view.console;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readAmount() {
        return Console.readLine();
    }

    public static String readWinningNumbers() {
        OutputView.printInputWinningNumbersMessage();
        return Console.readLine();
    }
}
