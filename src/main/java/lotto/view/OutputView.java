package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRankInfo;
import lotto.domain.LottoReturnRate;
import lotto.domain.LottoTickets;

import java.text.NumberFormat;
import java.util.*;

public class OutputView {

    public void printPurchasedLottoTickets(LottoTickets lottoTickets) {
        System.out.println("\n" + lottoTickets.getLottoTickets().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedNumbers);
            System.out.println(sortedNumbers);
        }
    }

    public void printWinningResult(Map<LottoRankInfo, Integer> winningResult, List<LottoRankInfo> rankInfos) {
        System.out.println("\n당첨 통계\n---");
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);

        for (LottoRankInfo rankInfo : rankInfos) {
            System.out.print(rankInfo.getMatchingCount() + "개 일치");
            if (rankInfo.equals(LottoRankInfo.SECOND)) {
                System.out.print(", 보너스 볼 일치");
            }

            String formattedPrizeMoney = numberFormat.format(rankInfo.getPrizeMoney());
            System.out.print(" (" + formattedPrizeMoney + "원) - ");
            System.out.println(winningResult.get(rankInfo) + "개");
        }
    }

    public void printReturnRate(LottoReturnRate lottoReturnRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", lottoReturnRate.getReturnRate()) + "%입니다.");
    }
}
