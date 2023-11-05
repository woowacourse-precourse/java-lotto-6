package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.manager.Exception;
import lotto.util.Util;

public class InputConsole {
    private static final String READ_MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public int readPurchaseAmount() {
        System.out.println(READ_MESSAGE_PURCHASE_AMOUNT);
        String purchaseAmount = Console.readLine();

        if (!Util.isNumber(purchaseAmount)) {
            Exception.PURCHASE_AMOUNT_NOT_NUMBER.throwing();
        }

        return Integer.parseInt(purchaseAmount);
    }
}
