package model;

import model.LottoResult;

import java.util.*;
import java.util.stream.Collectors;

public class LottoModel {
    public List<List<Integer>> generateLottoTickets(int numberOfTickets) {
        List<List<Integer>> tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> ticket = generateRandomLotto();
            tickets.add(ticket);
        }
        return tickets;
    }

    public List<Integer> generateRandomLotto() {
        List<Integer> lotto = new ArrayList<>();
        Random random = new Random();
        while (lotto.size() < 6) {
            int number = random.nextInt(45) + 1;
            if (!lotto.contains(number)) {
                lotto.add(number);
            }
        }
        return lotto.stream().sorted().collect(Collectors.toList());
    }

    public List<LottoResult> calculateResults(List<List<Integer>> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        List<LottoResult> results = new ArrayList<>();
        for (List<Integer> ticket : lottoTickets) {
            int matchingCount = countMatchingNumbers(ticket, winningNumbers);
            boolean hasBonusNumber = ticket.contains(bonusNumber);

            LottoResult result = determineResult(matchingCount, hasBonusNumber);
            results.add(result);
        }
        return results;
    }

    private int countMatchingNumbers(List<Integer> ticket, List<Integer> winningNumbers) {
        return (int) ticket.stream().filter(winningNumbers::contains).count();
    }

    private LottoResult determineResult(int matchingCount, boolean hasBonusNumber) {
        if (matchingCount == 6) {
            return LottoResult.FIRST;
        } else if (matchingCount == 5 && hasBonusNumber) {
            return LottoResult.SECOND;
        } else if (matchingCount == 5) {
            return LottoResult.THIRD;
        } else if (matchingCount == 4) {
            return LottoResult.FOURTH;
        }
        return LottoResult.FIFTH;

    }
}
