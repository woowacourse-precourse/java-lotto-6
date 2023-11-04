package view;

import camp.nextstep.edu.missionutils.Console;
import util.InputMessage;

public class InputView {
    public static String enterPrice() {
        System.out.println(InputMessage.ENTER_PRICE);
        return Console.readLine();
    }

    public static String enterWinningNumbers() {
        System.out.println(InputMessage.ENTER_WINNING_NUMBERS);
        return Console.readLine();
    }

    public static String enterBonusNumbers() {
        System.out.println(InputMessage.ENTER_BONUS_NUMBERS);
        return Console.readLine();
    }
}
