package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.constant.constant.*;

public class JudgeWinningTickets {

    private static int compareTicketNumbers(List<Integer> ticketNumbers, List<Integer> winningTicketNumbers) {
        int matchCount = MATCH_INITIALIZE_NUMBER;
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
        int rank = RANK_INITIALIZE;
        int matchCount = compareTicketNumbers(ticketNumbers, winningTicketNumbers);
        boolean matchBonusNumber = compareBonusNumber(bonusNumber, winningTicketNumbers);
        if (matchCount == MATCH_6_NUMBER) {
            rank = RANK_ONE;
        } else if (matchCount == MATCH_5_NUMBER && matchBonusNumber == MATCH_BONUS_NUMBER) {
            rank = RANK_TWO;
        } else if (matchCount == MATCH_5_NUMBER) {
            rank = RANK_THREE;
        } else if (matchCount == MATCH_4_NUMBER) {
            rank = RANK_FOUR;
        } else if (matchCount == MATCH_3_NUMBER) {
            rank = RANK_FIVE;
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
            if (rank == RANK_ONE) {
                winningTicketsCount.put(RANK_ONE, (winningTicketsCount.get(RANK_ONE) + INCREMENT));
            } else if (rank == RANK_TWO) {
                winningTicketsCount.put(RANK_TWO, (winningTicketsCount.get(RANK_TWO) + INCREMENT));
            } else if (rank == RANK_THREE) {
                winningTicketsCount.put(RANK_THREE, (winningTicketsCount.get(RANK_THREE) + INCREMENT));
            } else if (rank == RANK_FOUR) {
                winningTicketsCount.put(RANK_FOUR, (winningTicketsCount.get(RANK_FOUR) + INCREMENT));
            } else if (rank == RANK_FIVE) {
                winningTicketsCount.put(RANK_FIVE, (winningTicketsCount.get(RANK_FIVE) + INCREMENT));
            }
        }
        return winningTicketsCount;
    }
}
