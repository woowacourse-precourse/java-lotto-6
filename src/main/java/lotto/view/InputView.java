package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static String readMoney() {
        OutputView.printPurchase();
        return readLine();
    }

    public static String readAnswer() {
        OutputView.printAnswer();
        return readLine();
    }

    public static String readBonus() {
        OutputView.printBonus();
        return readLine();
    }
}