package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.MatchCount;
import lotto.utils.Constants;

public class OutputView {

    private enum ConsoleMessage {
        TICKET_NUMBER("\n%d개를 구매했습니다.\n"),
        RESULT_HEADER("\n당첨 통계\n---\n"),
        MATCH_FORMAT("%s (%s원) - %d개\n"),
        EARNINGS_RATE_FORMAT("총 수익률은 %.1f%%입니다.\n"),
        MATCH_MESSAGE("개 일치"),
        BONUS_MATCH_MESSAGE("보너스 볼 일치");

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
        System.out.printf(ConsoleMessage.RESULT_HEADER.message);

        printMatchResults(lottoResult);

        System.out.printf(ConsoleMessage.EARNINGS_RATE_FORMAT.message,
            lottoResult.calculateRoundedEarningsRate(purchaseAmount));
    }

    private void printMatchResults(LottoResult lottoResult) {
        Arrays.stream(MatchCount.values())
            .filter(matchCount -> matchCount.getReward() != Constants.NON_REWARD)
            .forEach(matchCount -> printSingleMatchResult(matchCount, lottoResult));
    }

    private void printSingleMatchResult(MatchCount matchCount, LottoResult lottoResult) {
        String matchDescription = getMatchDescription(matchCount);
        System.out.printf(String.valueOf(ConsoleMessage.MATCH_FORMAT.message),
            matchDescription,
            matchCount.getFormattedReward(),
            lottoResult.getMatchedTicketCount(matchCount));
    }

    private String getMatchDescription(MatchCount matchCount) {
        if (matchCount.isBonusMatching()) {
            return matchCount.getMatchCount() + ConsoleMessage.MATCH_MESSAGE.message + ", "
                + ConsoleMessage.BONUS_MATCH_MESSAGE.message;
        }
        return matchCount.getMatchCount() + ConsoleMessage.MATCH_MESSAGE.message;
    }

}
