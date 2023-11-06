package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningResult;

import java.util.List;

public class OutputView {
    public void showResult(List<Lotto> lottoTickets, WinningResult winningResult) {
        showWinningResult(winningResult);
        showPurchasedLottoTickets(lottoTickets);
        double earningRate = calculateEarningRate(winningResult.getTotalPrize(), lottoTickets.size());
        showEarningRate(earningRate);
    }

    public void showPurchasedLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void showWinningResult(WinningResult winningResult) {
        System.out.println("당첨 결과");
        System.out.println("---");

        Rank[] ranks = Rank.values();
        for (int i = 3; i <= 6; i++) {
            for (Rank rank : ranks) {
                if (rank.getMatchCount() == i) {
                    int matchCount = rank.getMatchCount();
                    int prize = rank.getPrize();
                    int count = winningResult.getCount(rank);

                    if (matchCount != 0) {
                        System.out.print(matchCount + "개 일치");
                    }

                    if (matchCount == 3) {
                        System.out.print(" (보너스 볼 일치)");
                    }

                    System.out.println(" (" + String.format("%,d", prize) + "원) - " + count + "개");
                }
            }
        }
    }

    private double calculateEarningRate(int totalPrize, int ticketCount) {
        if (ticketCount == 0) {
            return 0.0;
        }
        return (double) totalPrize / (ticketCount * 1000);
    }

    public void showEarningRate(double earningRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", earningRate) + "%입니다.");
    }
}
