package lotto.ui;

import static lotto.constant.ConsoleMessages.BONUS_NUMBER_MESSAGE;
import static lotto.constant.ConsoleMessages.LOTTO_PURCHASED_MESSAGE;
import static lotto.constant.ConsoleMessages.PURCHASE_AMOUNT_MESSAGE;
import static lotto.constant.ConsoleMessages.RETURN_RATE;
import static lotto.constant.ConsoleMessages.WINNING_BONUS_REWARD;
import static lotto.constant.ConsoleMessages.WINNING_NUMBER_MESSAGE;
import static lotto.constant.ConsoleMessages.WINNING_REWARD;
import static lotto.constant.ConsoleMessages.WINNING_STATS_MESSAGE;

import java.util.List;
import lotto.constant.Rewards;
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

    public static void printWinningReward(Rewards reward, int count) {
        if (reward == Rewards.LOSE) {
            return;
        }

        if (reward == Rewards.SECOND) {
            System.out.printf(WINNING_BONUS_REWARD.toString(), reward.getCount(),
                    StringUtil.toStringWithCommas(reward.getValue()), count);
            return;
        }

        System.out.printf(WINNING_REWARD.toString(), reward.getCount(),
                StringUtil.toStringWithCommas(reward.getValue()), count);
    }

    public static void printTotalReturnRate(float returnRate) {
        System.out.printf(RETURN_RATE.toString(), returnRate);
    }

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
        printEmptyLine();
    }

    public static void printEmptyLine() {
        System.out.println();
    }

}
