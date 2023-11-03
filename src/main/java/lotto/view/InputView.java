package lotto.view;

import static lotto.view.constans.constantMessage.ASK_PURCHASEAMOUNT;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constans.constantMessage;

public class InputView {
    public static int requestPurchaseAmount() {
        printConstantMessage(ASK_PURCHASEAMOUNT);
        return Integer.parseInt(Console.readLine());
    }

    public static void printConstantMessage(constantMessage constantMessage) {
        System.out.println(constantMessage.getMessage());
    }
}