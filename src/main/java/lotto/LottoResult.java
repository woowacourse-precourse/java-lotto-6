package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final Map<String, Integer> PRIZE_MONEY = new HashMap<>();

    static {
        PRIZE_MONEY.put("3", 5000);
        PRIZE_MONEY.put("4", 50000);
        PRIZE_MONEY.put("5", 1500000);
        PRIZE_MONEY.put("5+bonus", 30000000);
        PRIZE_MONEY.put("6", 2000000000);
    }

    public Map<String, Integer> checkResults(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        Map<String, Integer> matchCounts = new HashMap<>();

        for (Lotto ticket : lottoTickets) {
            int matchCount = countMatches(ticket.getNumbers(), winningNumbers);

            if (matchCount == 5 && ticket.getNumbers().contains(bonusNumber)) {
                matchCounts.put("5+bonus", matchCounts.getOrDefault("5+bonus", 0) + 1);
                continue;
            }

            matchCounts.put(String.valueOf(matchCount), matchCounts.getOrDefault(String.valueOf(matchCount), 0) + 1);
        }

        return matchCounts;
    }

    private int countMatches(List<Integer> ticketNumbers, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : ticketNumbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public static Map<String, Integer> getPrizeMoney() {
        return PRIZE_MONEY;
    }
}
