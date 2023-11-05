package lotto.view;

import static lotto.view.Message.*;

public class OutputView {
    public static void printPurchaseAmountMessage(){
        System.out.println(PURCHASE_AMOUNT_MESSAGE.getMessage());
    }
    public static void printWinningNumbersMessage(){
        System.out.println(WINNING_NUMBERS_MESSAGE.getMessage());
    }
    public static void printBonusNumberMessage(){
        System.out.println(BONUS_NUMBER_MESSAGE.getMessage());
    }
    private static void printMessage(){
        System.out.println();
    }
    private static void printMessage(String message){
        System.out.println(message);
    }
}
