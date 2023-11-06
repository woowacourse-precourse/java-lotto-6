package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readAmount() {
        OutputView.printInputAmountMessage();
        return Console.readLine();
    }

    public static String readWinningNumbers() {
        OutputView.printInputWinningNumbersMessage();
        return Console.readLine();
    }
}
