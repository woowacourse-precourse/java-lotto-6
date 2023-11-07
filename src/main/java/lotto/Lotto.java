package lotto;

import lotto.exception.InputValidator;
import lotto.lottery.Bonus;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    Bonus bonus = new Bonus();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private enum MatchesForWin {
        MIN(3), MAX(6);
        private final int count;

        MatchesForWin(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }
    }

    private void validate(List<Integer> numbers) {
        InputValidator inputValidator = new InputValidator();
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        inputValidator.checkWinningNumbers(numbers);
    }

    // TODO: 추가 기능 구현
    public Map<Integer, Integer> winningStatistics(List<List<Integer>> ticketNumbers, int bonusNumber) {
        List<Integer> matchedNumberCount = matchNumbers(ticketNumbers, bonusNumber);
        Map<Integer, Integer> winningStatistics = addWinningStatistics(matchedNumberCount);
        return winningStatistics;
    }

    private List<Integer> matchNumbers(List<List<Integer>> ticketNumbers, int bonusNumber) {
        List<Integer> matchedNumberCount = new ArrayList<>();
        int bonusCount = 0;
        for (List<Integer> ticket : ticketNumbers) {
            Set<Integer> matchedNumbers = new HashSet<>(ticket);
            matchedNumbers.retainAll(numbers);
            if (matchedNumbers.size() == 5) {
                if (matchedBonus(ticket, bonusNumber)) bonusCount++;
                else if (!matchedBonus(ticket, bonusNumber)) matchedNumberCount.add(matchedNumbers.size());
            } else if (matchedNumbers.size() != 5) matchedNumberCount.add(matchedNumbers.size());
        }
        bonus.setBonusCount(bonusCount);
        return matchedNumberCount;
    }

    private Map<Integer, Integer> addWinningStatistics(List<Integer> matchedNumberCount) {
        Map<Integer, Integer> winningStatistics = new HashMap<>();
        for (int count : matchedNumberCount) {
            winningStatistics.put(count, winningStatistics.getOrDefault(count, 0) + 1);
        }
        for (int i = MatchesForWin.MIN.getCount(); i <= MatchesForWin.MAX.getCount(); i++) {
            winningStatistics.putIfAbsent(i, 0);
        }
        winningStatistics.put(2, bonus.getBonusCount());
        return winningStatistics;
    }

    private boolean matchedBonus(List<Integer> ticketNumbers, int bonusNumber) {
        return ticketNumbers.contains(bonusNumber);
    }
}
