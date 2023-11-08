package lotto.service;

import lotto.model.Lotto;

import java.util.List;

public class LottoMatchChecker {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;


    public int[] checkMatches(List<Lotto> lottoTickets) {
        int[] matchCounts = new int[8];

        for (Lotto ticket : lottoTickets) {
            int matchCount = ticket.countMatchingNumbers(winningNumbers);
            if (matchCount == 5 && ticket.contains(bonusNumber)) {
                matchCounts[7]++;
            } else {
                matchCounts[matchCount]++;
            }
        }

        return matchCounts;
    }

    public LottoMatchChecker(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int countMatchedTickets(List<List<Integer>> tickets, int matchCount) {
        return (int) tickets.stream()
                .filter(ticket -> countMatches(ticket) == matchCount)
                .count();
    }

    public int countMatchedTicketsWithBonus(List<List<Integer>> tickets) {
        return (int) tickets.stream()
                .filter(ticket -> countMatches(ticket) == 5 && ticket.contains(bonusNumber))
                .count();
    }

    private long countMatches(List<Integer> ticket) {
        return winningNumbers.stream()
                .filter(ticket::contains)
                .count();
    }
}
