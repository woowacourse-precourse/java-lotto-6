package lotto.view;

import static java.lang.String.*;
import static lotto.view.ConsoleMessage.ENTER_BONUS_NUMBER;
import static lotto.view.ConsoleMessage.ENTER_PURCHASE_AMOUNT;
import static lotto.view.ConsoleMessage.ENTER_WINNING_NUMBERS;
import static lotto.view.ConsoleMessage.SUCCESS_PURCHASE_LOTTO;

import java.util.List;

public class OutputView {
    
    public static void printEnterPurchaseAmount() {
        println(ENTER_PURCHASE_AMOUNT.getMessage());
    }
    
    public static void printLotteriesInfo(List<String> lotteries) {
        printNewLine();
        println(format(SUCCESS_PURCHASE_LOTTO.getMessage(), lotteries.size()));
        for (String lottery : lotteries) {
            println(lottery);
        }
        printNewLine();
    }
    
    public static void printEnterWinningNumbers() {
        printNewLine();
        println(ENTER_WINNING_NUMBERS.getMessage());
    }
    
    public static void printEnterBonusNumber() {
        printNewLine();
        println(ENTER_BONUS_NUMBER.getMessage());
    }
    
    public static void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }
    
    private static void print(final String message) {
        System.out.print(message);
    }
    
    private static void println(final String message) {
        System.out.println(message);
    }
    
    private static void printNewLine() {
        System.out.println();
    }
}
