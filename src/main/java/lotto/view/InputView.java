package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputBuyingPrice() {
        printMessage(ViewMessage.INPUT_PRICE_MSG);
        return Console.readLine();
    }

    public static String inputWinningNumber() {
        printMessage(ViewMessage.INPUT_WINNING_MSG);
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        printMessage(ViewMessage.INPUT_BONUS_MSG);
        return Console.readLine();
    }

    private static void printMessage(ViewMessage msg) {
        System.out.println(msg.message());
    }
}
