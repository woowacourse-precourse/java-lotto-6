package lotto.view;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printIssuedLottoDetails(int lottoQuantity, List<String> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottoQuantity);
        lottos.forEach(System.out::println);
    }

    public static void printWinningDetails(List<String> rankDetails, List<Integer> winningCounts) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 0; i < rankDetails.size(); i++) {
            System.out.printf("%s - %d개%n", rankDetails.get(i), winningCounts.get(i));
        }
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
