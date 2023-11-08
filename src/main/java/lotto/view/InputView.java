package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int getPurchaseAmount() {
        return Integer.parseInt(Console.readLine());
    }

    public String getWinningNumbers() {
        return Console.readLine();
    }

    public int getBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
