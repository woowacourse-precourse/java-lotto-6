package lotto.view;

import lotto.domain.*;

import static lotto.message.InfoMessage.*;

public class Printer {
    public static void print(int intValue) {
        System.out.print(intValue);
    }

    public static void printLineBreak() {
        System.out.println();
    }

    public static void printPurchaseAmountChoiceMessage() {
        System.out.println(PURCHASE_AMOUNT_CHOICE);
    }

    public static void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public static void printLottoCount(LottoCount lottoCount) {
        System.out.println(lottoCount.getLottoCount() + PURCHASE_COMPLETE);
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void printWinningNumberChoiceMessage() {
        System.out.println(WINNING_NUMBER_CHOICE);
    }

    public static void printBonusNumberChoiceMessage() {
        System.out.println(BONUS_NUMBER_CHOICE);
    }

    public static void printResultHead() {
        System.out.println(RESULT_HEAD);
    }

    public static void printDividingLine() {
        System.out.println(DIVIDING_LINE);
    }

    public static void printLowWinningResult(int matchedNumber, Winning winning, WinningCount winningCount) {
        System.out.printf("%d%s (%s) - %d개\n", matchedNumber, WINNING_RESULT_HEAD,
                winning.getWinningRewardDescription(), winningCount.getCount(matchedNumber));
    }

    public static void printHighWinningResult(int matchedNumber, Winning winning, WinningCount winningCount) {
        if (matchedNumber == 7) {
            matchedNumber -= 2;
        }

        System.out.print(matchedNumber + WINNING_RESULT_HEAD);

        if (matchedNumber == 5) {
            System.out.print(BONUS_RESULT);
        }

        System.out.printf(" (%s) - %d개\n", winning.getWinningRewardDescription(), winningCount.getCount(matchedNumber));
    }

    public static void printReturnRate(ReturnRate returnRate) {
        System.out.println(RETURN_RATE_INFORMATION_HEAD + returnRate.getReturnRate() + RETURN_RATE_INFORMATION_FOOT);
    }
}
