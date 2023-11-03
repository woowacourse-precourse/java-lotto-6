package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.View.Constants.InputViewConstant;

public class InputView {
    public static String requestLottoPurchaseAmount() {
        System.out.println(InputViewConstant.ASK_LOTTO_PURCHASE_AMOUNT.getMessage());
        return Console.readLine();
    }
}
