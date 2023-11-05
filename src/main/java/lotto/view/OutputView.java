package lotto.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {

    private List<Integer> ticketNumbers;

    public void printLotteryTickets(int ticketCount, List<List<Integer>> lotteryTickets) {
        System.out.println(ticketCount + "개를 구매했습니다. \n");
        for(int i=0; i<ticketCount; i++) {
            ticketNumbers = lotteryTickets.get(i);
            System.out.print(ticketNumbers + "\n");
        }
    }

    public void printWinningLotteryTickets(Map<Integer, Integer> winningLotteryTickets) {
        System.out.println(winningLotteryTickets);
    }

}
