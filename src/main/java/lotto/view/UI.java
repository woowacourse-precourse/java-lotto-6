package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constant.Instructions;

public class UI {

    public static String sendLottoPurchaseRequest() {
        displayMessage(Instructions.MESSAGE_OF_ENTERING_LOTTO_AMOUNT);
        String lottoPurchaseRequest  = Console.readLine();
        return lottoPurchaseRequest;
    }

    public static void displayMessage(final Instructions instructions) {
        System.out.println(instructions.getPrompts());
    }

}
