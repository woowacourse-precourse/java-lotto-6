package lotto;

import lotto.Messages.MainMessage;

public class Print {
    public static void printMessage(String printStr){
        System.out.println(printStr);
    }
    public static void printPurchase(Integer purchaseAmount){
        System.out.println(
                MainMessage.NUMBER_OF_ITEMS_PURCHASE.getMessage().
                        formatted(purchaseAmount)
        );
    }
    public static void printStatistics(Integer winningAmount){

    }
}