package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.Instructions;

public class InputView {
    public String readPurchaseAmount() {
        System.out.println(Instructions.PURCHASE_AMOUNT.getInstruction());
        return Console.readLine();
    }

    public String readWinnerNumber() {
        System.out.println(Instructions.WINNING_NUMBER.getInstruction());
        return Console.readLine();
    }

    public String readBonusNumber() {
        System.out.println(Instructions.BONUS_NUMBER.getInstruction());
        return Console.readLine();
    }
}
