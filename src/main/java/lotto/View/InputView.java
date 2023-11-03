package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import static lotto.View.InputViewConstant.*;

public class InputView {
    public static String requestLottoPurchaseAmount() {
        printMessage(ASK_LOTTO_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    private static void printMessage(InputViewConstant inputViewConstant) {
        System.out.println(inputViewConstant.getMessage());
    }
}
