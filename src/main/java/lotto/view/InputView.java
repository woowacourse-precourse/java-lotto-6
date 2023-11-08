package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.InputMessages;

public class InputView {

    public String purchaseAmountInput() {
        System.out.println(InputMessages.ASK_PURCHASE_AMOUNT.getMessage());
        return Console.readLine();
    }

    public String winningNumbersInput() {
        System.out.println(InputMessages.ASK_WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }

    public String bonusNumberInput() {
        System.out.println(InputMessages.ASK_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }

}