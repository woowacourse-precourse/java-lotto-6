package lotto.View;

import lotto.Domain.Result;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String GET_AVAILABLE_MONEY_MSG
            = "구입금액을 입력해주세요.";
    private static final String GET_PURCHASED_AMOUNT_MSG
            = "개를 구매했습니다.";
    private static final String GET_WINNER_LOTTO_MSG
            = "당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_NUMBER_MSG
            = "보너스 번호를 입력해 주세요.";
    private static final String GET_RESULTS_MSG
            = "당첨 통계\n---";
    private static final String LOTTO_SINGLE_RESULT_MSG
            = "%d개 일치 (%s원) - %d개";
    private static final String LOTTO_SINGLE_BONUS_RESULT_MSG
            = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String PROFIT_RATE_MSG
            = "총 수익률은 %.1f%%입니다.";
    private static final String NEW_LINE
            = "\n";

    public static void printAvailableMoneyMsg() {
        System.out.println(GET_AVAILABLE_MONEY_MSG);
    }

    public static void printPurchasedAmountMsg(int purchasedAmount) {
        System.out.println(NEW_LINE + purchasedAmount + GET_PURCHASED_AMOUNT_MSG);
    }

    public static void printNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void printWinnerLottoMsg() {
        System.out.println(NEW_LINE + GET_WINNER_LOTTO_MSG);
    }

    public static void printBonusNumberMsg() {
        System.out.println(NEW_LINE + GET_BONUS_NUMBER_MSG);
    }

    public static void printResultsMsg() {
        System.out.println(NEW_LINE + GET_RESULTS_MSG);
    }

    public static void printAllResultsMsg(Map<String, Integer> results) {
        for (Result result : Result.values()) {
            if (result.getIsBonusHit()) {
                System.out.printf(NEW_LINE + LOTTO_SINGLE_BONUS_RESULT_MSG,
                        result.getHitCount(), result.getReward(), results.get(result.name()));
                continue;
            }

            System.out.printf(NEW_LINE + LOTTO_SINGLE_RESULT_MSG,
                    result.getHitCount(), result.getReward(), results.get(result.name()));
        }
    }

    public static void printProfitRateMsg(double totalProfitRate) {
        System.out.printf(NEW_LINE + PROFIT_RATE_MSG, totalProfitRate);
    }

}
