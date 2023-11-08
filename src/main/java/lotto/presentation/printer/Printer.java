package lotto.presentation.printer;

import java.util.Collections;
import java.util.List;

public class Printer {
    public static void printTickets(List<List<Integer>> tickets) {
        int count = tickets.size();
        System.out.println(count + "개를 구매했습니다.");
        for(List<Integer> ticket : tickets) {
            Collections.sort(ticket);
            System.out.println(ticket);
        }
    }
}
