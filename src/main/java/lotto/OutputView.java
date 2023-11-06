package lotto;

import java.util.List;

public class OutputView {
    public void printUserLottos(List<String> lottoMessages, long buyAmount) {
        System.out.println();
        System.out.println(buyAmount + "개를 구매했습니다.");
        lottoMessages.forEach(this::printLotto);
        System.out.println();
    }

    private void printLotto(String lottoMessage) {
        System.out.println(lottoMessage);
    }

    public void printWinningResult(List<String> ranksStatistics, double totalProfitRate) {
        System.out.println("---");
        System.out.println("당첨 통계");
        System.out.println("---");
        ranksStatistics.forEach(System.out::println);

        System.out.println(String.format("총 수익률은 %.1f%%입니다.", totalProfitRate));

    }
}
