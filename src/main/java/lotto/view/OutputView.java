package lotto.view;

public class OutputView {
    private static final String BUY_LOTTO_COUNT = "개를 구매했습니다.";

    public static void printBuyLottoCount(int count) {
        System.out.println(count + BUY_LOTTO_COUNT);
    }

    public static void printWinningResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printWinningMessage(String message, int numberWinning) {
        System.out.println(message + numberWinning + "개");
    }

    public static void printRevenueRate(double rate) {
        System.out.println("총 수익률은 " + String.format("%.1f", rate) + "%입니다.");
    }
}
