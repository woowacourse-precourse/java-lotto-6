package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.GameMessage;

public class InputView {
    public static String getInputPurchaseAmount() {
        System.out.println(GameMessage.PURCHASE_AMOUNT.getMessage());
        return Console.readLine();
    }

    public static String getInputWinningNumber() {
        System.out.println(GameMessage.WINNING_NUMBER.getMessage());
        return Console.readLine();
    }

    public static String getInputBonusNumber() {
        System.out.println(GameMessage.BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
