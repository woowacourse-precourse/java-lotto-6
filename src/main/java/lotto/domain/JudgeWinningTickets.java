package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JudgeWinningTickets {

    private static int compareTicketNumbers(List<Integer> ticketNumbers, List<Integer> winningTicketNumbers) {
        int matchCount = 0;
        for (int i : winningTicketNumbers) {
            if (ticketNumbers.contains(i))
                matchCount++;
        }
        return matchCount;
    }

    private static boolean compareBonusNumber(int bonusNumber, List<Integer> winningTicketNumbers) {
        if (winningTicketNumbers.contains(bonusNumber))
            return true;
        return false;
    }

    private static int ranking(List<Integer> ticketNumbers, int bonusNumber, List<Integer> winningTicketNumbers) {
        int rank = 0;
        int matchCount = compareTicketNumbers(ticketNumbers, winningTicketNumbers);
        boolean matchBonusNumber = compareBonusNumber(bonusNumber, winningTicketNumbers);
        if (matchCount == 6) {
            rank = 1;
        } else if (matchCount == 5 && matchBonusNumber == true) {
            rank = 2;
        } else if (matchCount == 5) {
            rank = 3;
        } else if (matchCount == 4) {
            rank = 4;
        } else if (matchCount == 3) {
            rank = 5;
        }
        return rank;
    }

    public Map<Integer, Integer> countWinningTickets(int ticketCount, List<List<Integer>> lotteryTickets, List<Integer> winningTicketNumbers, int bonusNumber) {
        Map<Integer, Integer> winningTicketsCount = new HashMap<Integer, Integer>();

        for (int i = 0; i < ticketCount; i++) {
            winningTicketsCount.put(i + 1, 0);
        }

        for (int i = 0; i < ticketCount; i++) {
            List<Integer> ticketNumbers = lotteryTickets.get(i);
            int rank = ranking(ticketNumbers, bonusNumber, winningTicketNumbers);
            if (rank == 1) {
                winningTicketsCount.put(1, (winningTicketsCount.get(1) + 1));
            } else if (rank == 2) {
                winningTicketsCount.put(2, (winningTicketsCount.get(2) + 1));
            } else if (rank == 3) {
                winningTicketsCount.put(3, (winningTicketsCount.get(3) + 1));
            } else if (rank == 4) {
                winningTicketsCount.put(4, (winningTicketsCount.get(4) + 1));
            } else if (rank == 5) {
                winningTicketsCount.put(5, (winningTicketsCount.get(5) + 1));
            }
        }
        return winningTicketsCount;
    }
}
