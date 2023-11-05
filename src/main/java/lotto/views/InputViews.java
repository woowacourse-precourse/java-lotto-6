package lotto.views;

import camp.nextstep.edu.missionutils.Console;

public class InputViews {
    static final String PURCHASE_INPUT_MESS = "구입금액을 입력해 주세요.";

    public static String readPurchaseAmount() {
        System.out.println(PURCHASE_INPUT_MESS);
        return Console.readLine();
    }
}
