package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.dto.LottoTicket;
import lotto.dto.StatisticsResult;

public class OutputView {

    public static void printTickets(List<LottoTicket> tickets) {
        System.out.printf(Message.LOTTO_COUNT_MESSAGE.toString(), tickets.size());
        tickets.forEach(OutputView::printTicket);
    }

    private static void printTicket(LottoTicket ticket) {
        System.out.printf(Message.TICKET_MESSAGE.toString(), ticket);
    }

    public static void printStatistics(StatisticsResult response) {
        System.out.println(Message.STATISTICS_MESSAGE);
        System.out.println(Message.SEPARATOR_LINE_MESSAGE);
        printCountingResponse(response.prizeCount());
        printRevenue(response.prizeMoney(), response.payment());
    }

    private static void printCountingResponse(Map<String, Integer> counter) {
        System.out.printf(Message.FIFTH_PRIZE_MESSAGE.toString(), counter.get("FIFTH"));
        System.out.printf(Message.FOURTH_PRIZE_MESSAGE.toString(), counter.get("FOURTH"));
        System.out.printf(Message.THIRD_PRIZE_MESSAGE.toString(), counter.get("THIRD"));
        System.out.printf(Message.SECOND_PRIZE_MESSAGE.toString(), counter.get("SECOND"));
        System.out.printf(Message.FIRST_PRIZE_MESSAGE.toString(), counter.get("FIRST"));
    }

    private static void printRevenue(int prizeMoney, int payment) {
        System.out.printf(Message.REVENUE_MESSAGE.toString(), ((double) prizeMoney / payment) * 100);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
