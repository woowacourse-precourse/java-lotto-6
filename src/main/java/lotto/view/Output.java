package lotto.view;

public class Output {

    private static final String LOTTOS_COUNT = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTIC = "당첨 통계\n---";
    private static final String RETURN_PERCENT = "총 수익률은 %.1f%%입니다.";

    public static void printLottosCount(int money) {
        System.out.printf(LOTTOS_COUNT, money);
    }

    public static void printLottos(String lotto) {
        System.out.println(lotto);
    }

    public static void printWinningStatistic() {
        System.out.println(WINNING_STATISTIC);
    }

    public static void printResults(String message, int count) {
        System.out.printf(message, count);
    }

    public static void printPercent(double percent) {
        System.out.printf(RETURN_PERCENT, percent);
    }
}
