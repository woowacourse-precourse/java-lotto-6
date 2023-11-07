package lotto.ui;

import static lotto.constant.ConsoleMessages.BONUS_NUMBER_MESSAGE;
import static lotto.constant.ConsoleMessages.LOTTO_PURCHASED_MESSAGE;
import static lotto.constant.ConsoleMessages.PURCHASE_AMOUNT_MESSAGE;
import static lotto.constant.ConsoleMessages.TOTAL_PROFIT;
import static lotto.constant.ConsoleMessages.WINNING_AWARD;
import static lotto.constant.ConsoleMessages.WINNING_BONUS_AWARD;
import static lotto.constant.ConsoleMessages.WINNING_NUMBER_MESSAGE;
import static lotto.constant.ConsoleMessages.WINNING_STATS_MESSAGE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.util.StringUtil;

public class ConsolePrinter {

    public static void printPurchaseAmountMessage() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printLottoNumbers(Lotto lotto) {
        List<String> numbers = StringUtil.toStringList(lotto.getNumbers());

        System.out.println("[" + String.join(", ", numbers) + "]");
    }

    public static void printLottoPurchasedMessage(int count) {
        System.out.printf(LOTTO_PURCHASED_MESSAGE.toString(), count);
    }

    public static void printWinningNumberMessage() {
        System.out.println(WINNING_NUMBER_MESSAGE);
    }

    public static void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public static void printWinningStatsMessage() {
        System.out.println(WINNING_STATS_MESSAGE);
    }

    public static void printWinningAward(int rank, int award, int count) {
        System.out.printf(WINNING_AWARD.toString(), rank, StringUtil.toStringWithCommas(award), count);
    }

    public static void printBonusAward(int rank, int award, int count) {
        System.out.printf(WINNING_BONUS_AWARD.toString(), rank, StringUtil.toStringWithCommas(award), count);
    }

    public static void printTotalProfit(float profit) {
        System.out.printf(TOTAL_PROFIT.toString(), profit);
    }

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

}
