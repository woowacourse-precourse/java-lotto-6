package lotto.view;

import static lotto.view.constans.constantMessage.ASK_LOTTERYNUMBER;
import static lotto.view.constans.constantMessage.ASK_PURCHASEAMOUNT;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constans.constantMessage;

public class InputView {

    public static void printConstantMessage(constantMessage constantMessage) {
        System.out.println(constantMessage.getMessage());
    }
    public static String requestPurchaseAmount() {
        printConstantMessage(ASK_PURCHASEAMOUNT);
        return Console.readLine();
    }

    public static String requestLotteryNumber(){
        printConstantMessage(ASK_LOTTERYNUMBER);
        return Console.readLine();
    }
}