package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputMoney() {
        OutputView.printAskMoneyMessage();
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        OutputView.printAskWinningNumbersMessage();
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        OutputView.printAskBonusNumberMessage();
        return Console.readLine();
    }
}