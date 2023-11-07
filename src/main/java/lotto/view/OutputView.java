package lotto.view;

public class OutputView {
    public static void printTicketCount(int count) {

        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public static void printWinningStatistics() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printWinningCount(String message, int number) {
        System.out.println(message + number + "개");
    }

    public static void printRateOfReturn(double RateOfReturn) {
        System.out.println("총 수익률은 " + String.format("%.1f", RateOfReturn) + "%입니다.");
    }
}
