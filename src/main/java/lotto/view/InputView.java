package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readMoney() {
        OutputView.printPurchase();
        return Console.readLine();
    }

    public static String readAnswer() {
        OutputView.printAnswer();
        return Console.readLine();
    }

    public static String readBonus() {
        OutputView.printBonus();
        return Console.readLine();
    }
}
