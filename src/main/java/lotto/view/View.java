package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.view.message.Messageable;
import lotto.view.message.Prompt;

public class View {
    public static String inputPurchaseAmount() {
        printMessage(Prompt.PURCHASE_AMOUNT);
        return readLine();
    }

    public static void printMessage(Messageable message) {
        System.out.println(message.getMessage());
    }
}
