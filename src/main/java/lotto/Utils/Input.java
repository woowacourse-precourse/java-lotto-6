package lotto.Utils;

import camp.nextstep.edu.missionutils.Console;


public class Input {
    private String input = Console.readLine();

    public String purchaseAmount() {
        Output.printPurchaseAmount();
        return input;
    }

    public String enterNumbers() {
        Output.printEnterNumbers();
        return input;
    }

    public String bonusNumber() {
        Output.printBonusNumber();
        return input;
    }
}
