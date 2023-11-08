package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ConsoleMessage;

public class InputView {
    private InputView() {
    }

    public static void close() {
        Console.close();
    }

    public static String enterPurchaseAmount() {
        System.out.println(ConsoleMessage.ENTER_PURCHASE_AMOUNT.getMessage());
        return Console.readLine();
    }

    public static String enterWinningNumbers() {
        System.out.println(ConsoleMessage.ENTER_WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }

    public static String enterBonusNumber() {
        System.out.println(ConsoleMessage.ENTER_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
