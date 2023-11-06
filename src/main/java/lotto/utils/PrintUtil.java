package lotto.utils;

import lotto.Lotto;

import java.util.List;

public class PrintUtil {
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_SUCCESS_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_RESULT_MESSAGE = "당첨 통계";
    private static final String LINE = "---";
    private static final String FIFTH_PRIZE_MESSAGE = "3개 일치 (5,000원) - %d개\n";
    private static final String FOURTH_PRIZE_MESSAGE = "4개 일치 (50,00원) - %d개\n";
    private static final String THIRD_PRIZE_MESSAGE = "5개 일치 (1,500,000원) - %d개\n";
    private static final String SECOND_PRIZE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String FIRST_PRIZE_MESSAGE = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String TOTAL_RETURN_RATE = "총 수익률은 %.1f%%입니다.\n";

    public static void printInputPurchaseMessage() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printPurchaseSuccessMessage(int purchaseAmount) {
        System.out.printf(PURCHASE_SUCCESS_MESSAGE, purchaseAmount);
    }

    public static void printInputWinningNumberMessage() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
    }

    public static void printInputBonusNumberMessage() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public static void printWinningResultMessage(List<Integer> winningResult) {
        System.out.println(WINNING_RESULT_MESSAGE);
        System.out.println(LINE);
        printFifthPrizeMessage(winningResult.get(5));
        printFourthPrizeMessage(winningResult.get(4));
        printThirdPrizeMessage(winningResult.get(3));
        printSecondPrizeMessage(winningResult.get(2));
        printFirstPrizeMessage(winningResult.get(1));
    }

    public static void printFifthPrizeMessage(int count) {
        System.out.printf(FIFTH_PRIZE_MESSAGE, count);
    }

    public static void printFourthPrizeMessage(int count) {
        System.out.printf(FOURTH_PRIZE_MESSAGE, count);
    }

    public static void printThirdPrizeMessage(int count) {
        System.out.printf(THIRD_PRIZE_MESSAGE, count);
    }

    public static void printSecondPrizeMessage(int count) {
        System.out.printf(SECOND_PRIZE_MESSAGE, count);
    }

    public static void printFirstPrizeMessage(int count) {
        System.out.printf(FIRST_PRIZE_MESSAGE, count);
    }

    public static void printReturnRateMessage(double returnRate) {
        System.out.printf(TOTAL_RETURN_RATE, returnRate);
    }

    public static void printAllLottos(List<Lotto> lottos) {
        lottos.forEach(Lotto::print);
        System.out.println();
    }
}
