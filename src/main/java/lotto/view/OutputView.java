package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRankInfo;
import lotto.domain.LottoTickets;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class OutputView {

    public void printPurchasedLottoTickets(LottoTickets lottoTickets) {
        System.out.println("\n" + lottoTickets.getLottoTickets().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningResult(Map<LottoRankInfo, Integer> winningResult, List<LottoRankInfo> rankInfos) {
        System.out.println("당첨 통계\n---");
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
}
