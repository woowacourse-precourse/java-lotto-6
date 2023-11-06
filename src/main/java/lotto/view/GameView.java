package lotto.view;

import static lotto.view.constants.ConstantMessage.ASK_LOTTO_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constants.ConstantMessage;

public class GameView {
    public static String inputLottoPurchaseAmount(){
        printConstantMessage(ASK_LOTTO_PURCHASE_AMOUNT);
        return Console.readLine();
    }


    public static void printConstantMessage(ConstantMessage constantMessage){
        System.out.println(constantMessage.getMessage());
    }

}
