package lotto;

import lotto.Messages.MainMessage;

public class Print {
    public static void printMessage(String printStr){
        System.out.println(printStr);
    }
    public static void printPurchase(Integer purchaseAmount){
        System.out.printf((MainMessage.NUMBER_OF_ITEMS_PURCHASE.getMessage()) + "%n", purchaseAmount);
    }
    public static void printStatistics(Integer winningAmount){

    }
}