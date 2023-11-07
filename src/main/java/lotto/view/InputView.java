package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.GeneralMessage;

import static lotto.constant.GeneralMessage.ASK_BUY_PRICE;
import static lotto.constant.GeneralMessage.ASK_WINNING_NUMBERS;

public class InputView {
    private static String askWithGeneralMessage(GeneralMessage message) {
        OutputView.printGeneralMessage(message);
        String input = Console.readLine().trim();
        System.out.println();
        return input;
    }

    public static String askBuyPrice() {
        return askWithGeneralMessage(ASK_BUY_PRICE);
    }

    public static String askWinningNumbers() {
        return askWithGeneralMessage(ASK_WINNING_NUMBERS);
    }
}
