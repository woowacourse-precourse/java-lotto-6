package lotto.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void printLotteryTickets(int ticketCount, List<Integer> LotteryNumbers) {
        System.out.println(ticketCount + "개를 구매했습니다. ");
    }

    public void printWinningLotteryTickets(Map<Integer, Integer> winningLotteryTickets) {
        System.out.println(winningLotteryTickets);
    }

}
