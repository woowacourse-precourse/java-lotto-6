package lotto;

import java.util.List;
import lotto.Input.InputType;
import lotto.Messages.MainMessage;
import lotto.Messages.WinningStatistics;

public class Print {
    private static final int RANK_5 = 3;
    private static final int RANK_4 = 4;
    private static final int RANK_3 = 5;
    private static final int RANK_2 = 7;
    private static final int RANK_1 = 6;

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
        System.out.printf((WinningStatistics.WIN_3_MATCH.getMessage()) + "%n", winningCount[RANK_5]);
        System.out.printf((WinningStatistics.WIN_4_MATCH.getMessage()) + "%n", winningCount[RANK_4]);
        System.out.printf((WinningStatistics.WIN_5_MATCH.getMessage()) + "%n", winningCount[RANK_3]);
        System.out.printf((WinningStatistics.WIN_5_BONUS_MATCH.getMessage()) + "%n", winningCount[RANK_2]);
        System.out.printf((WinningStatistics.WIN_6_MATCH.getMessage()) + "%n", winningCount[RANK_1]);
        System.out.printf((WinningStatistics.TOTAL_AMOUNT.getMessage()) + "%n", rateOfReturn);
    }
}