package lotto.view.outputView;

import java.util.List;


public class LottoPrintOutput {

    public void printTickets(List<List<Integer>> tickets) {
        System.out.println("총 " + tickets.size() + "개의 티켓을 구매했습니다.");
        for (List<Integer> ticket : tickets) {
            System.out.println(ticket.toString());
        }
    }
}



