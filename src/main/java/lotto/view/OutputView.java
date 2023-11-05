package lotto.view;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printIssuedLottoDetails(List<String> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        lottos.forEach(System.out::println);
    }

    public static void printWinningDetails(String winningDetails) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(winningDetails);
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }

    public static void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }
}
