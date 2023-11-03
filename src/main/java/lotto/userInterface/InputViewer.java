package lotto.userInterface;

import camp.nextstep.edu.missionutils.Console;

public class InputViewer {
    private InputViewer() {
    }

    public static String requestAmountInput() {
        OutputViewer.printRequestAmountMessage();
        return Console.readLine();
    }
}
