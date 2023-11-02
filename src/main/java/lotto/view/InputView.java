package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Message;

public class InputView {

    public static String readPurchaseAmount() {
        Message message = Message.PURCHASE_AMOUNT_INPUT_MESSAGE;
        System.out.println(message.getMessage());
        return Console.readLine();
    }

    public static String readWinningNumbers() {
        Message message = Message.WINNING_NUMBERS_INPUT_MESSAGE;
        System.out.println(message.getMessage());
        return Console.readLine();
    }
}
