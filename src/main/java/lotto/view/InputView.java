package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getInputAmount() {
        OutputView.printPurchaseLotto();
        return Console.readLine();
    }

    public static String getWinningLotto() {
        OutputView.printWinningLotto();
        return Console.readLine();
    }

    public static String getBonusNumber() {
        OutputView.printBonusNumber();
        return Console.readLine();
    }
}
