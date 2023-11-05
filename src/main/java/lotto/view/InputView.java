package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readAmount() {
        OutputView.printInputAmountMessage();
        return Console.readLine();
    }
}
