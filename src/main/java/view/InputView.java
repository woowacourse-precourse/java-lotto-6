package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int getPurchaseAmountInput() {
        OutputView.printPurchaseAmountInputMessage();
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
