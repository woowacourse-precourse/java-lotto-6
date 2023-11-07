package View;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.Rank;
import lotto.WinningResult;

public class OutputView {
    public void printPlayerLottoNumbers(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            Collections.sort(numbers);
            System.out.println(numbers);
        });
    }

    public void printWinningResult(WinningResult winningResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        print(winningResult.winningStatistics());
        print(winningResult.winningRate());
    }

    private void print(Map<Rank, Integer> winningResult) {
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NOTHING) {
                continue;
            }
            Integer count = winningResult.get(rank);
            String result = String.format(rank.getPrintFormat(), count);
            System.out.println(result);
        }
    }

    private void print(Double winningRate) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", winningRate));
    }
}
