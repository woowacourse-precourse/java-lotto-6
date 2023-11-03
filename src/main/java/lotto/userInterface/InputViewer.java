package lotto.userInterface;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.StringChanger;

public class InputViewer {
    private InputViewer() {
    }

    public static String requestAmountInput() {
        OutputViewer.printRequestAmountMessage();
        return StringChanger.trimString(Console.readLine());
    }
}
