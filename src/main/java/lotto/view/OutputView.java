package lotto.view;

public class OutputView {
    private static final String STATS_MESSAGE = "당첨 통계";

    public static void printLottoCount(int quantity) {
        System.out.println("\n" + quantity + "개를 구매했습니다.");
    }

    public static void printStatsMessage() {
        System.out.print(STATS_MESSAGE + "\n---\n");
    }

    public static void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
