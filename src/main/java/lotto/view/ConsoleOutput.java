package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningResult;

public class ConsoleOutput {
    public void displayPurchasedLottos(List<Lotto> lottos) {
        int numberOfLottos = lottos.size();
        System.out.println(numberOfLottos + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void displayWinningStatistics(List<WinningResult> winningStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---");

        final int[] prizes = {
                0, 0, 5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000
        };

        for (int i = 3; i <= 6; i++) {
            final int rank = i;

            long count = winningStatistics.stream()
                    .filter(result -> result.getRank() == rank)
                    .count();

            int prize = prizes[i];

            if (i == 5) {
                System.out.println("5개 일치 (" + formatPrize(prize) + ") - " + count + "개");
                System.out.println("5개 일치, 보너스 볼 일치 (" + formatPrize(prize) + ") - " + count + "개");
            } else {
                System.out.println(i + "개 일치 (" + formatPrize(prize) + ") - " + count + "개");
            }
        }
    }

    public void displayTotalProfitRate(double totalProfitRate) {
        System.out.print("\n");
        System.out.printf("총 수익률은 %.1f%%입니다.\n", totalProfitRate);
    }

    private String formatPrize(int prize) {
        DecimalFormat formatter = new DecimalFormat("#,###원");
        return formatter.format(prize);
    }
}
