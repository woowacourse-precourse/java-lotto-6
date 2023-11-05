package lotto.view;

import static lotto.view.Message.*;

public class OutputView {
    public static void printPurchaseAmountMessage(){
        printMessage(PURCHASE_AMOUNT_MESSAGE.getMessage());
    }
    public static void printTicketCountMessage(int ticketCount){
        printMessage();
        printMessage(TICKET_COUNT_MESSAGE.formatMessage(ticketCount));
    }
    public static void printWinningNumbersMessage(){
        printMessage(WINNING_NUMBERS_MESSAGE.getMessage());
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
