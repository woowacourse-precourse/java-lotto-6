package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    private static final int MIN_MATCHES_FOR_WIN = 3;
    private static final int MAX_MATCHES_FOR_WIN = 6;

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

    public Map<Integer, Integer> winningStatistics(List<List<Integer>> ticketNumbers) {
        List<Integer> matchedNumberCount = matchNumbers(ticketNumbers);
        return addWinningStatistics(matchedNumberCount);
    }

    private List<Integer> matchNumbers(List<List<Integer>> ticketNumbers) {
        List<Integer> matchedNumberCount = new ArrayList<>();
        for (List<Integer> ticket : ticketNumbers) {
            Set<Integer> matchedNumbers = new HashSet<>(ticket);
            matchedNumbers.retainAll(numbers);

            matchedNumberCount.add(matchedNumbers.size());
        }
        System.out.println(matchedNumberCount);
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

}
