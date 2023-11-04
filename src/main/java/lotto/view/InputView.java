package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorMessage;

public class InputView {
    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public String printAskPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
        return Console.readLine();
    }
}
