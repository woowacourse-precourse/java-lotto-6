package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningResult;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ResultView {
    // 결과 출력
    public static void showResult(List<Lotto> lottoTickets, WinningResult winningResult) {
        showPurchasedLottoTickets(lottoTickets);
        showWinningResult(winningResult);
        double earningRate = calculateEarningRate(winningResult.getTotalPrize(), lottoTickets.size());
        showEarningRate(earningRate);
    }

    // 구매한 로또 티켓 목록 출력
    public static void showPurchasedLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    // 당첨 결과 출력
    public static void showWinningResult(WinningResult winningResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        List<Rank> sortedRanks = new ArrayList<>(List.of(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST));
        for (Rank rank : sortedRanks) {
            showEachWinningResult(winningResult, rank);
        }
    }

    // 각 등수별 당첨 결과 출력
    private static void showEachWinningResult(WinningResult winningResult, Rank rank) {
        int matchCount = rank.getMatchCount();
        int prize = rank.getPrize();
        int count = winningResult.getCount(rank);

        String resultMessage = matchCount + "개 일치";
        if (rank == Rank.SECOND) {
            resultMessage += ", 보너스 볼 일치";
        }
        resultMessage += " (" + String.format("%,d원", prize) + ") - " + count + "개";

        System.out.println(resultMessage);
    }

    // 수익률 계산
    private static double calculateEarningRate(int totalPrize, int ticketCount) {
        if (ticketCount == 0) {
            return 0.0;
        }
        return ((double) totalPrize / (ticketCount * 1000));
    }

    // 수익률 출력
    public static void showEarningRate(double earningRate) {
        DecimalFormat df = new DecimalFormat("0.0%");
        System.out.println("총 수익률은 " + df.format(earningRate) + "입니다.");
    }
}
