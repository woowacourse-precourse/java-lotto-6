package lotto;

import java.util.List;
import lotto.Input.InputType;
import lotto.Messages.MainMessage;
import lotto.Messages.WinningStatistics;

public class Print {
    public static void printMessage(String printStr){
        System.out.println(printStr);
    }
    public static void printPurchase(Integer purchaseCount){
        Print.printMessage("");
        System.out.printf((MainMessage.NUMBER_OF_ITEMS_PURCHASE.getMessage()) + "%n", purchaseCount);
    }
    public static void printInputMessage(InputType inputType){
        if (inputType == InputType.PURCHASE_AMOUNT){
            Print.printMessage(MainMessage.INPUT_PURCHASE_AMOUNT.getMessage());
        }
        if (inputType == InputType.BONUS_NUMBER){
            Print.printMessage("");
            Print.printMessage(MainMessage.BONUS_NUMBER.getMessage());
        }
        if (inputType == InputType.WINNING_NUMBERS){
            Print.printMessage("");
            Print.printMessage(MainMessage.WINNING_NUMBER.getMessage());
        }
    }
    public static void printLotto(List<Integer> lotto){
        System.out.println(lotto);
    }
    public static void printPurchasedLotto(List<Lotto> purchasedLotto){
        for (Lotto lotto : purchasedLotto){
            lotto.printLotto();
        }
    }

    public static void printWinningStatistics(Float rateOfReturn, int[] winningCount){
        Print.printMessage("");
        Print.printMessage(MainMessage.WINNING_STATISTICS.getMessage());
        printfMessage(WinningStatistics.WIN_3_MATCH.getMessage(), winningCount[Lotto.RANK_5]);
        printfMessage(WinningStatistics.WIN_4_MATCH.getMessage(), winningCount[Lotto.RANK_4]);
        printfMessage(WinningStatistics.WIN_5_MATCH.getMessage(), winningCount[Lotto.RANK_3]);
        printfMessage(WinningStatistics.WIN_5_BONUS_MATCH.getMessage(), winningCount[Lotto.RANK_2]);
        printfMessage(WinningStatistics.WIN_6_MATCH.getMessage(), winningCount[Lotto.RANK_1]);
        printfMessage(WinningStatistics.TOTAL_AMOUNT.getMessage(), rateOfReturn);
    }

    public static void printfMessage(String printMessage, Object... args){
        System.out.printf(printMessage + "%n", args);
    }
}