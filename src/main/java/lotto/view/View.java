package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.view.message.Prompt;

public class View {
    public static String inputPurchaseAmount() {
        printMessage(Prompt.PURCHASE_AMOUNT.getMessage());
        return readLine();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
