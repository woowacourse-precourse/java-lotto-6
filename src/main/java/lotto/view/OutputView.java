package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.Prize;
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
        Arrays.stream(Prize.values())
                .forEach(prize -> System.out.printf(prize.toString(), counter.get(prize.name())));
    }

    private static void printRevenue(int prizeMoney, int payment) {
        System.out.printf(Message.REVENUE_MESSAGE.toString(), ((double) prizeMoney / payment) * 100);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
