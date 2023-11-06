package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningResult;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    public static void showPurchasedLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void showWinningResult(WinningResult winningResult) {
        System.out.println("당첨 결과");
        System.out.println("---");
        List<Rank> sortedRanks = new ArrayList<>(List.of(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST));
        for (Rank rank : sortedRanks) {
            showEachWinningResult(winningResult, rank);
        }
    }

    private static void showEachWinningResult(WinningResult winningResult, Rank rank) {
        int matchCount = rank.getMatchCount();
        int prize = rank.getPrize();

        if (rank != Rank.SECOND) {
            System.out.print(matchCount + "개 일치");
        }

        if (rank == Rank.FIFTH) {
            System.out.print(" (보너스 볼 일치)");
        }
        System.out.println(" (" + String.format("%,d", prize) + "원) - " + winningResult.getCount(rank) + "개");
    }

    public static void showEarningRate(double earningRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", earningRate) + "%입니다.");
    }
}