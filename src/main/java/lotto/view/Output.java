package lotto.view;

import java.util.List;
import lotto.constants.MessageConstants;
import lotto.domain.Cost;
import lotto.domain.Lottos;
import lotto.domain.Result;

public class Output {
    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printProfit(Result result, Cost cost) {
        float profitPercent = result.calculateProfitPercent(cost);
        System.out.printf(MessageConstants.PROFIT_MESSAGE.getMessage(), profitPercent);
    }

    public static void printLottos(Lottos lottos) {
        List<String> lottosPrintFormat = lottos.getLottosPrintFormat();
        lottosPrintFormat.forEach(System.out::println);
    }

    public static void printMatchResult(Result result) {
        result.fetchMatchResult().forEach(System.out::println);
    }

    public static void askCostEnter() {
        System.out.println(MessageConstants.ASK_COST_ENTER.getMessage());
    }

    public static void lottoPurchase(int costCount) {
        System.out.println("\n" + costCount + MessageConstants.LOTTO_PURCHASE.getMessage());
    }

    public static void askWinningNumberEnter() {
        System.out.println(MessageConstants.ASK_WINNING_NUMBER_ENTER.getMessage());
    }

    public static void askBonusNumberEnter() {
        System.out.println(MessageConstants.ASK_BONUS_NUMBER_ENTER.getMessage());
    }

    public static void resultOverView() {
        System.out.print(MessageConstants.RESULT_OVERVIEW.getMessage());
    }
}
