package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static constant.MessageList.INPUT_PURCHASE_AMOUNT_MESSAGE;
import static constant.MessageList.INPUT_WINNING_NUMBER_MESSAGE;

public class InputView {
    public static String getPurchaseAmountInputFromPlayer() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public static String getWinningNumberInputFromPlayer() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
