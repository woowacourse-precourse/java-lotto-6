package lotto;

import lotto.Input.InputType;
import lotto.Messages.MainMessage;

public class Print {
    public static void printMessage(String printStr){
        System.out.println(printStr);
    }
    public static void printPurchase(Integer purchaseAmount){
        System.out.printf((MainMessage.NUMBER_OF_ITEMS_PURCHASE.getMessage()) + "%n", purchaseAmount / 1000);
    }
    public static void printStatistics(Integer winningAmount){

    }
    public static void printInputMessage(InputType inputType){
        if (inputType == InputType.PURCHASE_AMOUNT){
            Print.printMessage(MainMessage.INPUT_PURCHASE_AMOUNT.getMessage());
        }
        if (inputType == InputType.BONUS_NUMBER){
            Print.printMessage(MainMessage.BONUS_NUMBER.getMessage());
        }
        if (inputType == InputType.WINNING_NUMBERS){
            Print.printMessage(MainMessage.WINNING_NUMBER.getMessage());
        }
    }
}