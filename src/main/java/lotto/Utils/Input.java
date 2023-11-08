package lotto.Utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoMachine;


public class Input {
    LottoMachine box = new LottoMachine();
    private String input = Console.readLine();

    public String purchaseAmount() {
        Output.printPurchaseAmount();
        return input;
    }

    public String enterLottoNumbers() {
        Output.printEnterNumbers();
        return input;
    }

    public String bonusNumber() {
        Output.printBonusNumber();
        return input;
    }
}
