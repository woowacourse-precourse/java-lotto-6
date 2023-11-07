package view;

import java.util.List;
import lotto.Lotto;
import message.InputMessage;
import message.OutputMessage;
import message.Symbol;

public class OutputView {

    public static void printPurchaseAmountInputMessage() {
        System.out.println(InputMessage.PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printPurchasedLotteryNumbers(List<Lotto> lotteries) {
        StringBuilder message = new StringBuilder();
        message.append(lotteries.size()).append(OutputMessage.PURCHASE_FINISHED_MESSAGE.getMessage())
                .append(Symbol.NEXT_LINE.getSymbol());
        for (Lotto lottery : lotteries) {
            message.append(lottery.toString()).append(Symbol.NEXT_LINE.getSymbol());
        }
        System.out.println(message);
    }

    public static void printWinningNumbersInputMessage() {
        System.out.println(InputMessage.WINNING_NUMBERS_MESSAGE.getMessage());
    }

    public static void printBonusNumberInputMessage() {
        System.out.println(InputMessage.BONUS_NUMBER_MESSAGE.getMessage());
    }
}
