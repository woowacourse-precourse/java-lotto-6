package lotto.lottosystem.presentation.printer;

import lotto.lottosystem.bussiness.Lotto;

import java.util.Collections;
import java.util.List;

public class Printer {
    public static void printTickets(TicketsVO ticketsVO) {
        List<Lotto> tickets = ticketsVO.tickets();
        int count = tickets.size();
        System.out.println(count + "개를 구매했습니다.");
        for(Lotto ticket : tickets) {
            Collections.sort(ticket.getNumbers());
            System.out.println(ticket.getNumbers());
        }
        System.out.println();
    }

    public static void printStatistics(StatisticsVO stats) {
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + stats.win3Count() + "개");
        System.out.println("4개 일치 (50,000원) - " + stats.win4Count() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + stats.win5Count() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + stats.win5WithBonusCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + stats.win6Count() + "개");
        System.out.printf("총 수익률은 %.2f%%입니다.%n", stats.revenueRatio());
    }
}
