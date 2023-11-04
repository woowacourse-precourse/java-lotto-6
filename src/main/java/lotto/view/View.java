package lotto.view;

import static lotto.view.constants.MessageType.COST_REQUEST_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constants.MessageType;

public final class View {
    public static String requestCost() {
        printlnMessage(COST_REQUEST_MESSAGE);
        return enterMessage();
    }

    /* Output View */
    private static void printlnMessage(MessageType messageType) {
        System.out.println(messageType.getMessage());
    }

    /* Input View */
    private static String enterMessage() {
        return Console.readLine();
    }
}
