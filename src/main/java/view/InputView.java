package view;

import camp.nextstep.edu.missionutils.Console;
import message.InformationMessages;

public class InputView {
    InformationMessages messages = new InformationMessages();
    public String inputPurchaseAmount(){
        printMessage(messages.INPUT_PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public String inputWinningNumber(){
        printMessage(messages.INPUT_WINNING_NUMBER);
        return Console.readLine();
    }
    public String inputBonusNumber(){
        printMessage(messages.INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

    public void printMessage(String message){
        System.out.println(message);
    }
}
