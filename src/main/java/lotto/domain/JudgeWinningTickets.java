package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class JudgeWinningTickets {

    private static int compareWinningTicketNumbers() {
        int matchCount = 0;
        return matchCount;
    }

    private static boolean compareBonusNumber() {
        return false;
    }

    private static int ranking() {
        int rank = 0;
        int matchCount = compareWinningTicketNumbers();
        boolean bonusNumber = compareBonusNumber();
        return rank;
    }

    public Map<Integer, Integer> countWinningTickets(int ticketCount) {
        Map<Integer, Integer> winningTicketsCount = new HashMap<Integer, Integer>();

        for(int i=0; i<ticketCount; i++) {
            winningTicketsCount.put(i+1, 0);
        }

        for(int i=0; i<ticketCount; i++) {
            int rank = ranking();
            if(rank == 1) {
                winningTicketsCount.put(1, (winningTicketsCount.get(1)+1));
            }
        }
        return winningTicketsCount;
    }
}
