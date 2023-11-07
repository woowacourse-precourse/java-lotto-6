package lotto.global.util;

import static lotto.global.enums.ErrorType.ERROR_PREFIX;
import static lotto.global.enums.GuideMessage.INPUT_BONUS_NUMBER_COMMAND;
import static lotto.global.enums.GuideMessage.INPUT_PAYMENT_COMMAND;
import static lotto.global.enums.GuideMessage.INPUT_WINNING_NUMBER_COMMAND;
import static lotto.global.enums.GuideMessage.LOTTO_WINNING_RESULT;
import static lotto.global.enums.GuideMessage.OUTPUT_RATE_OF_PROFIT;
import static lotto.global.enums.GuideMessage.PAYMENT_STATUS;
import static lotto.global.enums.GuideMessage.STATICS_OF_WINNING;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;

public final class OutputManager {

    public static void printHistory(int totalCnt, List<Lotto> lottos) {
        System.out.println(String.format(PAYMENT_STATUS, totalCnt));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinResult(Map<Integer, Long> winningAmount) {
        System.out.println(STATICS_OF_WINNING);
        System.out.println("---");
        System.out.printf(LOTTO_WINNING_RESULT
                , winningAmount.get(5_000)
                , winningAmount.get(50_000)
                , winningAmount.get(1_500_000)
                , winningAmount.get(30_000_000)
                , winningAmount.get(2_000_000_000)
        );
    }

    public static void printRateOfProfit(double result) {
        System.out.println(String.format(OUTPUT_RATE_OF_PROFIT, result));
    }

    public static void printError(Exception e) {
        System.out.println(ERROR_PREFIX.getMessage() + " " + e.getMessage());
    }

    public static void inputPaymentCommand() {
        System.out.println(INPUT_PAYMENT_COMMAND);
    }

    public static void inputWinningNumberCommand() {
        System.out.println(INPUT_WINNING_NUMBER_COMMAND);
    }

    public static void inputBonusNumberCommand() {
        System.out.println(INPUT_BONUS_NUMBER_COMMAND);
    }
}
