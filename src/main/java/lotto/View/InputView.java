package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String requestLottoPurchaseAmount() {
        System.out.println(InputViewConstant.ASK_LOTTO_PURCHASE_AMOUNT.getMessage());
        return Console.readLine();
    }
}
