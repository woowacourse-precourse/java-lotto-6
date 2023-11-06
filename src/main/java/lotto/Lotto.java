package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    private static final int MIN_MATCHES_FOR_WIN = 3;
    private static final int MAX_MATCHES_FOR_WIN = 6;
    private int bonusCount = 0;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public Map<Integer, Integer> winningStatistics(List<List<Integer>> ticketNumbers, int bonusNumber) {
        List<Integer> matchedNumberCount = matchNumbers(ticketNumbers, bonusNumber);
        Map<Integer, Integer> winningStatistics = addWinningStatistics(matchedNumberCount);
        winningStatistics.put(2,bonusCount);
        return winningStatistics;
    }

    private List<Integer> matchNumbers(List<List<Integer>> ticketNumbers, int bonusNumber) {
        List<Integer> matchedNumberCount = new ArrayList<>();
        for (List<Integer> ticket : ticketNumbers) {
            Set<Integer> matchedNumbers = new HashSet<>(ticket);
            matchedNumbers.retainAll(numbers);
            if(matchedNumbers.size() == 5){
                if(matchedBonus(ticket, bonusNumber)) addBonus();
                else if(!matchedBonus(ticket, bonusNumber)) matchedNumberCount.add(matchedNumbers.size());
            }
            else if(matchedNumbers.size() != 5) matchedNumberCount.add(matchedNumbers.size());
        }
        return matchedNumberCount;
    }

    private Map<Integer, Integer> addWinningStatistics(List<Integer> matchedNumberCount) {
        Map<Integer, Integer> winningStatistics = new HashMap<>();
        for (int count : matchedNumberCount) {
            winningStatistics.put(count, winningStatistics.getOrDefault(count, 0) + 1);
        }
        for (int i = MIN_MATCHES_FOR_WIN; i <= MAX_MATCHES_FOR_WIN; i++) {
            winningStatistics.putIfAbsent(i, 0);
        }
        return winningStatistics;
    }

    private boolean matchedBonus(List<Integer> ticketNumbers, int bonusNumber){
        return ticketNumbers.contains(bonusNumber);
    }

    private void addBonus(){
        bonusCount++;
    }
}
