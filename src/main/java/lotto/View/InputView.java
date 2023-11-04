package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import static lotto.View.InputViewConstant.*;

public class InputView {
    public static String requestLottoPurchaseAmount() {
        printMessage(ASK_LOTTO_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static String requestWinningNumbers() {
    	System.out.println();
        printMessage(ASK_LOTTO_RESULT);
        return Console.readLine();
    }

    public static String requestBonusNumber() {
    	System.out.println();
        printMessage(ASK_BONUS_NUMBER);
        return Console.readLine();
    }

    private static void printMessage(InputViewConstant inputViewConstant) {
        System.out.println(inputViewConstant.getMessage());
    }
}
