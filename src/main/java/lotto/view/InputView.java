package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getMoneyInput() {
        return Console.readLine();
    }

    public String getWinningNumbersInput() {
        return Console.readLine();
    }

    public String getBonusNumberInput() {
        return Console.readLine();
    }
}
