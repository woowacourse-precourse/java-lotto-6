package lotto.common.console;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static final String READ_PURCHASE_AMOUNT = "구입금액을 입력해주세요.";

    public static String readPurchaseAmount() {
        Output.writeMessage(READ_PURCHASE_AMOUNT);

        return Console.readLine();
    }
}
