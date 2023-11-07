package lotto.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoPrizeCalculator {
    private static final int PRIZE_FOR_3_MATCHES = 5000;
    private static final int PRIZE_FOR_4_MATCHES = 50000;
    private static final int PRIZE_FOR_5_MATCHES = 1500000;
    private static final int PRIZE_FOR_5_PLUS_BONUS_MATCHES = 30000000;
    private static final int PRIZE_FOR_6_MATCHES = 2000000000;

    private List<Integer> winningNumbers;
    private int bonusNumber;
    private Map<Integer, Integer> prizeCountMap;
    private Map<Integer, Integer> matchToPrizeMap;

    public LottoPrizeCalculator(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.prizeCountMap = new HashMap<>();
        this.matchToPrizeMap = new HashMap<>();
        initializePrizeCountMap();
        initializeMatchToPrizeMap();
    }

    private void initializePrizeCountMap() {
        prizeCountMap.put(PRIZE_FOR_3_MATCHES, 0);
        prizeCountMap.put(PRIZE_FOR_4_MATCHES, 0);
        prizeCountMap.put(PRIZE_FOR_5_MATCHES, 0);
        prizeCountMap.put(PRIZE_FOR_5_PLUS_BONUS_MATCHES, 0);
        prizeCountMap.put(PRIZE_FOR_6_MATCHES, 0);
    }

    private void initializeMatchToPrizeMap() {
        matchToPrizeMap.put(3, PRIZE_FOR_3_MATCHES);
        matchToPrizeMap.put(4, PRIZE_FOR_4_MATCHES);
        matchToPrizeMap.put(5, PRIZE_FOR_5_MATCHES);
        matchToPrizeMap.put(6, PRIZE_FOR_6_MATCHES);
    }

    public void calculateStatistics(List<LottoTicket> purchasedTickets) {
        for (LottoTicket ticket : purchasedTickets) {
            int matchCount = getMatchCount(ticket.getNumbers());
            boolean bonusMatch = ticket.getNumbers().contains(bonusNumber);
            incrementPrizeCount(matchCount, bonusMatch);
        }
    }

    private int getMatchCount(List<Integer> ticketNumbers) {
        return (int) ticketNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private void incrementPrizeCount(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            prizeCountMap.merge(PRIZE_FOR_5_PLUS_BONUS_MATCHES, 1, Integer::sum);
            return;
        }

        Integer prize = matchToPrizeMap.get(matchCount);
        if (prize != null) {
            prizeCountMap.merge(prize, 1, Integer::sum);
        }
    }

    public Map<Integer, Integer> getPrizeCountMap() {
        return prizeCountMap;
    }
}
