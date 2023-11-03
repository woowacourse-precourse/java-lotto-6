package lotto.view;

public class OutputView {

    private static final String purchaseNumberFormat = "%d개를 구매했습니다.";
    private static final String winningStatistics = "당첨 통계";
    private static final String line = "---";
    private static final String winningStatisticsFormat = "%d개 일치 ";
    private static final String winningStatisticsBonusFormat = "보너스 볼 일치 ";
    private static final String winningStatisticsCountFormat = "(%d원)- %d개";
    private static final String profitRateFormat = "총 수익률은 %.2f입니다.";

    public static void printPurchaseNumber(int purchaseNumber) {
        System.out.printf(purchaseNumberFormat, purchaseNumber);
    }

    public static void printWinningStatistics() {
        System.out.println(winningStatistics);
        System.out.println(line);
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf(profitRateFormat, profitRate);
    }

}
