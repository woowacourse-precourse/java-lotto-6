package lotto.view;

import static lotto.view.constans.constantMessage.ASK_BONUS_NUMBER;
import static lotto.view.constans.constantMessage.ASK_LOTTERY_NUMBER;
import static lotto.view.constans.constantMessage.ASK_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constans.constantMessage;

public class InputView {

    public static void printConstantMessage(constantMessage constantMessage) {
        System.out.println(constantMessage.getMessage());
    }
    public static String requestPurchaseAmount() {
        printConstantMessage(ASK_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static String requestLotteryNumber(){
        printConstantMessage(ASK_LOTTERY_NUMBER);
        return Console.readLine();
    }

    public static String requestBonusNumber(){
        printConstantMessage(ASK_BONUS_NUMBER);
        return Console.readLine();
    }
}