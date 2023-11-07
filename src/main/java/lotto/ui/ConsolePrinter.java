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
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class ConsolePrinter {

    public static void printPurchaseAmountMessage() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE.getValue());
    }

    public static void printLottoNumbers(Lotto lotto) {
        List<String> numbers = lotto.getNumbers().stream()
                .map(Objects::toString)
                .collect(Collectors.toList());

        System.out.println("[" + String.join(", ", numbers) + "]");
    }

    public static void printLottoPurchasedMessage(int count) {
        System.out.printf(LOTTO_PURCHASED_MESSAGE.getValue(), count);
    }

    public static void printWinningNumberMessage() {
        System.out.println(WINNING_NUMBER_MESSAGE.getValue());
    }

    public static void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE.getValue());
    }

    public static void printWinningStatsMessage() {
        System.out.println(WINNING_STATS_MESSAGE.getValue());
    }

    public static void printWinningAward(int rank, String award, int count) {
        System.out.printf(WINNING_AWARD.getValue(), rank, award, count);
    }

    public static void printBonusAward(int rank, String award, int count) {
        System.out.printf(WINNING_BONUS_AWARD.getValue(), rank, award, count);
    }

    public static void printTotalProfit(float profit) {
        System.out.printf(TOTAL_PROFIT.getValue(), profit);
    }

}
