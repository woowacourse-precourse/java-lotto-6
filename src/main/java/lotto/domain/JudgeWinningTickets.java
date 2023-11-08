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


    private static Rank ranking(List<Integer> ticketNumbers, int bonusNumber, List<Integer> winningTicketNumbers) {
        Rank rank = Rank.INITIALIZE;
        int matchCount = compareTicketNumbers(ticketNumbers, winningTicketNumbers);
        boolean matchBonusNumber = compareBonusNumber(bonusNumber, winningTicketNumbers);
        if (matchCount == MATCH_6_NUMBER) {
            rank = Rank.FIRST;
        } else if (matchCount == MATCH_5_NUMBER && matchBonusNumber == MATCH_BONUS_NUMBER) {
            rank = Rank.SECOND;
        } else if (matchCount == MATCH_5_NUMBER) {
            rank = Rank.THIRD;
        } else if (matchCount == MATCH_4_NUMBER) {
            rank = Rank.FOURTH;
        } else if (matchCount == MATCH_3_NUMBER) {
            rank = Rank.FIFTH;
        }
        return rank;
    }

    public Map<Integer, Integer> countWinningTickets(int ticketCount, List<List<Integer>> lotteryTickets, List<Integer> winningTicketNumbers, int bonusNumber) {
        Map<Integer, Integer> winningTicketsCount = new HashMap<>();

        for (int i = 0; i < ticketCount; i++) {
            winningTicketsCount.put(i + 1, 0);
        }

        for (int i = 0; i < ticketCount; i++) {
            List<Integer> ticketNumbers = lotteryTickets.get(i);
            Rank rank = ranking(ticketNumbers, bonusNumber, winningTicketNumbers);
            if (rank == Rank.FIRST) {
                winningTicketsCount.put(rank.ordinal(), (winningTicketsCount.get(rank.ordinal()) + INCREMENT));
            } else if (rank == Rank.SECOND) {
                winningTicketsCount.put(rank.ordinal(), (winningTicketsCount.get(rank.ordinal()) + INCREMENT));
            } else if (rank == Rank.THIRD) {
                winningTicketsCount.put(rank.ordinal(), (winningTicketsCount.get(rank.ordinal()) + INCREMENT));
            } else if (rank == Rank.FOURTH) {
                winningTicketsCount.put(rank.ordinal(), (winningTicketsCount.get(rank.ordinal()) + INCREMENT));
            } else if (rank == Rank.FIFTH) {
                winningTicketsCount.put(rank.ordinal(), (winningTicketsCount.get(rank.ordinal()) + INCREMENT));
            }
        }
        return winningTicketsCount;
    }
}
