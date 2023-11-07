package lotto.service;

import java.util.List;

public class LottoMatchChecker {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

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
