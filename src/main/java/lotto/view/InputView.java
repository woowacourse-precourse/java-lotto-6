package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.InputMsg;

public class InputView {
    public static String purchaseAmount() {
        System.out.println(InputMsg.PURCHASE_AMOUNT.getMsg());
        return Console.readLine();
    }

    public static String winningNumber() {
        System.out.println(InputMsg.WINNING_NUMBER.getMsg());
        return Console.readLine();
    }

    public static String bonusNumber() {
        System.out.println(InputMsg.BONUS_NUMBER.getMsg());
        return Console.readLine();
    }
}
