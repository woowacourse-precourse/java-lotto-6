package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.OutputMessage;

public class InputView {
    public static String InputPurchase() {
        System.out.println(OutputMessage.ENTER_PURCHASE_AMOUNT);
        return Console.readLine();
    }
}
