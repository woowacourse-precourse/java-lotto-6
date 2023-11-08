package lotto.view;

import java.util.List;
import lotto.Lotto;

public class OutputView {
    public void printBuyLotto(int lottoAmount) {
        System.out.println("\n" + lottoAmount + "개를 구매했습니다.");
    }

    public void printTotalLotto(List<Lotto> lottos) {
        lottos.forEach(Lotto::printLotto);
    }

    public void printWinningStatistics() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    public void printResult(int matchCounts, long winningMoney, int count) {
        System.out.printf("%d개 일치" + " (%,d원) " + "- %d개\n", matchCounts, winningMoney, count);
    }
    public void printSecondResult(int matchCounts, long winningMoney, int count) {
        System.out.printf("%d개 일치, 보너스 볼 일치" + " (%,d원) " + "- %d개\n", matchCounts, winningMoney, count);
    }
    public void printEarningRate(double earningRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", earningRate);
    }
}
