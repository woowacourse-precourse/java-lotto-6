package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Message.InputMessage;

public class InputView {
    public static String totalCost() {
        System.out.println(InputMessage.TOTAL_COST);
        return Console.readLine();
    }

    public static String winningNumber() {
        System.out.println(InputMessage.WINNING_NUMBER);
        return Console.readLine();
    }

    public static String bonusNumber() {
        System.out.println(InputMessage.BONUS_NUMBER);
        return Console.readLine();
    }
}
