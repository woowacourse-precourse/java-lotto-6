package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.constant.DisplayMessages.*;

public class InputView {

    public static String PurchaseAmount() {
        System.out.println(LOTTO_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static String WinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER);
        return Console.readLine();
    }

    public static String BonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        return Console.readLine();
    }
}
