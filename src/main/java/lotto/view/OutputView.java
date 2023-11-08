package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.TotalLotto;
import lotto.utils.WinningRank;

import java.util.Collections;

public class OutputView {
    public static void purchaseComplete(int count) {
        System.out.printf("\n%d개를 구매했습니다.\n", count);
    }

    public static void lottoNumbers(TotalLotto totalLotto) {
        for (Lotto lotto : totalLotto.getTotalLotto()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void winningStatistics() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    public static void showRankResult() {
        for (WinningRank winningRank : WinningRank.values()) {
            showSingleRankResult(winningRank);
        }
    }

    public static void showSingleRankResult(WinningRank winningRank) {
        if (winningRank.equals(WinningRank.SECOND)) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                    winningRank.getMatch(), winningRank.getPrice(), winningRank.getCount());
        } else System.out.printf("%d개 일치 (%s원) - %d개\n",
                winningRank.getMatch(), winningRank.getPrice(), winningRank.getCount());
    }

    public static void showEarningRate(float earningRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", earningRate);
    }
}
