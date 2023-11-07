package lotto.io.output;

import lotto.constant.message.ProcessMessage;
import lotto.domain.Lottos;
import lotto.domain.Ticket;
import lotto.domain.WinningStatistic;

public class OutputView {

    private final OutputFommatter outputFommatter;

    public OutputView(OutputFommatter outputFommatter) {
        this.outputFommatter = outputFommatter;
    }

    public void printPurchaseAmountRequset() {
        System.out.println(ProcessMessage.PURCHASE_AMOUNT_REQUSET.toMessage());
    }

    public void printNumberOfTicket(final Ticket ticket) {
        System.out.println(ProcessMessage.NEW_LINE.toMessage() + outputFommatter.toNumberOfTicket(ticket));
    }

    public void printNumberOfLottos(final Lottos lottos) {
        System.out.println(outputFommatter.toLottos(lottos));
    }

    public void printWinningLottoRequset() {
        System.out.println(ProcessMessage.WINNING_LOTTO_REQUEST.toMessage());
    }

    public void printBonusNumberRequset() {
        System.out.println();
        System.out.println(ProcessMessage.BONUS_NUMBER_REQUEST.toMessage());
    }

    public void printResultLotto(final WinningStatistic winningStatistic) {
        System.out.println();
        System.out.println(ProcessMessage.WINNING_STATISTICS.toMessage());
        System.out.println(ProcessMessage.STATISTICS_DELIMITER.toMessage());
        System.out.println(outputFommatter.toLottoResult(winningStatistic));
    }

    public void printTotalPrize(final String profit) {
        System.out.println(outputFommatter.toLottoProfit(profit));
    }

    public void printExceptionMessage(final IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
