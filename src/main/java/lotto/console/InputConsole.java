package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Util;

public class InputConsole {
    private static final String READ_MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ERROR_MESSAGE_PURCHASE_AMOUNT = "[ERROR] 구입금액은 숫자로 입력해주세요.";

    public int readPurchaseAmount() {
        System.out.println(READ_MESSAGE_PURCHASE_AMOUNT);
        String purchaseAmount = Console.readLine();

        if (!Util.isNumber(purchaseAmount)) {
            System.out.println(ERROR_MESSAGE_PURCHASE_AMOUNT);
            return readPurchaseAmount();
        }

        return Integer.parseInt(purchaseAmount);
    }
}
