package lotto.view;

import static lotto.utils.ConstantString.NEW_LINE;
import static lotto.utils.ConstantString.SPACE;
import static lotto.utils.ConstantValues.DEFAULT_COUNT;
import static lotto.utils.PrintingMessages.BONUS_MESSAGE;
import static lotto.utils.PrintingMessages.BUYING_MESSAGE;
import static lotto.utils.PrintingMessages.DECIMAL_FORMAT;
import static lotto.utils.PrintingMessages.PRIZE_MESSAGE;
import static lotto.utils.PrintingMessages.PRIZE_MESSAGE_START_MESSAGE;
import static lotto.utils.PrintingMessages.PROFIT_MESSAGE;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.StringJoiner;
import lotto.domain.Prize;

public class OutputView {
    public static void printLottos(int lottoCount, String lottosPrinting) {
        String message = String.format(BUYING_MESSAGE, lottoCount) + lottosPrinting;
        System.out.println(message);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printPrizeResults(Map<Prize, Integer> prizeResults) {
        StringJoiner prizeResultsMessage = new StringJoiner(NEW_LINE);
        prizeResultsMessage.add(PRIZE_MESSAGE_START_MESSAGE);
        for (Prize prize : Prize.values()) {
            if (prize == Prize.NO_PRIZE) {
                continue;
            }
            prizeResultsMessage.add(getPrizeResultMessage(
                    prize.getSameCount(),
                    prize.getPrizeProfit(),
                    prizeResults.getOrDefault(prize, DEFAULT_COUNT)));
        }
        System.out.println(prizeResultsMessage);
    }

    private static String getPrizeResultMessage(int sameCount, long prizeProfit, int prizeCount) {
        DecimalFormat prizeProfitFormatter = new DecimalFormat(DECIMAL_FORMAT);
        String formattedPrizeProfit = prizeProfitFormatter.format(prizeProfit);
        String bonusMessage = SPACE;
        if (prizeProfit == Prize.SECOND.getPrizeProfit()) {
            bonusMessage = BONUS_MESSAGE;
        }
        return String.format(PRIZE_MESSAGE, sameCount, bonusMessage, formattedPrizeProfit, prizeCount);
    }

    public static void printPrizeProfit(double profitRate) {
        System.out.printf(PROFIT_MESSAGE, profitRate);
    }
}
