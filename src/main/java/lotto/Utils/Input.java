package lotto.Utils;

import camp.nextstep.edu.missionutils.Console;


public class Input {


    public String purchaseAmount() {
        Output.printPurchaseAmount();
        String input = Console.readLine();
        return input;
    }

    public String enterLottoNumbers() {
        Output.printEnterNumbers();
        String input = Console.readLine();
        return input;
    }

    public String bonusNumber() {
        Output.printBonusNumber();
        String input = Console.readLine();
        return input;
    }
}
