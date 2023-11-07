package lotto.io;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.Ticket;
import lotto.service.TicketService;

public class Output {
    private static final String OUTPUT_TICKET_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String NOTICE_MESSAGE = "당첨 통계\n---";
    private static final String PRINT_MATCH_BONUS_NUMBER_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n";
    private static final String PRINT_MATCH_MASSAGE = "%d개 일치 (%,d원) - %d개%n";
    private static final String PRINT_PROFIT_RATE_MESSAGE = "총 수익률은 %s%%입니다.%n";

    public static void printTicket(Ticket ticket) {
        List<Lotto> lottos = ticket.getLottos();
        System.out.println(ticket.getLottos().size() + OUTPUT_TICKET_AMOUNT_MESSAGE);
        lottos.forEach(Lotto::printLotto);
    }

    public static void printStatistics(EnumMap<Prize, Integer> statistics) {
        System.out.println(NOTICE_MESSAGE);
        statistics.forEach((prize, count) -> {
            if (prize == Prize.SECOND) {
                System.out.printf(PRINT_MATCH_BONUS_NUMBER_MESSAGE,
                        prize.getMatchCount(),
                        prize.getPrizeMoney(),
                        count);
                return;
            }
            System.out.printf(PRINT_MATCH_MASSAGE,
                    prize.getMatchCount(),
                    prize.getPrizeMoney(),
                    count);
        });
    }

    public static void printProfitRate(
            Ticket ticket,
            List<Integer> winningNumbers,
            int bonusNumber)
    {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.0");
        double profitRate = TicketService.getProfitRate(ticket, winningNumbers, bonusNumber);
        System.out.printf(PRINT_PROFIT_RATE_MESSAGE, decimalFormat.format(profitRate));
    }
}
