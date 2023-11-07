package lotto.view;

import static lotto.domain.Result.FIVE_AND_BONUS_MATCH;
import static lotto.domain.Result.FIVE_MATCH;
import static lotto.domain.Result.FOUR_MATCH;
import static lotto.domain.Result.SIX_MATCH;
import static lotto.domain.Result.THREE_MATCH;

import java.lang.ref.PhantomReference;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import lotto.domain.Result;
import lotto.utils.Message;

public class OutputView {
    private OutputView() {
    }

    private static final String WON = "원";
    private static final String COUNT_MATCHED = "개 일치 (";
    private static final String CLOSE = ")";
    private static final String COUNT_AND_BONUS_MATCHED = "개 일치, 보너스 볼 일치 (";
    private static final String DASH = " - ";
    private static final String QUANTITY = "개";
    private static final String TOTAL_PROFIT_STRING = "총 수익률은 ";
    private static final String RESULT_END_STRING = "입니다.";
    private static final String DECIMAL_FORMAT_PATTERN = "#0.0%";
    private static final double DECIMAL_FORMAT_PERCENTAGE = 100.0;
    private static final int BONUS_MATCHED_SIZE = 5;
    private static final int DIVIDE_PROFIT_PERCENTAGE = 100;

    public static void printBuyInputPrice() {
        System.out.println(Message.PRINT_USER_INPUT_BUY_PRICE.getMessage());
    }

    public static void printBuyLottoCount(int count) {
        System.out.println();
        System.out.println(count + Message.PRINT_USER_BUY_LOTTO_COUNT.getMessage());
    }

    public static void printLotties(List<List<Integer>> lottos) {
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printEnterWinningNumber() {
        System.out.println();
        System.out.println(Message.PRINT_USER_ENTER_WINNING_NUMBER.getMessage());
    }

    public static void printEnterBonusNumber() {
        System.out.println();
        System.out.println(Message.PRINT_USER_ENTER_BONUS_NUMBER.getMessage());
    }

    private static void printWinningStatistics() {
        System.out.println();
        System.out.println(Message.PRINT_WINNING_STATISTICS.getMessage());
        System.out.println(Message.PRINT_DASH.getMessage());
    }

    private static void printLottoMatched(Map<Result, Integer> score, Result[] printOrder, NumberFormat numberFormat) {
        for (Result result : printOrder) {
            int count = score.getOrDefault(result, 0);
            String winningsFormatted = numberFormat.format(result.getWinnings()) + WON;
            String message = result.getMatchCnt() + COUNT_MATCHED + winningsFormatted + ")";
            if (result.getMatchCnt() == BONUS_MATCHED_SIZE && result.isBonus()) {
                message = result.getMatchCnt() + COUNT_AND_BONUS_MATCHED + winningsFormatted + CLOSE;
            }
            message += DASH + count + QUANTITY;
            System.out.println(message);
        }
    }

    public static void printScore(Map<Result, Integer> score) {
        printWinningStatistics();
        Result[] printOrder = new Result[]{THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_AND_BONUS_MATCH, SIX_MATCH};
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        printLottoMatched(score, printOrder, numberFormat);
    }


    public static void printProfit(int profit, int totalInvestment) {
        double profitPercentage = (profit) / (double) totalInvestment * DIVIDE_PROFIT_PERCENTAGE;
        DecimalFormat profitDecimal = new DecimalFormat(DECIMAL_FORMAT_PATTERN);
        String formattedProfitPercentage = profitDecimal.format(profitPercentage / DECIMAL_FORMAT_PERCENTAGE);
        System.out.println(TOTAL_PROFIT_STRING + formattedProfitPercentage + RESULT_END_STRING);
    }

    public static void errorCatch(IllegalArgumentException e) {
        System.out.println();
        System.out.println(e.getMessage());
    }
}
