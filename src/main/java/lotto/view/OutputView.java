package lotto.view;

import lotto.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public static void outputLottoTickets(LottoPurchaseManager lottoPurchaseManager) {
        List<Lotto> lottoTickets = lottoPurchaseManager.getLottoTickets();

        System.out.println(lottoPurchaseManager.calculateLottoTicketCount() + "개를 구매했습니다.");

        for (Lotto ticket : lottoTickets) {

            List<Integer> numberValues = ticket.getNumbers().stream()
                    .map(LottoNumber::getWinningNumber)
                    .sorted()
                    .collect(Collectors.toList());

            System.out.println(numberValues);
        }
    }

    public static void outputResult(LottoPurchaseManager lottoPurchaseManager,
                                    WinningLotto winningLotto) {
        List<Lotto> lottoTickets = lottoPurchaseManager.getLottoTickets();

        Map<LottoResult, Integer> winningStatisticsCount = new HashMap<>();

        for (Lotto ticket : lottoTickets) {

            LottoResult lottoResult = winningLotto.compareWithWinningNumbers(ticket.getNumbers());
            winningStatisticsCount.put(lottoResult, winningStatisticsCount.getOrDefault(lottoResult, 0) + 1);
        }

        printWinningStatistics(winningStatisticsCount);
        printReturnRate(lottoPurchaseManager);
    }

    private static void printWinningStatistics(Map<LottoResult, Integer> winningStatisticsCount) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (LottoResult lottoResult : LottoResult.values()) {
            String matchBonus = getMatchBonusString(lottoResult);
            System.out.println(lottoResult.getMatchCount() + "개 일치" + matchBonus + " (" + lottoResult.getPrizeMoney() + ") - " + winningStatisticsCount + "개");
        }
    }

    private static void printReturnRate(LottoPurchaseManager lottoPurchaseManager) {
        double returnRate = lottoPurchaseManager.calculateProfitRate();
        System.out.println("총 수익률은 " + String.format("%.1f", returnRate) + "%입니다.");
    }

    private static String getMatchBonusString(LottoResult lottoResult) {
        if (lottoResult.isMatchBonus()) {
            return ", 보너스 볼 일치";
        }

        return "";
    }
}
