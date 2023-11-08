package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analyzer {
    public int check(List<Integer> winningNumbers, List<Integer> ticketNumbers, int bonusNumber) {
        int matchedCount = countMatchingNumbers(winningNumbers, ticketNumbers);
        boolean bonusNumberMatched = ticketNumbers.contains(bonusNumber);
        if (matchedCount == 6) {
            return 1;
        }
        if (matchedCount == 5 && bonusNumberMatched) {
            return 2;
        }
        if (matchedCount == 5) {
            return 3;
        }
        if (matchedCount == 4) {
            return 4;
        }
        if (matchedCount == 3) {
            return 5;
        }
        return 0;
    }

    public Map<Integer, Integer> fillTicketResults(int ticket, List<Integer> winningNumbers,
                                                   List<Integer> allTicketNumbers, int bonusNumber) {
        Map<Integer, Integer> ticketResults = new HashMap<>();
        for (int i = 0; i < ticket; i++) {
            int rank = check(winningNumbers, allTicketNumbers, bonusNumber);
            ticketResults.putIfAbsent(rank, 0);
            ticketResults.put(rank, ticketResults.get(rank) + 1);
        }
        return ticketResults;
    }

    private int countMatchingNumbers(List<Integer> winningNumbers, List<Integer> ticketNumbers) {
        int count = 0, i = 0, j = 0;
        while (i < winningNumbers.size() && j < ticketNumbers.size()) {
            int compare = Integer.compare(winningNumbers.get(i), ticketNumbers.get(j));
            if (compare == 0) {
                count++;
                i++;
                j++;
            } else if (compare < 0) i++;
            else j++;
        }
        return count;
    }
}