package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private String getMoneyInput() {
        return Console.readLine();
    }

    public int getMoney() {
        return Integer.parseInt(getMoneyInput());
    }

    public String getWinningNumbersInput() {
        return Console.readLine();
    }

    public String getBonusNumberInput() {
        return Console.readLine();
    }
}
