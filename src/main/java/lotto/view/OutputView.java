package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.MatchCount;

public class OutputView {

    private enum ConsoleMessage {
        TICKET_NUMBER("%d개를 구매했습니다.\n"),
        RESULT_HEADER("당첨 통계\n---\n"),
        MATCH_FORMAT("%s (%d원) - %d개\n"),
        EARNINGS_RATE_FORMAT("총 수익률은 %.2f%%입니다.\n");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    public void printTicketNumber(int ticketNumber) {
        System.out.printf(ConsoleMessage.TICKET_NUMBER.message, ticketNumber);
    }

    public void printUserLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public void printLottoResult(LottoResult lottoResult, int purchaseAmount) {
        System.out.println(ConsoleMessage.RESULT_HEADER.message);

        printMatchResults(lottoResult);

        System.out.printf(ConsoleMessage.EARNINGS_RATE_FORMAT.message,
            lottoResult.calculateEarningsRate(purchaseAmount));
    }

    private void printMatchResults(LottoResult lottoResult) {
        for (MatchCount matchCount : MatchCount.values()) {
            printSingleMatchResult(matchCount, lottoResult);
        }
    }

    private void printSingleMatchResult(MatchCount matchCount, LottoResult lottoResult) {
        String matchDescription = getMatchDescription(matchCount);
        System.out.printf(String.valueOf(ConsoleMessage.MATCH_FORMAT),
            matchDescription,
            matchCount.getReward(),
            lottoResult.getCount(matchCount));
    }

    private String getMatchDescription(MatchCount matchCount) {
        if (matchCount.isBonusMatching()) {
            return matchCount.getMatchCount() + "개 일치, 보너스 볼 일치";
        }
        return matchCount.getMatchCount() + "개 일치";
    }

}
