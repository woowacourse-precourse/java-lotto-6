package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.CheckTickets;
import java.util.*;

public class Output {
    public void printTickets(List<Lotto> ticketList) {
        System.out.printf("\n%d개를 구매했습니다.\n", ticketList.size());
        for (Lotto ticket : ticketList) {
            System.out.println(ticket);
        }
    }

    public void printResults(int[] matchCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (CheckTickets idx : CheckTickets.values()) {
            System.out.print(idx);
            System.out.printf("- %d개\n", matchCount[idx.ordinal()]);
        }
    }

    public void printRevenue(double revenue) {
        System.out.printf("총 수익률은 %,.1f%%입니다.\n", revenue);
    }

    public void printError(IllegalArgumentException e) {
        System.out.print("[ERROR] ");
        System.out.println(e.getMessage());
    }
}