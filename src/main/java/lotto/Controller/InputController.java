package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;

public class InputController {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public String purchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        return Console.readLine();
    }
}
