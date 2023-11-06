package lotto.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoPrizeBreakdown;
import lotto.domain.LottoRank;
import lotto.util.LottoGuideMessage;

public class OutputView {

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showMessage(LottoGuideMessage lottoGuideMessage) {
        System.out.println(lottoGuideMessage.getMessage());
    }

    public void showSeperateLine() {
        System.out.println();
    }

    public void showIssueLottoTickets(List<Lotto> lottoTickets) {
        String purchaseCountMessage =
                String.format(LottoGuideMessage.PURCHASE_COUNT_INFO.getMessage(), lottoTickets.size());
        System.out.println(purchaseCountMessage);
        lottoTickets.forEach(System.out::println);
        System.out.println();
    }

    public void showWinningStatistics(LottoPrizeBreakdown result, BigDecimal rateOfReturn) {
        Map<LottoRank, Integer> report = result.getReport();

        System.out.println(LottoGuideMessage.WINNING_STATISTICS.getMessage());
        System.out.println("---");
        for (LottoRank rank : LottoRank.values()) {
            int winCount = report.getOrDefault(rank, 0);
            System.out.println(rank.getMessage(winCount));
        }
        System.out.printf("총 수익률은 %s%%입니다.", rateOfReturn);
        System.out.println();
    }
}
