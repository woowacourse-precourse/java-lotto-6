package lotto.view;

public class OutputView {
    private static final String LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATS_MESSAGE = "당첨 통계";

    public static void printLottoAmount(int count) {
        System.out.println();
        System.out.println(count + LOTTO_AMOUNT_MESSAGE);
    }

    public static void printResult() {
        System.out.println();
        System.out.println(WINNING_STATS_MESSAGE);
        System.out.println("---");
    }

    public static void printWinning(String message, int numberOfMatch) {
        System.out.println(message + numberOfMatch + "개");
    }

    public static void printRevenueRate(double EarningRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", EarningRate) + "%입니다.");
    }

}
