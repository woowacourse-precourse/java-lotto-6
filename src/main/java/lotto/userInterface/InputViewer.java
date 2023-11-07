package lotto.userInterface;

import camp.nextstep.edu.missionutils.Console;

public class InputViewer {
    private InputViewer() {
    }

    public static String requestAmountInput() {
        OutputViewer.printRequestAmountMessage();
        return Console.readLine();
    }

    public static String requestFirstRankNumberInput() {
        OutputViewer.printRequestFirstRankNumberMessage();
        return Console.readLine();
    }

    public static String requestBonusNumberInput() {
        OutputViewer.printRequestBonusNumberMessage();
        return Console.readLine();
    }
}
