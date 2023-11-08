package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    private static final String START_RESULT_MESSAGE = "당첨 통계";
    private static final String SEPARATOR_LINE ="---";
    private static final String TICKET_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String RANK_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String BONUS_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String PROFITABILITY_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printAllTickets(List<Lotto> tickets){
        System.out.println(String.format(TICKET_COUNT_MESSAGE, tickets.size()));
        for (Lotto ticket : tickets) {
            System.out.println(ticket.toString());
        }
    }

    public void printRankResult(int[] rankCount, double profitability){
        System.out.println(START_RESULT_MESSAGE);
        System.out.println(SEPARATOR_LINE);
        System.out.println(String.format(RANK_RESULT_MESSAGE, 3, "5,000", rankCount[0]));
        System.out.println(String.format(RANK_RESULT_MESSAGE, 4, "50,000", rankCount[1]));
        System.out.println(String.format(RANK_RESULT_MESSAGE, 5, "1,500,000", rankCount[2]));
        System.out.println(String.format(BONUS_RESULT_MESSAGE, 5, "30,000,000", rankCount[3]));
        System.out.println(String.format(RANK_RESULT_MESSAGE, 6, "2,000,000,000", rankCount[4]));
        System.out.println(String.format(PROFITABILITY_MESSAGE, profitability));
    }
}
