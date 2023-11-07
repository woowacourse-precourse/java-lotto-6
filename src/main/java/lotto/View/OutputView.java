package lotto.View;

import lotto.Domain.Lotto;
import lotto.Domain.WinningStatistics;

import java.util.List;

public class OutputView {

    public static void printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void printWinningStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        WinningStatistics statistics = new WinningStatistics(lottos, winningNumbers, bonusNumber);
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(statistics);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", statistics.calculateTotalWinningRate());
    }
}
