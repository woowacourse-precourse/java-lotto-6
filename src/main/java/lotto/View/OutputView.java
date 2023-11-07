package lotto.View;

import lotto.Lotto;
import lotto.WinningStatistics;

import java.util.List;

public class OutputView {

    public static void printWinningStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        WinningStatistics statistics = new WinningStatistics(lottos, winningNumbers, bonusNumber);
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(statistics);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", statistics.calculateTotalWinningRate());
    }
}
