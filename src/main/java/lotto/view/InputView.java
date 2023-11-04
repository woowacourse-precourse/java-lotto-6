package lotto.view;

import javax.swing.plaf.PanelUI;

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
}