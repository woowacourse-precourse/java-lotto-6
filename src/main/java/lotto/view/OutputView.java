package lotto.view;

import static lotto.domain.Result.FIVE_AND_BONUS_MATCH;
import static lotto.domain.Result.FIVE_MATCH;
import static lotto.domain.Result.FOUR_MATCH;
import static lotto.domain.Result.SIX_MATCH;
import static lotto.domain.Result.THREE_MATCH;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import lotto.domain.Result;
import lotto.utils.ErrorMessage;
import lotto.utils.Message;

public class OutputView {
    private OutputView() {
    }

    public static void printBuyInputPrice() {
        System.out.println(Message.PRINT_USER_INPUT_BUY_PRICE.getMessage());
    }

    public static void printBuyLottoCount(int count) {
        System.out.println();
        System.out.println(count + Message.PRINT_USER_BUY_LOTTO_COUNT.getMessage());
    }

    public static void printLotties(List<List<Integer>> lottos){
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printEnterWinningNumber(){
        System.out.println();
        System.out.println(Message.PRINT_USER_ENTER_WINNING_NUMBER.getMessage());
    }

    public static void printEnterBonusNumber(){
        System.out.println();
        System.out.println(Message.PRINT_USER_ENTER_BONUS_NUMBER.getMessage());
    }

    private static void printWinningStatistics() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private static void printLottoMatched(Map<Result, Integer> score, Result[] printOrder, NumberFormat numberFormat) {
        for (Result result : printOrder) {
            int count = score.getOrDefault(result, 0);
            String winningsFormatted = numberFormat.format(result.getWinnings()) + "원";
            String message = result.getMatchCnt() + "개 일치 (" + winningsFormatted + ")";
            if (result.getMatchCnt() == 5 && result.isBonus()) {
                message = result.getMatchCnt() + "개 일치, 보너스 볼 일치 (" + winningsFormatted + ")";
            }
            message += " - " + count + "개";
            System.out.println(message);
        }
    }

    public static void printScore(Map<Result, Integer> score) {
        printWinningStatistics();
        Result[] printOrder = new Result[] { THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_AND_BONUS_MATCH, SIX_MATCH };
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        printLottoMatched(score, printOrder, numberFormat);
    }


    public static void printProfit(int profit, int totalInvestment) {
        double profitPercentage = (profit) / (double) totalInvestment * 100;
        DecimalFormat profitDecimal = new DecimalFormat("#0.0%");
        String formattedProfitPercentage = profitDecimal.format(profitPercentage / 100.0);
        System.out.println("총 수익률은 "+formattedProfitPercentage+"입니다.");
    }

    public static void errorCatch(IllegalArgumentException e) {
        System.out.println();
        System.out.println(e.getMessage());
    }
}
